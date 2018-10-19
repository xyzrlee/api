package app.rk3.api.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtils {

    private QRCodeUtils() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(QRCodeUtils.class);
    private static final String CHARTSET = "utf-8";

    public Result decode(String filePath) {
        try {
            File file = new File(filePath);
            BufferedImage bufferedImage = ImageIO.read(file);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, CHARTSET);
            return new MultiFormatReader().decode(bitmap, hints);
        } catch (NotFoundException | IOException e) {
            LOGGER.error("", e);
            return null;
        }
    }

}
