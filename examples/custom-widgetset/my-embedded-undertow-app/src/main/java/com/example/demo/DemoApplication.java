package com.example.demo;

import com.vaadin.flow.di.LookupInitializer;
import com.vaadin.flow.server.startup.LookupServletContainerInitializer;
import com.vaadin.flow.server.startup.RouteRegistryInitializer;
import com.vaadin.flow.server.startup.ServletDeployer;
import com.vaadin.flow.server.startup.VaadinAppShellInitializer;
import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.ServletContainerInitializerInfo;
import java.util.Set;

public class DemoApplication {

    // This starts the web server. Note, no uberjar generation in this example
    public static void main(String[] args) throws Exception {
        DeploymentInfo servletBuilder = Servlets.deployment()
                .setClassLoader(DemoApplication.class.getClassLoader())
                .setDeploymentName("app")
                .setContextPath("/")
                // Manual deployment without class scanning
                .addServletContainerInitializers(
                        new ServletContainerInitializerInfo(
                                VaadinAppShellInitializer.class,
                                Set.of(AppShell.class)),
                        new ServletContainerInitializerInfo(
                                RouteRegistryInitializer.class,
                                Set.of(MainView.class)),
                        new ServletContainerInitializerInfo(
                                LookupServletContainerInitializer.class,
                                Set.of(LookupInitializer.class))
                )
                .addListener(Servlets.listener(ServletDeployer.class));
        
        var manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();

        Undertow.builder()
                .addHttpListener(8080, "0.0.0.0")
                .setHandler(manager.start())
                .build().start();

    }
}
