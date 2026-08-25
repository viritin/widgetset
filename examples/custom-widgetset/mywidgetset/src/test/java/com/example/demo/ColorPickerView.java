package com.example.demo;

import com.flowingcode.vaadin.addons.relativetime.Format;
import com.flowingcode.vaadin.addons.relativetime.Precision;
import com.flowingcode.vaadin.addons.relativetime.RelativeTime;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.Instant;

/**
 * A simple test view for the color picker custom component.
 */
@Route
public class ColorPickerView extends VerticalLayout {

    public ColorPickerView() {
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setId("cp");
        add(colorPicker);


        add("This page was created:");
        add(new RelativeTime(Instant.now()) {
            {
                this.setPrecision(Precision.SECOND);
                this.setFormat(Format.ELAPSED);
            }
        });
    }
}