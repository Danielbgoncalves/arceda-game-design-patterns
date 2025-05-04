package spriteframework.sprite;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import javax.swing.ImageIcon;



public class ScaleImage extends JPanel {

    private Image scaledImage;
    private ImageIcon resizedIcon;

    // Colocar a pasta image na raiz do projeto
    public ScaleImage(String localizacao, int width, int height){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(localizacao));
        scaledImage = ii.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(scaledImage);
    }

    public ImageIcon getScaledImage() {
        return resizedIcon;
    }

    /*public static void main (String args[]) {
        JFrame i = new JFrame();
        ScaleImage ip = new ScaleImage("/images/player.png", 40, 40);
        i.add(ip); i.setSize(400, 400);
        i.setVisible(true);
        i.repaint();
    }*/

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImage,50, 50, this);
    }
}