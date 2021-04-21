package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReplayVideo{
    static int count;
    Image img;
    Image image;
    File f;
    JLabel Lb;
    JFrame frame;
    boolean isPlaying;
    static int delay;

    public ReplayVideo(){
        img = null;
        Lb = null;
        frame = new JFrame("VIDEO REPLAY");
        isPlaying = false;
        delay = 5;
    }

    public void ShowVid(String dir){   // dir == duong dan
        count = 1;
        frame.setSize(1300, 700);
        BufferedImage img;
        File f;

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(false);
                frame.remove(frame.getContentPane());
            }
        });
        Container container = frame.getContentPane();
        try { // doc file img duoc luu
            f = new File(dir + "/frame/BKpaint" + count + ".png");
            img = ImageIO.read(f);
            image = Toolkit.getDefaultToolkit().createImage(img.getSource()); // convert BufferedImage to Image

            JPanel jp = new JPanel(); // thanh cong cu
            container.setLayout(new BorderLayout());
            container.add(jp, BorderLayout.CENTER);         // add jp Panel to CENTER of the frame

            Lb = new JLabel(new ImageIcon(image));
            Icon iPlay = new ImageIcon(getClass().getResource("image/playing.png"));
            Icon iPause = new ImageIcon(getClass().getResource("image/pause.png"));
            JButton btnPause = new JButton();
            btnPause.setIcon(iPause);

            jp.add(Lb); //display the image to the panel
            JPanel controlPanel = new JPanel();
            container.add(controlPanel, BorderLayout.SOUTH);
            controlPanel.add(btnPause);

            JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 1000, 200);
            delay = slider.getValue();
            slider.setMajorTickSpacing(25);
            slider.setPaintTicks(true);

            controlPanel.add(new JLabel("  Delay(ms): "));
            controlPanel.add(slider);
            JLabel lbDelay = new JLabel("  "+ delay + "ms");

            controlPanel.add(lbDelay);
    // width and height of frame replay video
            int h = Toolkit.getDefaultToolkit().getScreenSize().height;
            int w = Toolkit.getDefaultToolkit().getScreenSize().width;
//                frame.setBounds((w-1000)/2, (h-720)/2 - 5, 1000, 720);
            int frWidth = (int) (w * 0.85);
            int frHeight = (int) (h * 0.95);
            frame.setBounds((w - frWidth)/2, (h - frHeight)/2 - 10, frWidth, frHeight);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);      // call one time to make only one frame, many calls cause many frames


            Timer timer = new Timer( delay, e -> {                             // CREATE TIMER
                // Repeat DelayFrame()
                DelayFrame(dir, Drawing.numFrame);      // Show video's frames once per <delay> milliseconds
                if(count == Drawing.numFrame){
                    btnPause.setIcon(iPause);
                    isPlaying = false;
                }
            });
            timer.setRepeats(true);
            timer.start();

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {       // close window event
                    isPlaying = false;
                    timer.stop();
                }
            });

            slider.addChangeListener(e -> {
                delay =  ((JSlider) e.getSource()).getValue();
                lbDelay.setText("  " + delay + "ms");
                timer.setDelay(delay);
            });

            btnPause.addActionListener(e -> {                       // button event: pause/play
                if(isPlaying){   // video is being played
                    btnPause.setIcon(iPause);
                    isPlaying = !isPlaying;
                }else{          // video isn't being played
                    btnPause.setIcon(iPlay);
                    isPlaying = !isPlaying;                         // change state to "playing video"
                    if(count == Drawing.numFrame){                      // video end and current state is not-playing
                        count = 1;                                      // replay
                        isPlaying = true;
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Video not found !!!");
        }
    }
    void DelayFrame(String dir, int numF){
        if(numF != 1){
            if(count <= numF && isPlaying){              // display replay video
                f = new File(dir +"/frame/BKpaint" + count + ".png");
                try {
                    img = ImageIO.read(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                image = Toolkit.getDefaultToolkit().createImage(img.getSource());
                Lb.setIcon(new ImageIcon(image));
                ++count;
            }
        }
    }
}