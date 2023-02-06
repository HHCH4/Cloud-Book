package com.yunLi.config;


import com.yunLi.interceptor.ResourcesInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
@PropertySource("classpath:ignoreUrl.properties")
@ComponentScan({"com.yunLi.controller"})
@EnableWebMvc
public class SpringMvcConfig  implements WebMvcConfigurer {
  @Value("#{'${ignoreUrl}'.split(',')}")
    private List<String> ignoreUrl;
    @Bean
    public ResourcesInterceptor resourcesInterceptor(){
        return new ResourcesInterceptor(ignoreUrl);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( resourcesInterceptor()).addPathPatterns("/**").excludePathPatterns("/css/**","/js/**","/img/**");
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/admin/",".jsp");
    }

}




