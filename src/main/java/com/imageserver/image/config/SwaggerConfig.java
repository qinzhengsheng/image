package com.imageserver.image.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.imageserver.image.controller")).paths(PathSelectors.any()).build();
    }

    /**
     * 得到API信息
     * @return
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("图片服务器接口文档-秦正升").description("自己搭建的Springboot集成swagger2的图片服务器").version("1.0").build();
    }


}