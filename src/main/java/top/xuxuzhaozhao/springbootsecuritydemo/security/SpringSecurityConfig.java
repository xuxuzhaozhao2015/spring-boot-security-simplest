package top.xuxuzhaozhao.springbootsecuritydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //启动Spring Security 的过滤器链
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // 代替之前的http标签 配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/product/add").hasAnyAuthority("PRODUCT_ADD")
                .antMatchers("/product/delete").hasAnyAuthority("PRODUCT_DELETE")
                .antMatchers("/product/update").hasAnyAuthority("PRODUCT_UPDATE")
                .antMatchers("/product/list").hasAnyAuthority("PRODUCT_LIST")
                .antMatchers("/**")
                .fullyAuthenticated()
                .and()
                //.httpBasic();//http basic的方式
                .formLogin().loginPage("/login")//默认方式，form表单方式
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder createPwdEncoder() {
        return new BCryptPasswordEncoder();
    }
}
