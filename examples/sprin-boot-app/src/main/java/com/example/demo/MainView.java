package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add("It works!?");
        var tf = new TextField("Enter your name");
        var button = new Button("Say hello", e -> {
            add(new Paragraph("Hello, " + tf.getValue()));
        });
        add(tf, button);

        var grid = new Grid<String>(String.class);
        grid.setItems("Hello", "World");
        add(grid);
    }
}
