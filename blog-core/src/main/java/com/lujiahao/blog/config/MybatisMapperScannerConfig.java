package com.lujiahao.blog.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * @author lujiahao
 * @date 2018-06-07 下午9:29
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisMapperScannerConfig {

    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.lujiahao.blog.mapper");
        return mapperScannerConfigurer;
    }
}

