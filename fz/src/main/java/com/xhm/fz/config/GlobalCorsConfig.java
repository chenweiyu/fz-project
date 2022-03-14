package com.xhm.fz.config;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置
 * Created by macro on 2019/7/27.
 */
@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {
// public class GlobalCorsConfig {

    /**
     * 允许跨域调用的过滤器
     */
    // @Bean
    // public CorsFilter corsFilter() {
    //     CorsConfiguration config = new CorsConfiguration();
    //     // 允许所有域名进行跨域调用
    //     config.addAllowedOrigin("*");
    //     // 允许跨越发送cookie
    //     config.setAllowCredentials(true);
    //     // 放行全部原始头信息
    //     config.addAllowedHeader("*");
    //     // 允许所有请求方法跨域调用
    //     config.addAllowedMethod("*");
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", config);
    //     return new CorsFilter(source);
    // }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOriginPatterns("*")
        .allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS")
        .allowedHeaders("*")
        .exposedHeaders("access-control-allow-headers",
                "access-control-allow-methods",
                "access-control-allow-origin",
                "access-control-max-age",
                "X-Frame-Options")
        .allowCredentials(true).maxAge(3600);
    }
}
