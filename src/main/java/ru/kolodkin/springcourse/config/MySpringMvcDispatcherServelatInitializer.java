package ru.kolodkin.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServelatInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class}; // == web.xml
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; // поылаем все запросы диспетчер сервлету
    }
}
