package service;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

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

    public String getRootPath() {
        return rootPath;
    }
}
