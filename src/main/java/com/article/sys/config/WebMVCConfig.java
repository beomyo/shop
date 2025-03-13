package com.article.sys.config;

import com.article.sys.interceptor.ShoppingLoginInterceptor;
import com.article.sys.util.SYS;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //定义 文件夹中的资源的访问路径
        //让springmvc添加一个处理器，访问静态资源
        //浏览器访问 easyfile/文件名  就访问到这个资源处理器
        registry.addResourceHandler(SYS.FILE_UPLOAD_URL + "/**")//easyfile/任意文件名
                .addResourceLocations("file:"+SYS.FILE_UPLOAD_DIR);
    }

    @Override //添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ShoppingLoginInterceptor()).addPathPatterns("/shopping/cart","/shopping/checkout","/cart/**","/page/*","/shopping/payment");
    }


}
