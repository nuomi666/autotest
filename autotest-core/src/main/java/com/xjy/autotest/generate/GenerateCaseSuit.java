package com.xjy.autotest.generate;

import com.xjy.autotest.base.AutoTestBase;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ychaoyang on 2017/9/19.
 */
public class GenerateCaseSuit extends AutoTestBase {

	protected final static Logger log = LoggerFactory.getLogger(GenerateCaseSuit.class);

	public void generate(String author, String projectName, Class<?> cla) {
		String packageName = cla.getPackage().getName();
		String dir = getClassFilePath(cla).replace("\\target\\test-classes", "\\src\\test\\java").replace(cla
				.getSimpleName() + ".class", "").replace(packageName.substring(packageName.lastIndexOf(".") + 1),
				projectName);
		File files = new File(dir);
		if (!files.exists() || !dir.contains(projectName)) {
			print("找不到测试类");
			return;
		}
		ArrayList list = new ArrayList();
		for (File file : files.listFiles()) {
			String fileName = file.getName().substring(0, file.getName().length() - 6);
			if (fileName.endsWith("Test")) {
				list.add(fileName);
			}
		}
		String className = toUpperCaseFirstOne(projectName) + "CaseSuit";
		String filePath = Thread.currentThread().getContextClassLoader().getResource("ftl/").getPath().replace
				("/target/test-classes","/src/test/resources");
		String outFile = getClassFilePath(cla).replace("\\target\\classes", "\\src\\test\\java")
				.replace(cla.getSimpleName() + ".class", className + ".java");
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
		try {
			cfg.setDirectoryForTemplateLoading(new File(filePath));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			Map<String, Object> root = new HashMap<String, Object>();
			root.put("packageName", packageName);
			root.put("projectName", projectName);
			root.put("projectUpName", projectName.toUpperCase());
			root.put("className", className);
			root.put("funcName", toLowerCaseFirstOne(className));
			root.put("author", author);
			root.put("time", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			root.put("list", list);
			Template template = cfg.getTemplate("generateSuit.ftl");
			if (new File(outFile).exists()) {
				logger.info("该文件已存在 ，{}", outFile);
				logger.info("是否覆盖？Y:继续/N:返回");
				Scanner s = new Scanner(System.in);
				String line = s.nextLine();
				if (!"Y".equalsIgnoreCase(line)) {
					return;
				}
			}
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
			try {
				template.process(root, out);
				System.out.println("更新成功" + outFile);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
