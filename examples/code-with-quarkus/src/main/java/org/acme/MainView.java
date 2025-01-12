package org.acme;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add(new H1("Hello Quarkus & }>"));
        add(new Button("Click me", e -> {
            add(new Paragraph("Clicked!"));
        }));
    }
}
