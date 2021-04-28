package service;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.writeByteArrayToFile;

@RequestScoped
public class FilesService {

    private final String rootPath;

    @Inject
    ConfigService config;

    public FilesService() {
        this.rootPath = config.getAudiosPath();
    }

    public void saveTo(String fileName, byte[] data) throws IOException {
        String fullPath = rootPath + "/" + fileName;
        writeByteArrayToFile(new File(fullPath), data);
    }

    public String getRootPath() {
        return rootPath;
    }
}
