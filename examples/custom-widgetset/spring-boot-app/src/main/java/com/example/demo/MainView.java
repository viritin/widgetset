package com.example.demo;

import com.flowingcode.vaadin.addons.relativetime.Format;
import com.flowingcode.vaadin.addons.relativetime.Precision;
import com.flowingcode.vaadin.addons.relativetime.RelativeTime;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.Instant;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add("It works!? This dark sunset glass theme and custom widgets, coming in via mywidgetset module. No front-end build at all.");
        var tf = new TextField("Enter your name");
        var button = new Button("Say hello", e -> {
            add(new Paragraph("Hello, " + tf.getValue()));
        });
        add(tf, button);

        // ColorPicker is custom component from the "mywidgetset" module
        add(new ColorPicker());


        add("This page was generated (relative time add-on below):");
        add(new RelativeTime(Instant.now()) {
            {
                this.setPrecision(Precision.SECOND);
                this.setFormat(Format.ELAPSED);
            }
        });

    }
}
