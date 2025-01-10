# Widgetset - a pre-built front-end bunble for simple (and FAST!) Vaadin apps

A pre-built Vaadin Flow widgetset for simple pure Java web apps, for developers who are too busy to wait for front-end build.

More documentation and examples coming soon...

# With JBang

JBang is a good basis for tooling type of apps (with Vaadin GUI!!) that could utilise this approach. There is a specific jbang-starter dependency, that utilizes Spring Boot as a basis with some extra goodies for those building on top of JBang:

 * Automatically assign a random port for Spring Boot app
 * Opens a browser automatically to the main UI
 * Shuts down the Spring context (and this way closes the app itself)

If you have JBang installed. Create an app stub:

    jbang init hello.java

Replace the content of the generated hello.java with this: (TODO contribute template to JBang)

```
///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17
//DEPS in.virit.ws:jbang-starter:24.6.1

package bang;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class hello {

    public static void main(String... args) {
        SpringApplication.run(hello.class, args);
    }

    @Route
    public static class MainView extends VerticalLayout {
        public MainView() {
            add("Hello, world!");
        }
    }
}
```

Run your Vaadin utility app:

    ./hello.java

Add some functionality (following is using IDEA with the configs you want to use and make defaults)

    jbang edit --live --open=idea -b hello.java