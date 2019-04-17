package com.atguigu.springboottask.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sunny
 * @title: SecurityConfig
 * @date 2019-04-1710:44
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        System.out.println("执行security 配置...");
        //定义请求规格
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //开启自动配置的登录功能,效果,如果没有登录,没有权限就会来到登录页面
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/userlogin");
        //配置注销功能
        http.logout().logoutSuccessUrl("/");
        // 开启记住我功能, 服务器会向浏览器返回一个cookie 保存,下次再访问这个页面,会带着cookie,检查通过就可登录成功
        //注销也会把这个cookie 清除掉
        http.rememberMe().rememberMeParameter("remember");//

    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        System.out.println("执行用户信息....");
        UserDetailsService defaultUserDetailsService = auth.getDefaultUserDetailsService();

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip3")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3");
    }
}
