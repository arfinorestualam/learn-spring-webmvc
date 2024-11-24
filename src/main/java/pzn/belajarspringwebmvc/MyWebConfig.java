package pzn.belajarspringwebmvc;

//make configuration for web mvc

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pzn.belajarspringwebmvc.interceptor.SessionInterceptor;

@Configuration
//must implement web mvc configurer
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    //add the interceptor here

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //use add path patterns for specific route that want to use
        //this patterns using Ant-Style path patterns, browse it for more
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/user/*");
    }
}
