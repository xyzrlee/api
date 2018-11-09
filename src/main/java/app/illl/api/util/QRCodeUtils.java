package app.illl.api.util;

import app.illl.api.exception.InternalServerErrorException;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.Map;

public class QRCodeUtils {

    private QRCodeUtils() {
    }

    private static final Map<DecodeHintType, Object> HINT = new EnumMap<>(DecodeHintType.class);

    static {
        HINT.put(DecodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.displayName());
    }

    public static Result decode(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
            return new MultiFormatReader().decode(bitmap, HINT);
        } catch (NotFoundException | IOException e) {
            throw new InternalServerErrorException(e);
        }
    }

}
