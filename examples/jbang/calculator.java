///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17+
//DEPS in.virit.ws:jbang-starter:24.6.1

package bang;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vaadin.firitin.components.button.DefaultButton;

@SpringBootApplication
public class calculator {

    enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE;

        public String toString() {
            return switch (this) {
                case ADD -> "+";
                case SUBTRACT -> "-";
                case MULTIPLY -> "*";
                case DIVIDE -> "/";
            };
        }
    }

    public static void main(String... args) {
        SpringApplication.run(calculator.class, args);
    }

    @Route
    public static class MainView extends VerticalLayout {
        public MainView() {
            add(new H1("Hello, world!"));
            add(new Paragraph("This is a small JBang & Spring Boot tool that opens locally on a workstation with a Vaadin based GUI."));
            add(new Paragraph("Closing this window also shuts down the JBang application."));

            var num1 = new NumberField() {{setValue(1.0);}};
            var operation = new Select<Operation>() {{
                setItems(Operation.values());
                setValue(Operation.ADD);
            }};
            var num2 = new NumberField(){{setValue(2.0);}};
            var execute = new DefaultButton("=");
            var result = new Div();
            add(num1, operation, num2, execute, result);

            execute.addClickListener(e -> {
                double res = switch (operation.getValue()) {
                    case ADD -> num1.getValue() + num2.getValue();
                    case SUBTRACT -> num1.getValue() - num2.getValue();
                    case MULTIPLY -> num1.getValue() * num2.getValue();
                    case DIVIDE -> num1.getValue() / num2.getValue();
                };
                result.setText(num1.getValue() + " " + operation.getValue() + " " + num2.getValue() + " = " + res);
            });

        }
    }
}