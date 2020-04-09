package ModuleCinema.config;

import ModuleCinema.interceptor.BossSessionInterceptor;
import ModuleCinema.interceptor.StaffSessionInterceptor;
import ModuleCinema.interceptor.UserSessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan(basePackages = "ModuleCinema.controller")
public class WebConfig extends WebMvcConfigurationSupport {
    // 配置可以访问静态资源
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置文件上传器
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    /**
     * 配置拦截器拦截的url
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        UserSessionInterceptor interceptor = new UserSessionInterceptor();
        StaffSessionInterceptor interceptor1 = new StaffSessionInterceptor();
        BossSessionInterceptor interceptor2 = new BossSessionInterceptor();
        registry.addInterceptor(interceptor).addPathPatterns("/u/**");
//        registry.addInterceptor(interceptor1).addPathPatterns("/s/**");
        registry.addInterceptor(interceptor2).addPathPatterns("/b/**");
    }
}
