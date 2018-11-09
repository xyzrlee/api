package app.illl.api.util;

import app.illl.api.exception.InternalServerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {
    }

    public static File createTempFile(String prefix, String suffix) {
        return createTempFile(prefix, suffix, null);
    }

    public static File createTempFile(String prefix, String suffix, File directory) {
        try {
            return File.createTempFile(prefix, suffix, directory);
        } catch (IOException e) {
            LOGGER.error("", e);
            throw new InternalServerErrorException();
        }
    }

    public static File createTempFile(MultipartFile multipartFile, String prefix, String suffix) {
        File file = createTempFile(prefix, suffix);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            LOGGER.error("", e);
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
            LOGGER.error("file not deleted", e);
        }
    }


}
