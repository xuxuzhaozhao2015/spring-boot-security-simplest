package top.xuxuzhaozhao.springbootsecuritydemo.security;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //针对不同的错误码，可以添加不同的页面；
        ErrorPage errorPage = new ErrorPage(HttpStatus.FORBIDDEN,"/403");
        registry.addErrorPages(errorPage);
    }
}
