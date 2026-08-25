package org.example;

import com.example.demo.ColorPicker;
import com.flowingcode.vaadin.addons.relativetime.RelativeTime;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.Instant;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add("It works!? This dark sunset glass theme and custom widgets, coming in via mywidgetset module. No front-end build at all.");
        Button button = new Button("Click me",
                event -> add(new Paragraph("Clicked!")));

        add(button);

        add(new ColorPicker());

        add("Page instantiated:");
        add(new RelativeTime(Instant.now()));
    }
}
