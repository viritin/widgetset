package com.example.demo;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * This is a trivial custom component example (with client side extensions)
 */
@NpmPackage(value = "lit-colorpicker", version = "0.2.16")
@JsModule("lit-colorpicker")
@Tag("color-picker")
public class ColorPicker extends Component {

    public ColorPicker() {
        getElement().setAttribute("value", "green");
        // No interaction in this example, see vaadin.com/docs for examples
    }

}
