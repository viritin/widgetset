///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17+
//DEPS in.virit.ws:jbang-starter:24.6.2

package bang;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class helloworld {

    public static void main(String... args) {
        SpringApplication.run(helloworld.class, args);
    }

    @Route
    public static class MainView extends VerticalLayout {
        public MainView() {
            add("It works!");
        }
    }
}