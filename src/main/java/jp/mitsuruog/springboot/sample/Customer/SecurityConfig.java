package jp.mitsuruog.springboot.sample.Customer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by mitsuruog on 15/09/23.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 静的リソースに対する認証を除外する
        web.ignoring()
                .antMatchers("/webjars/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // loginFormのみ認証が必要なしにするための設定
        http.authorizeRequests()
                .antMatchers("/loginForm")
                .permitAll()
                .anyRequest()
                .authenticated();
        // ログインについての設定
        http.formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/loginForm")
                .failureUrl("/loginForm?error")
                .defaultSuccessUrl("/customers", true)
                .usernameParameter("username")
                .passwordParameter("password")
                .and();
        // ログアウトについての設定
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**"))
                .logoutSuccessUrl("/loginForm");
    }

}
