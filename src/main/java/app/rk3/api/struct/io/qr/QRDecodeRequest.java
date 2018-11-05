package app.rk3.api.struct.io.qr;

import org.springframework.web.multipart.MultipartFile;

public class QRDecodeRequest {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "QRDecodeRequest{" +
                "file=" + file +
                '}';
    }
}
