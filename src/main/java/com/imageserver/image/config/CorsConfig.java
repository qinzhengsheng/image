package com.imageserver.image.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author qinzhengsheng
 * 跨越过滤器配置类
 */
@Configuration
public class CorsConfig {


    /**
     * 跨域配置
     *
     * @return
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsFilterConfiguration = new CorsConfiguration();
        // 放行哪些原始域
        corsFilterConfiguration.addAllowedOrigin("*");
        // 是否发送Cookie信息
        corsFilterConfiguration.setAllowCredentials(true);
        // 放行哪些原始域(请求方式)
        corsFilterConfiguration.addAllowedMethod("*");
        // 放行哪些原始域(头部信息)
        corsFilterConfiguration.addAllowedHeader("*");
        // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
        corsFilterConfiguration.addExposedHeader("*");
        return corsFilterConfiguration;
    }

    /**
     * 生产cors过滤器
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource=new UrlBasedCorsConfigurationSource();
        //添加映射路径导入配置
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }




}