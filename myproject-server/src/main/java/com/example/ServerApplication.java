package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.example"})
//@ComponentScan(basePackages = "com.example") // 扫描 com.example 及其所有子包
@MapperScan("com.example.mapper")
//@EnableAspectJAutoProxy  // 启用 AspectJ 自动代理
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServerApplication.class, args);
    }
}
