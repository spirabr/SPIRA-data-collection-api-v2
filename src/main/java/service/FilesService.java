package service;


import javax.enterprise.context.RequestScoped;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.*;

@RequestScoped
public class FilesService {

    private final String rootPath;

    public FilesService() {
        this.rootPath = Optional.ofNullable(System.getenv("AUDIOS_ROOT_PATH")).orElse("/tmp");
    }

    public void saveTo(String fileName, byte[] data) throws IOException {
        String fullPath = rootPath + "/" + fileName;
        writeByteArrayToFile(new File(fullPath), data);
    }

    public String getRootPath() {
        return rootPath;
    }
}
