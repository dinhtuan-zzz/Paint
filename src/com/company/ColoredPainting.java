package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.*;

import static com.company.BKPaint_Main.isSaved;
import static com.company.BKPaint_Main.drawArea;


public class ColoredPainting {
    String Dir;

    public JComboBox createCB() {
        String[] ColoredPainting = {" BK Paint"," Rabbit", " Cat", " Dog", " Bee", " Butterfly",
                " Plane", " Bus", " Birtday's cake", " Flower", " Apple",
                " Submarine", " Ship", " Train"};
        JComboBox drowDown = new JComboBox(ColoredPainting);
        String Dir1 = System.getProperty("user.dir") + "\\src\\hinhcosan\\";
        String[] listImageSrc = {"10.png","tho.jpg", "cat.jpg", "cho.jpg",
                "ong.png", "buom.jpg", "bay.jpg", "bus.jpg", "banh.jpg",
                "hoa.jpg", "tao.jpg", "ngam.jpg", "ship.jpg", "train.jpg"};

        drowDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dir = System.getProperty("user.dir");
                boolean ok = true;
                if (!isSaved) {
                    ok = comfirmSave();
                }
                File iFile = new File(Dir1 + listImageSrc[drowDown.getSelectedIndex()]);
                if(ok){
                    try {
                        isSaved = true;
                        BufferedImage bi = ImageIO.read(iFile);
                        Drawing.buffImg2 = bi;
                        drawArea.Open(ResizeImage.scale(bi, Drawing.fwidth, Drawing.fheight));
                    } catch (Exception exp) {
                        JOptionPane.showMessageDialog(null, "ERROR!" + Dir1 + listImageSrc[drowDown.getSelectedIndex()], "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        });

        return drowDown;
    }

    boolean comfirmSave() {
        Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
        int n = JOptionPane.showConfirmDialog(null,
                "Do you want to SAVE ?",
                "Save?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);

        if (n == JOptionPane.OK_OPTION) {
            try {
                new OpenAndSaveImage().SaveImg(Drawing.image);
                isSaved = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
        else return n != JOptionPane.CANCEL_OPTION && n != JOptionPane.CLOSED_OPTION;
        return true;
    }
}
