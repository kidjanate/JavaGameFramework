package Instances;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite extends GameObject {
    public BufferedImage image;

    public Sprite(String path) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/" + path));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image: " + path);
        } catch (NullPointerException e) {
            System.err.println("Image not found: " + path);
        }
    }

    @Override
    public void OnDraw(Graphics2D g2){
        if (image == null)
            return;
        g2.drawImage(image, (int)position.X, (int)position.Y, 32, 32, null);
    }
}
