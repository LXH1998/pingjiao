package com.xiaohua.springbootpingjiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xiaohua.springbootpingjiao.mapper") //扫描的mapper
@SpringBootApplication
public class SpringbootPingjiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPingjiaoApplication.class, args);
    }

}
