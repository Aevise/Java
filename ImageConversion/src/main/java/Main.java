import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Main {

    final static int MAX_TARGET_WIDTH = 200;
    final static int MAX_TARGET_HEIGHT = 200;

    public static void main(String[] args) throws Exception {
        BufferedImage image = ImageIO.read(new File("src/cat.jpg"));
        BufferedImage imageKFC = ImageIO.read(new File("src/kfc.png"));
        BufferedImage resizedImage = simpleResize(image);
        BufferedImage resizedImageKFC = simpleResize(imageKFC);
        saveImage(resizedImage, "resizedCat");
        saveImage(resizedImageKFC, "resizedKFC");

        //uzycie formatu PNG pozwoli na uzyskanie lepszej rozdzielczosci zdjecia (zwiekszajac jednoczesnie ich wage),
        //ale pytanie, czy warto skoro i tak ni jest to prefereowany sposob przechowywania zdjec, wiec lepej redukowac bajty
        byte[] imageToBytes = convertBufferedImageToBytes(resizedImage, "jpg");
        convertBytesToImage(imageToBytes, "src/catProcessed.jpg", "jpg");
    }

    private static void saveImage(BufferedImage resizedImage, String filename) throws IOException {
        ImageIO.write(resizedImage, "jpg", new File("src/%s.jpg".formatted(filename)));
    }

    static BufferedImage simpleResize(BufferedImage image) throws Exception {
        return Scalr.resize(
                image,
                Scalr.Method.ULTRA_QUALITY,
                Scalr.Mode.AUTOMATIC,
                Main.MAX_TARGET_WIDTH,
                Main.MAX_TARGET_HEIGHT,
                Scalr.OP_ANTIALIAS
        );
    }
    //https://spring.io/guides/gs/uploading-files/
    //https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-postgresql/

    static byte[] convertBufferedImageToBytes(BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, format, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    static void convertBytesToImage(byte[] imageBytes, String outputPath, String format) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
        BufferedImage image = ImageIO.read(byteArrayInputStream);
        ImageIO.write(image, format, new File(outputPath));
    }
}
