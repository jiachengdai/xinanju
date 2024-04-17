package com.project.oldCare.config;

import com.project.oldCare.filter.JwtAuthenticationFilter;
import com.project.oldCare.handler.*;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration//配置类
//@EnableWebSecurity //开启springSecurity自动配置
@EnableMethodSecurity//开启基于方法的授权
public class WebSecurityConfig {

    @Resource
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

//    public class InterceptorConfig implements WebMvcConfigurer {
//        @Override
//        public void addInterceptors(InterceptorRegistry registry) {
//            registry.addInterceptor(new JwtAuthenticationFilter())
//                    .addPathPatterns("/**")
//                    .excludePathPatterns("/user/**");
//        }
//    }A

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //授权配置
        http.authorizeRequests(
                authorize -> authorize
                        //对所有请求开启授权保护,已认证的请求会被自当授权
                        .anyRequest()
                        .authenticated()
        );


        //登录配置(使用表单授权方式）
        http.formLogin(form -> {

            form.loginPage("/login").permitAll() // 无需授权即可访问当前内容
                    .usernameParameter("username")//配置自定义表单用户名参数
                    .passwordParameter("password")//配置自定义表单密码参数
                    .failureUrl("/login?error") //核验失败时跳转的地址，默认是error
                    .successHandler(new MyAuthenticationSuccessHandler())//认证成功时的处理
                    .failureHandler(new MyAuthenticationFailureHandler())//认证失败的处理
            ;
        });

        //配置注销成功的json返回
        http.logout(logout -> {
            logout.logoutSuccessHandler(new MyLogoutSuccessHandler());
        });


        http.exceptionHandling(exception -> {
            exception.authenticationEntryPoint(new MyAuthenticationEntryPoint());//需要登录
            exception.accessDeniedHandler(new MyAccessDeniedHandler());//没有权限
        });

        //关闭csrf攻击防御
        http.csrf(csrf -> csrf.disable());

        //开启全局跨域
        http.cors(withDefaults());

        //配置禁止多方登录，超时退出
        http.sessionManagement(session -> {
            session.maximumSessions(1).expiredSessionStrategy(new MySessionInformationExpriedStrategy());
        });

        //添加过滤器
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
}
