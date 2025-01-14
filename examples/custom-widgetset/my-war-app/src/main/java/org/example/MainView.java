package org.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add("This is an old school war packaged web app using Vaadin Flow front-end from a pre-built bundle.");
        Button button = new Button("Click me",
                event -> add(new Paragraph("Clicked!")));

        add(button);
    }
}
