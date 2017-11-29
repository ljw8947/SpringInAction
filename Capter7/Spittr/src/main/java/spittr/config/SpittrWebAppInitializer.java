package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by jwlv on 2017/10/27.
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //for "root" application context (non-web infrastructure) configuration.
    //返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的Bean
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    // for DispatcherServlet application context (Spring MVC infrastructure) configuration.
    //返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的Bean
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    //将一个或多个路径映射到DispatcherServlet上
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //设置multipart上传配置，路径，文件不超过2MB，请求不超过4MB
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration){
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        "C:/test",
                        2097152,
                        4194304,
                        0));
    }

}
