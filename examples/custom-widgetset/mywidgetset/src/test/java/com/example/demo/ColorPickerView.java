package com.example.demo;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * A simple test view for the color picker custom component.
 */
@Route
public class ColorPickerView extends VerticalLayout {

    public ColorPickerView() {
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setId("cp");
        add(colorPicker);
    }
}