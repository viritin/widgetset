package com.example.demo;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

// Things like theme, Push etc can be set here and these will propagate to apps
// using this widgetset module.
@Theme(value="my-app", variant = Lumo.DARK)
//@Push
public class AppShell implements AppShellConfigurator{
    
}
