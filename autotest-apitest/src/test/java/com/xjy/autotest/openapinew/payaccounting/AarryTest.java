package com.xjy.autotest.openapinew.payaccounting;

import static sun.misc.Version.print;

/**
 *@ClassName AarryTest
 *@Author noodles
 *@Date 2019/7/13 8:52
 *@Version 1.0
 * 服务应用场景：该服务是在用户在电商平台完成额度申请审核通过后，接着在电商平台成功下单需要支付时，跳到支付机构收银台，点击所显示“白条支付”按钮，
 * 会调该服务完成贷款申请， 贷款申请成功后完成交易订单支付。
 *
 * 开发实现逻辑：订单幂等性校验=>校验用户是否存在=>校验消金公司保证金是否足额=>校验用户授信余额是否充足=>过风控审核=>减少信用额度=>
 * 持久化订单并返回=>异步同步数据至数据中心（不影响成功） 计息公式xxxx；
 *
 * 用例整体设计：（非用例项设计）该用例执行需开发的基础数据xxxx.sql；该用例的xxx数据采用sql/动态插入数据准备；
 *
 * 涉及系统（表名）：系统英文名{表名（作用）}
 *
 * 特别注意：
 *
 **/
public class AarryTest {

public static void main(String[] args){
    String a="123";
    String b="123";
    String c=new String("123");
    String d=new String ("123");
    System.out.println(a==b);
    System.out.println(c==d);
    System.out.println(a==c);
    System.out.println(a.equals(c));
}



//
//    public static void main(String[] args) {
////        int [][] arr2={{1,1,1,1},{2,2,2},{3,3},{4}};
////        for(int i=0;i<4;i++){
////            for(int j=0;j<arr2[i].length;j++){
////                System.out.print(arr2[i][j]+" ");
////            }
////            System.out.println();
////        }
//
//        int [][] arr=new int[4][];
//        int k=4;
//        int i=0;
//        int j=0;
//        for( i=0;i<4;i++){
////            arr[i]=new int[k-1];
//            for(j=0;j<arr[i].length;j++){
//                    arr[i][j]=i+1;
//                    System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }

}
