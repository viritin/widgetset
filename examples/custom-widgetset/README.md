# A custom widgetset example

This example documents how the core idea of this project can be extended in your own applications, if you happen to need some Vaadin add-ons or custom themes.

The `mywidgetset' project builds the front-end bundle. It also brings in the vaadin-core dependencies (with some exclusions). In addition to packaging the core components, it bundles a custom theme and a one example component example (color picker). There is also a trivial smoke test for the custom component. In a real life project you might want to extend those e-2-e tests with something more reasonable.

If you use some pre-made add-ons, add their dependencies there and I'd also suggest to add some end-to-end tests to the mywidgetset project, so you verify those work when you e.g. upgrade your Vaadin version.

In addition to the actual widgetset module, there are couple of app examples, all utilising the same pre-built mywidgetset artifact. Note that none of these setups contain the Vaadin build plugin or dev mode, so they start up essentially immediately.

 * my-vaadin-app1, "standard" Spring Boot app
 * my-war-app, a standard war packaged app
 * my-embedded-undertow-app, an example with embedded undertow starting the server
 * my-vaadin-boot-app, an example with com.github.mvysny.vaadin-boot starting the app (~ jetty)
