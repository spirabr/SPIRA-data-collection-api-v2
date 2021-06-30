package org.spira.common.service;

import io.quarkus.runtime.Startup;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@Startup
@ApplicationScoped
public class ConfigService {

    private Config config;

    public ConfigService() {
        this.config = ConfigProvider.getConfig();
    }

    public String getAudiosPath() {
        Optional<String> maybeAudiosPath = config
                .getOptionalValue("spira.audios.path", String.class)
                .or(() -> config.getOptionalValue("SPIRA_AUDIOS_PATH", String.class));
        return maybeAudiosPath.orElse("/tmp/spira-audios");
    }
}
