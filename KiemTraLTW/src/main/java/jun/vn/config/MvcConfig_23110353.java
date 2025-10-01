package jun.vn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class MvcConfig_23110353 implements WebMvcConfigurer {

    // Cấu hình ViewResolver cho JSP
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // Cấu hình để load static resources + upload
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ánh xạ static resources (css, js, images trong resources folder)
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        // ánh xạ URL /upload/** tới thư mục E:/upload
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:E:/upload/");
    }
}
