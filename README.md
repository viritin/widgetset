# Widgetset - A Pre-Built Front-End Bundle for Simple (and FAST!) Vaadin Apps

*A pre-built Vaadin Flow widgetset for simple, pure Java web apps, for developers who are too busy to wait for front-end builds.* Similar to the good old DefaultWidgetset in Vaadin versions 6-8, this project allows you to build Vaadin apps completely without front-end tooling, even the one that gets installed automatically by the Vaadin plugin.

Vaadin projects notoriously require the `vaadin-maven-plugin` (or similar Gradle tooling) to handle the "front-end build" and package an optimized front-end bundle. This process adds build time and requires installing Node.js-based build tools. While this process has significant benefits for many Vaadin applications, it can slow down your app and even prevent you from using Vaadin if, for example, Node.js/npm are restricted in your organization. This project aims to provide a completely front-end-build-free Vaadin Flow experience.

This project can also serve as an example of how you can utilize the same approach in your own project. You can customize your widgetset with add-ons or a custom theme.

## Pros and Cons

**Pros:**
- Very fast startup and build times.
- No build plugins needed—just add a dependency (or dependencies).

**Cons:**
- No custom themes (plain CSS is fine).
- No add-ons that contribute to the front-end bundle (such as those built on top of web components).
- No dev-mode (it might work to some extent with a custom profile and a separate dev-mode widgetset 🤔).

## Modules

- **`core`** - Contains the pre-built front-end bundle with the open-source Vaadin components and Vaadin Flow client.
- **`sb`** - Includes the `core` module and Vaadin Spring Boot starter (with recommended exclusions) and a free distribution of the Viritin add-on.
- **`jbang-starter`** - Provides everything needed to create a Vaadin-based GUI for a JBang-based script or utility app.

See the `example` directory for usage examples.

## Using JBang

JBang is a great basis for tooling-type apps. With this project, you can create a Vaadin GUI for your JBang apps. There is a specific `jbang-starter` dependency that uses Spring Boot as a foundation, with additional features for JBang-based apps:

- Automatically assigns a random port for the Spring Boot app.
- Opens a browser automatically to the main UI.
- Shuts down the Spring context (and, consequently, the JVM app) when the browser window is closed.

### Create a JBang App Stub

If you have JBang installed, create an app stub by running:

```bash
jbang init hello.java
```

Replace the content of the generated `hello.java` file with the following:

```java
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

### Run the Java App

```bash
./hello.java
```

### Add Functionality

To edit the app, run the following command (using your preferred IDE, such as IntelliJ IDEA):

```bash
jbang edit --live --open=idea -b hello.java
```

**Note:** Vaadin dev mode is not available. To see your changes, you'll need to restart the app. However, since there is no front-end build or dev mode, restarting is very fast.

