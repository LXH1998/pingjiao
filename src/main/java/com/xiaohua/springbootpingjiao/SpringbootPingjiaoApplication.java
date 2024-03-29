package com.xiaohua.springbootpingjiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@MapperScan("com.xiaohua.springbootpingjiao.mapper") //扫描的mapper
@SpringBootApplication
public class SpringbootPingjiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPingjiaoApplication.class, args);
    }
    //这里配置静态资源文件的路径导包都是默认的直接导入就可以
//    @Override   extends WebMvcConfigurationSupport
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
//        super.addResourceHandlers(registry);
//    }

}
