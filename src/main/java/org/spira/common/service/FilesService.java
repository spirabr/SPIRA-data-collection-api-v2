package org.spira.common.service;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.writeByteArrayToFile;

@RequestScoped
public class FilesService {

    private String rootPath;

    @Inject
    ConfigService configService;

    @PostConstruct
    void init() {
        this.rootPath = configService.getAudiosPath();
    }

    public void saveTo(String fileName, byte[] data) throws IOException {
        String fullPath = rootPath + "/" + fileName;
        writeByteArrayToFile(new File(fullPath), data);
    }

    public List<String> listFileNamesInFolder(Path directory) {
        try {
            return Files.list(directory)
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            if (e instanceof NoSuchFileException) {
                System.out.println("Folder not found");
            } else {
                e.printStackTrace();
            }
            return Collections.emptyList();
        }

    }

    public String getRootPath() {
        return rootPath;
    }
}
