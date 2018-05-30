package com.victorzhang.learn.distributed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 项目启动类
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 20:01:29
 */
@SpringBootApplication
public class WebApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }
}
