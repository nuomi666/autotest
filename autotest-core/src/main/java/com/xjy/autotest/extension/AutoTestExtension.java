package com.xjy.autotest.extension;

import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.support.AnnotationConsumerInitializer;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static org.junit.platform.commons.util.AnnotationUtils.*;

/**
 * Created by ychaoyang on 2017/7/14.
 */
public class AutoTestExtension extends SpringExtension implements TestTemplateInvocationContextProvider, BeforeTestExecutionCallback {

    protected static final Logger logger = LoggerFactory.getLogger(AutoTestExtension.class.getName());

    private static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create("AutoTestExtension",
            "DataDeal");

    private int num = 0;

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        if (!context.getTestMethod().isPresent()) {
            return false;
        }

        Method testMethod = context.getTestMethod().get();
        if (!isAnnotated(testMethod, AutoTest.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        Method templateMethod = Preconditions.notNull(context.getTestMethod().orElse(null),
                "test method must not be null");
        AutoTestNameFormatter formatter = createNameFormatter(templateMethod);
        AtomicLong invocationCount = new AtomicLong(0L);
        return findRepeatableAnnotations(templateMethod, ArgumentsSource.class)
                .stream()
                .map(ArgumentsSource::value)
                .map(ReflectionUtils::newInstance)
                .map(provider -> AnnotationConsumerInitializer.initialize(templateMethod, provider))
                .flatMap(provider -> arguments(provider, context))
                .map(Arguments::get)
                .map(arguments -> createInvocationContext(formatter, arguments))
                .peek((invocationContext) -> {
                    invocationCount.incrementAndGet();
                }).onClose(() ->
                        Preconditions.condition(invocationCount.get() > 0,
                                "当使用注解 @AutoTest 的时候,测试方法需要至少一个参数"));

    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        Object testInstance = context.getTestInstance();
        Method testMethod = context.getTestMethod().get();
        getTestContextManager(context).beforeTestExecution(testInstance, testMethod);
        int times = context.getStore(NAMESPACE).get("times", int.class);
        String methodName = context.getStore(NAMESPACE).get("methodName", String.class);
        logger.info("========[{}]共执行[{}]次, 开始执行第[{}]轮========", methodName, times, num++ < times ? num : times);
    }


    private AutoTestNameFormatter createNameFormatter(Method templateMethod) {
        AutoTest autoTest = findAnnotation(templateMethod, AutoTest.class).get();
        String name = autoTest.name().trim();
        if (StringUtils.isBlank(name)) {
            logger.warn(String.format(
                    "Configuration error: @AutoTest on method [%s] must be declared with a non-empty name.",
                    templateMethod));
        }
        return new AutoTestNameFormatter(name);
    }

    protected static Stream<? extends Arguments> arguments(ArgumentsProvider provider, ExtensionContext context) {
        try {
            return provider.provideArguments(context);
        } catch (Exception e) {
            throw ExceptionUtils.throwAsUncheckedException(e);
        }
    }


    private TestTemplateInvocationContext createInvocationContext(AutoTestNameFormatter formatter, Object[] arguments) {
        return new AutoTestInvocationContext(formatter, arguments);
    }

    private static TestContextManager getTestContextManager(ExtensionContext context) {
        Assert.notNull(context, "ExtensionContext must not be null");
        Class<?> testClass = context.getTestClass().get();
        ExtensionContext.Store store = context.getStore(NAMESPACE);
        return store.getOrComputeIfAbsent(testClass, TestContextManager::new, TestContextManager.class);
    }


}
