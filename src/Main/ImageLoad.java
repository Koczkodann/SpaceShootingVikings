package Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoad {
    BufferedImage image;
    public BufferedImage Load(String path) throws IOException {
        image = ImageIO.read(getClass().getResourceAsStream(path));
        return image;
    }
}
