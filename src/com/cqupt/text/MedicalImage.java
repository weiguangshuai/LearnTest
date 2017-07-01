package com.cqupt.text;

import javax.swing.*;
import java.awt.*;

/**
 * @author weigs
 * @date 2017/6/25 0025
 */
public class MedicalImage {

    Image image;
    int[] pixel;

    public MedicalImage() {
        JFrame frame = new JFrame();
    }

    public void edge() {

    }


}

class myPanel extends JPanel {

    public void paint(Graphics graphics, Image image) {
        graphics.drawImage(image, 9, 171, this);
    }
}
