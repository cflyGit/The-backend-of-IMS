//package com.bupt.ims.common.lang;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class ReturnFilter<T> {
//    @Bean
//    public Result checkRes(List<T> list) {
//        if (list.size() > 0) {
//            return Result.success(list);
//        }
//        return Result.fail("无");
//    }
//
//    @Bean
//    public Result checkRes(boolean flag, String msg) {
//        if (flag) {
//            return Result.success(null);
//        }
//        return Result.fail(msg);
//    }
//
//    @Bean
//    public Result checkRes(T t){
//        if (t != null) {
//            return Result.success(t);
//        }
//        return Result.fail("无查询结果");
//    }
//}
