package com.sprint3r.deans4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.*;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class H2ConsoleConfiguration implements ServletContextInitializer, EmbeddedServletContainerCustomizer {

    private final Logger log = LoggerFactory.getLogger(H2ConsoleConfiguration.class);


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        initH2Console(servletContext);
    }

    /**
     * Initializes H2 console.
     */
    private void initH2Console(ServletContext servletContext) {
        log.debug("Initialize H2 console");
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/h2-console/*");
        h2ConsoleServlet.setInitParameter("-properties", "src/main/resources/");
        h2ConsoleServlet.setLoadOnStartup(1);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {

    }
}
