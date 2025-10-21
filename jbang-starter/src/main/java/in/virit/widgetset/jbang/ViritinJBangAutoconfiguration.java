package in.virit.widgetset.jbang;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.open.Open;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.server.context.WebServerInitializedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

@AutoConfiguration
public class ViritinJBangAutoconfiguration {

    @Autowired
    ConfigurableApplicationContext context;


    @EventListener
    void onApplicationStarted(WebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
        try {
            Open.open("http://localhost:" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @EventListener
    void onApplicationStarted2(ServiceInitEvent event) {
        // hook to close the application when the browser window is closed
        event.getSource().addUIInitListener(uiInitEvent -> {

            UI ui = uiInitEvent.getUI();
            ui.getPage().addStyleSheet("aura-theme.css");

            ui.addDetachListener(detachEvent -> {
                System.out.println("Vaadin window closed, closing the SB app (and JBang script and jvm)");
                // TODO figure out if System.exit is really worse than context.close ??
                // context.close();
                System.exit(0);
            });
        });
    }
}
