// package com.xhm.fz.config;

// import com.xhm.fz.component.*;
// import com.xhm.fz.utils.JwtTokenUtil;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


// /**
//  * 对SpringSecurity配置类的扩展，支持自定义白名单资源路径和查询用户逻辑
//  * Created by xhm on 2019/11/5.
//  */
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired(required = false)
//     private DynamicSecurityService dynamicSecurityService;

//     @Override
//     protected void configure(HttpSecurity httpSecurity) throws Exception {
//         ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
//                 .authorizeRequests();
//         // 不需要保护的资源路径允许访问
//         for (String url : ignoreUrlsConfig().getUrls()) {
//             registry.antMatchers(url).permitAll();
//         }
//         // 允许跨域的OPTIONS请求
//         registry.antMatchers(HttpMethod.OPTIONS)
//                 .permitAll();
//         // 其他任何请求都需要身份认证
//         registry.and()
//                 .authorizeRequests()
//                 .anyRequest()
//                 .authenticated()
//                 // 关闭跨站请求防护及不使用session
//                 .and()
//                 .csrf()
//                 .disable()
//                 .sessionManagement()
//                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                
//                 // 自定义权限拒绝处理类
//                 .and()
//                 .exceptionHandling()
//                 .accessDeniedHandler(restfulAccessDeniedHandler())
//                 .authenticationEntryPoint(restAuthenticationEntryPoint())
//                 // 自定义权限拦截器JWT过滤器
//                 .and()
//                 .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//         //有动态权限配置时添加动态权限校验过滤器
//         if(dynamicSecurityService!=null){
//             registry.and().addFilterBefore(dynamicSecurityFilter(), FilterSecurityInterceptor.class);
//         }
//     }

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userDetailsService())
//                 .passwordEncoder(passwordEncoder());
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
//         return new JwtAuthenticationTokenFilter();
//     }

//     @Bean
//     @Override
//     public AuthenticationManager authenticationManagerBean() throws Exception {
//         return super.authenticationManagerBean();
//     }

//     @Bean
//     public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
//         return new RestfulAccessDeniedHandler();
//     }

//     @Bean
//     public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
//         return new RestAuthenticationEntryPoint();
//     }

//     @Bean
//     public IgnoreUrlsConfig ignoreUrlsConfig() {
//         return new IgnoreUrlsConfig();
//     }

//     @Bean
//     public JwtTokenUtil jwtTokenUtil() {
//         return new JwtTokenUtil();
//     }

//     @ConditionalOnBean(name = "dynamicSecurityService")
//     @Bean
//     public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
//         return new DynamicAccessDecisionManager();
//     }


//     @ConditionalOnBean(name = "dynamicSecurityService")
//     @Bean
//     public DynamicSecurityFilter dynamicSecurityFilter() {
//         return new DynamicSecurityFilter();
//     }

//     @ConditionalOnBean(name = "dynamicSecurityService")
//     @Bean
//     public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
//         return new DynamicSecurityMetadataSource();
//     }

// }




package com.xhm.fz.config;

import com.xhm.fz.component.BCryptPasswordEncoderUtil;
import com.xhm.fz.component.Md5PasswordEncoderImpl;
import com.xhm.fz.config.handler.MyAccessDeniedHandler;
import com.xhm.fz.config.handler.MyAuthenticationEntryPoint;
import com.xhm.fz.config.handler.MyAuthenticationFailureHandler;
import com.xhm.fz.config.handler.MyAuthenticationSuccessHandler;
import com.xhm.fz.config.handler.MyLogoutHandler;
import com.xhm.fz.config.handler.MyLogoutSuccessHandler;
import com.xhm.fz.config.handler.MyOncePerRequestFilter;
import com.xhm.fz.config.handler.MyUsernamePasswordAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;


/**
 * @Author xhm
 * @Date 2020/5/28 9:17
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("authUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    private MyOncePerRequestFilter myOncePerRequestFilter;
    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;
    @Autowired
    private MyLogoutHandler myLogoutHandler;
    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(new Md5PasswordEncoderImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().headers().cacheControl();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login").permitAll();
                // .antMatchers("/**").hasRole("普通用户")
                // .antMatchers("/**").hasRole("超级管理员");
        http.addFilterAt(myUsernamePasswordAuthenticationFilter() , UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(myOncePerRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().authenticationEntryPoint(myAuthenticationEntryPoint).accessDeniedHandler(myAccessDeniedHandler);
        http.formLogin();
        http.logout().addLogoutHandler(myLogoutHandler).logoutSuccessHandler(myLogoutSuccessHandler);
    }

    @Bean
    MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter filter = new MyUsernamePasswordAuthenticationFilter();
        //成功后处理
        filter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
        //失败后处理
        filter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);

        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
}

