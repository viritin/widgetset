package com.example.demo;

import com.flowingcode.vaadin.addons.relativetime.RelativeTime;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.aura.Aura;
import com.vaadin.flow.theme.lumo.Lumo;

// Things like theme, Push etc can be set here and these will propagate to apps
// using this widgetset module.
//@Push
@StyleSheet(Aura.STYLESHEET)
@StyleSheet("/my-aura-theme.css")
public class AppShell implements AppShellConfigurator {

}
