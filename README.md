为什么要用AutoTest？
==========
    1.自动生成测试用例
    
    2.测试代码更简洁，面对对象编码
    
    3.数据准备更方便，可根据需要自动生成csv
    
    4.数据验证更容易，直接断言数据库对象
    
    5.配置文件更简单，只需一个数据库连接配置
    
使用前
======
    因为JUnit 5仅支持jdk1.8及以上，所以需要先安装jdk1.8，安装教程请自行百度。

    IDE方面，Intellij IDEA2016.2开始对 JUnit 5支持 ，下载最新版本即可。

使用说明
========
    JUnit 5仍然支持对@Test 标记测试方法，但若要使用@AutoTest，需要测试方法至少有一个参数，并且file的值不为空。

示例：
~~~
@AutoTest(file = "/autotest/simpleTest.csv")

void simpleTest(int testId, String result) {

    System.out.println("这是第 " + testId + " 条测试用例");

    System.out.println(result);

}
~~~
simpleTest.csv文件的内容：
~~~
result,testId

SUCCESS,1001

FAIL,1002
~~~
csv文件第一行是参数名，参数名之间以英文逗号,隔开

csv文件第二行开始是参数值，与第一行参数名一一对应，从第二行开始，有几行则执行几次测试方法。

运行上面的测试方法后，结果如下：
~~~
这是第 1001 条测试用例

SUCCESS

这是第 1002 条测试用例

FAIL
~~~
