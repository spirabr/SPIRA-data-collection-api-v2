package org.spira.metrics.service;

import org.spira.common.service.ConfigService;
import org.spira.common.service.FilesService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class AudiosService {

    @Inject
    ConfigService configs;

    @Inject
    FilesService filesService;

    public List<String> getAudioNames() {
        return filesService.listFileNamesInFolder(Paths.get(configs.getAudiosPath()));
    }
}
