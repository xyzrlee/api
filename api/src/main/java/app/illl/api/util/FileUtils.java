package app.illl.api.util;

import app.illl.api.exception.InternalServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("WeakerAccess")
@Slf4j
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
            log.error("", e);
            throw new InternalServerErrorException();
        }
    }

    public static File createTempFile(MultipartFile multipartFile, String prefix, String suffix) {
        File file = createTempFile(prefix, suffix);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            log.error("", e);
            throw new InternalServerErrorException();
        }
        return file;
    }

    public static void deleteWithoutException(File file) {
        deleteWithoutException(file.toPath());
    }

    public static void deleteWithoutException(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            log.error("file not deleted", e);
        }
    }


}
