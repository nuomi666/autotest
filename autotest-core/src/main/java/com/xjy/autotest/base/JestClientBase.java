//package com.xjy.autotest.base;
//
//import com.google.common.collect.Maps;
//import io.searchbox.client.JestClient;
//import io.searchbox.client.JestClientFactory;
//import io.searchbox.client.JestResult;
//import io.searchbox.client.config.HttpClientConfig;
//import io.searchbox.core.Delete;
//import io.searchbox.core.Index;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * @ClassName JestClientBase
// * @Author noodles
// * @Date 2019/4/9 9:51
// * @Version 1.0
// * 服务应用场景：该服务是在用户在电商平台完成额度申请审核通过后，接着在电商平台成功下单需要支付时，跳到支付机构收银台，点击所显示“白条支付”按钮，
// * 会调该服务完成贷款申请， 贷款申请成功后完成交易订单支付。
// * <p>
// * 开发实现逻辑：订单幂等性校验=>校验用户是否存在=>校验消金公司保证金是否足额=>校验用户授信余额是否充足=>过风控审核=>减少信用额度=>
// * 持久化订单并返回=>异步同步数据至数据中心（不影响成功） 计息公式xxxx；
// * <p>
// * 用例整体设计：（非用例项设计）该用例执行需开发的基础数据xxxx.sql；该用例的xxx数据采用sql/动态插入数据准备；
// * <p>
// * 涉及系统（表名）：系统英文名{表名（作用）}
// * <p>
// * 特别注意：
// **/
//public class JestClientBase {
//    public static void main(String[] args) {
////        JestResult jestResult=new JestClientBase().insertES();
//        new JestClientBase().deleteIndex("noodles-index2");
////        System.out.println(jestResult);
//    }
//
//    protected JestClient initES(){
//        String connectionUrl="http://192.168.2.127:9200";
//        JestClientFactory factory=new JestClientFactory();
//        factory.setHttpClientConfig(new HttpClientConfig
//                .Builder(connectionUrl)//参数可以是集群，请先定义一个list集合，将节点url分别添加到list
//                .multiThreaded(true)//多线程模式
//                .connTimeout(60000)//连接超时
//                .readTimeout(60000)//由于是基于http，所以超时时间必不可少，不然经常会遇到socket异常：read time out
//                .build());//更多参数请查看API
//        JestClient jestClient=factory.getObject();
//        return  jestClient;
//    }
//
//    /**
//     * 创建索引和类型与数据
//     * @return
//     */
//    protected JestResult insertES(){
//        Map<String,Object> docData= Maps.newHashMap();
//        docData.put("employerNo","100001");
//        docData.put("employerName","撸到死");
//        docData.put("salesVolume","10000");
//        docData.put("salesVolume",10000);//整型
//        docData.put("salesVolume",false);//布尔类型
//        docData.put("salesVolume","10000");
//        docData.put("month","1月");
//        docData.put("raw_add_time","2018-07-26T14:42:04");//时间类型
//        docData.put("raw_update_time","2018-07-27T12:53:40");
//        Index index=new Index.Builder(docData).index("noodles-index2").type("noodles-type2").build();
//
//        JestResult jestResult=null;
//        try {
//            jestResult= initES().execute(index);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return jestResult;
//    }
//    protected  boolean deleteIndex(String indexName){
//        Delete.Builder builder=new Delete.Builder();
//        builder.index(indexName).build();
//        return true;
//    }
//}
