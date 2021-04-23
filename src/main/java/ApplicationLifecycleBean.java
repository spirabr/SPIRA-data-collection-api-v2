import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationLifecycleBean {
    private static final Logger LOGGER = Logger.getLogger("Listener Bean");

    void onStart(@Observes StartupEvent event) {
        LOGGER.info("Application is starting...");
    }

    void onStop(@Observes ShutdownEvent event) {
        LOGGER.info("Stopping Application...");
    }
}
