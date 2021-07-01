package org.spira.common.service;

import io.quarkus.runtime.Startup;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@Startup
@ApplicationScoped
public class ConfigService {

    private static final Logger LOGGER = Logger.getLogger(ConfigService.class);
    private static final String DEFAULT_PATH = "/tmp/spira-audios";

    private Config config;

    public ConfigService() {
        this.config = ConfigProvider.getConfig();
    }

    public String getAudiosPath() {
        return config
                .getOptionalValue("spira.audios.path", String.class)
                .or(() -> config.getOptionalValue("SPIRA_AUDIOS_PATH", String.class))
                .orElseGet(() -> {
                    LOGGER.warn("Audios path not configured! Using default path: " + DEFAULT_PATH + " , which can cause data loss");
                    return DEFAULT_PATH;
                });
    }

    public boolean isAudioPathDefault() {
        return this.getAudiosPath().equals(DEFAULT_PATH);
    }
}
