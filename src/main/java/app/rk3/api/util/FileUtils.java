package app.rk3.api.util;

import app.rk3.api.exception.InternalServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    private FileUtils() {
    }

    public static File createTempFile(String prefix, String suffix) {
        return createTempFile(prefix, suffix, null);
    }

    public static File createTempFile(String prefix, String suffix, File directory) {
        try {
            return File.createTempFile(prefix, suffix, directory);
        } catch (IOException e) {
            throw new InternalServerErrorException();
        }
    }

    public static File createTempFile(MultipartFile multipartFile, String prefix, String suffix) {
        File file = createTempFile(prefix, suffix);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new InternalServerErrorException();
        }
        return file;
    }


}
