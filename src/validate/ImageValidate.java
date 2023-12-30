package validate;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class ImageValidate {

    public static Icon scaleAndCreateIcon(String path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(ImageValidate.class.getResource(path));
        Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static Image makeRoundedImage(Image image, int cornerRadius) {
        BufferedImage roundedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = roundedImage.createGraphics();

        RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0, image.getWidth(null), image.getHeight(null), cornerRadius * 2, cornerRadius * 2);
        g2.setClip(roundRect);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();

        return roundedImage;
    }



}
