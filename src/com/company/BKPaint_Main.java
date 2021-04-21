package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class BKPaint_Main extends JFrame {
    /*private JButton btnBlack;
    private JButton btnGreen;
    private JButton btnRed;
    private JButton btnBlue;
    private JButton btnGray;
    private JButton btnYellow;
    private JButton btnMagenta;
    private JButton btnCyan;
    private JButton btnDarkGray;
    private JButton btnOrange;
    private JButton btnTeal;
    private JButton btnLime;
    private JButton btnOlive;
    private JButton btnMaroon;
    private JButton btnPurple;
    private JButton btnBrown;*/

    private JButton btnClear;
    private JButton btnEraser;
    private JButton btnFill;
    private JButton btnOpen;
    private JButton btnSave;
    private JButton btnUndo;
    private JButton btnRedo;
    private JButton btnText;
    private JButton btnVid;
    private JButton btnEditColor;
    private JButton btnHelp;
    private JButton btnZoomOut;
    private JButton btnZoomIn;
    JButton btnRect;
    JButton btnOval;
    JButton btnLine;

    private JComboBox<String> jcSize;
    private JComboBox<String> jcBrush;
    private JLabel ratio;

    static Drawing drawArea;
    public static long scale;
    static boolean isSaved;  // Ban Ä‘áº§u chÆ°a váº½ gĂ¬ -> khĂ´ng cáº§n save

    static JButton curColor;

    /*ActionListener actionListener = new ActionListener() {          // sá»± kiá»‡n cho cĂ¡c nĂºt trong báº£ng chá»�n mĂ u nhanh
        @Override
        public void actionPerformed(ActionEvent e) {
            Drawing.isEraser = false;
            btnEraser.setBackground(null);
            if (e.getSource() == btnBlack) {
                Drawing.ChosenColor = "0x000000";
                drawArea.Draw();
            } else if (e.getSource() == btnGreen) {
                Drawing.ChosenColor = "0x006600";
                drawArea.Draw();
            } else if (e.getSource() == btnRed) {
                Drawing.ChosenColor = "0xFF0000";
                drawArea.Draw();
            } else if (e.getSource() == btnBlue) {
                Drawing.ChosenColor = "0x0000FF";
                drawArea.Draw();
            } else if (e.getSource() == btnGray) {
                Drawing.ChosenColor = "0xC0C0C0";
                drawArea.Draw();
            } else if (e.getSource() == btnMagenta) {
                Drawing.ChosenColor = "0xFF00FF";
                drawArea.Draw();
            } else if (e.getSource() == btnYellow) {
                Drawing.ChosenColor = "0xFFFF00";
                drawArea.Draw();
            } else if (e.getSource() == btnDarkGray) {
                Drawing.ChosenColor = "0x808080";
                drawArea.Draw();
            } else if (e.getSource() == btnCyan) {
                Drawing.ChosenColor = "0x00FFFF";
                drawArea.Draw();
            } else if (e.getSource() == btnOrange) {
                Drawing.ChosenColor = "0xFF9900";
                drawArea.Draw();
            } else if (e.getSource() == btnBrown) {
                Drawing.ChosenColor = "0x663300";
                drawArea.Draw();
            } else if (e.getSource() == btnTeal) {
                Drawing.ChosenColor = "0x008080";
                drawArea.Draw();
            } else if (e.getSource() == btnPurple) {
                Drawing.ChosenColor = "0x800080";
                drawArea.Draw();
            } else if (e.getSource() == btnMaroon) {
                Drawing.ChosenColor = "0x800000";
                drawArea.Draw();
            } else if (e.getSource() == btnOlive) {
                Drawing.ChosenColor = "0x808000";
                drawArea.Draw();
            } else if (e.getSource() == btnLime) {
                Drawing.ChosenColor = "0x00FF00";
                drawArea.Draw();
            }
        }
    };*/
    public static void main(String[] args) {
        new TextTool();                     // khá»Ÿi táº¡o cho TextTool, náº¡p toĂ n bá»™ font cá»§a há»‡ thá»‘ng
        new BKPaint_Main().showFrame();   // Hiá»ƒn thá»‹ cá»­a sá»• Frame
    }

    public BKPaint_Main(){
        scale = 0;
        isSaved = true;

        /*btnBlack = new JButton(" ");                // Báº£ng chá»�n mĂ u nhanh
        btnBlack.addActionListener(actionListener);
        btnBlack.setBackground(Color.black);
        btnBlack.setSize(25, 25);

        btnGreen = new JButton(" ");
        btnGreen.addActionListener(actionListener);
        System.setProperty("green", "0x006600");
        btnGreen.setBackground(Color.getColor("green"));

        btnRed = new JButton(" ");
        btnRed.addActionListener(actionListener);
        btnRed.setBackground(Color.RED);

        btnBlue = new JButton(" ");
        btnBlue.addActionListener(actionListener);
        btnBlue.setBackground(Color.blue);

        btnGray = new JButton(" ");
        btnGray.addActionListener(actionListener);
        btnGray.setBackground(Color.gray);

        btnMagenta = new JButton(" ");
        btnMagenta.addActionListener(actionListener);
        btnMagenta.setBackground(Color.magenta);

        btnYellow = new JButton(" ");
        btnYellow.addActionListener(actionListener);
        btnYellow.setBackground(Color.yellow);

        btnDarkGray = new JButton(" ");
        btnDarkGray.addActionListener(actionListener);
        btnDarkGray.setBackground(Color.darkGray);

        btnCyan = new JButton(" ");
        btnCyan.addActionListener(actionListener);
        btnCyan.setBackground(Color.cyan);

        btnOrange = new JButton(" ");
        btnOrange.addActionListener(actionListener);
        btnOrange.setBackground(Color.orange);

        btnTeal = new JButton(" ");
        btnTeal.addActionListener(actionListener);
        System.setProperty("teal", "0x008080");
        btnTeal.setBackground(Color.getColor("teal"));

        btnLime = new JButton(" ");
        btnLime.addActionListener(actionListener);
        System.setProperty("lime", "0x00FF80");
        btnLime.setBackground(Color.getColor("lime"));

        btnPurple = new JButton(" ");
        btnPurple.addActionListener(actionListener);
        System.setProperty("purple", "0x800080");
        btnPurple.setBackground(Color.getColor("purple"));

        btnOlive = new JButton(" ");
        btnOlive.addActionListener(actionListener);
        System.setProperty("olive", "0x808000");
        btnOlive.setBackground(Color.getColor("olive"));

        btnMaroon = new JButton(" ");
        btnMaroon.addActionListener(actionListener);
        System.setProperty("maroon", "0x800000");
        btnMaroon.setBackground(Color.getColor("maroon"));

        btnBrown = new JButton(" ");
        btnBrown.addActionListener(actionListener);
        System.setProperty("brown", "0x663300");
        btnBrown.setBackground(Color.getColor("brown"));*/
        

        btnClear = new JButton("CLEAR ");
        btnEraser = new JButton();

        btnOpen = new JButton();
        btnSave = new JButton();
        btnUndo = new JButton("Undo ");
        btnRedo = new JButton("Redo ");
        btnFill = new JButton();
        btnText = new JButton();
        btnVid = new JButton("Replay");
        btnEditColor = new JButton();
        btnHelp = new JButton();
        btnZoomOut = new JButton();
        btnZoomIn = new JButton();

        btnOpen.setBorder(null);
        btnSave.setBorder(null);
        btnUndo.setBorder(null);
        btnRedo.setBorder(null);
        btnText.setBorder(null);
        btnVid.setBorder(null);
        btnEditColor.setBorder(null);
        btnHelp.setBorder(null);
        btnEraser.setBorder(null);
        btnFill.setBorder(null);

        btnClear.setBackground(null);
        btnOpen.setBackground(null);
        btnSave.setBackground(null);
        btnUndo.setBackground(null);
        btnRedo.setBackground(null);
        btnFill.setBackground(null);
        btnEraser.setBackground(null);
        btnText.setBackground(null);
        btnVid.setBackground(null);
        btnEditColor.setBackground(null);
        btnHelp.setBackground(null);
        btnZoomOut.setBackground(null);
        btnZoomIn.setBackground(null);


        curColor = new JButton("  ");
        curColor.setEnabled(false);
    }


    void showFrame() {
        JFrame frame = new JFrame("BK PAINT");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        drawArea = new Drawing();
        container.add(drawArea, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();             // Bang cac thao tac
        JPanel colorPanel = new JPanel();               // Bang hien thi mau duoc chon

        container.add(controlPanel, BorderLayout.NORTH); // ben tren
        colorPanel.setLayout(new FlowLayout());
        container.add(colorPanel, BorderLayout.SOUTH);// ben duoi
        controlPanel.setBackground(Color.lightGray);
        colorPanel.setBackground(new Color(211, 213, 214));
        curColor.setBackground(Drawing.color);


        controlPanel.add(new JLabel("<html><font color='Black'>   Tool Edit : </font></html>"));
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.lightGray);
        panel1.setLayout(new FlowLayout());
        controlPanel.add(panel1);
        // OPEN button ----------------------------------
        Icon iconOpen = new ImageIcon(getClass().getResource("icons/AddFolder.png"));
        btnOpen.setIcon(iconOpen);
        btnOpen.addActionListener(e -> {
            Drawing.isFilling = false;
            btnFill.setBackground(null);
            OpenAndSaveImage open = new OpenAndSaveImage();
            Drawing.buffImg2 = open.OpenImg();
            drawArea.Open(Drawing.buffImg2);
            scale = 0;
        });
        btnOpen.setMnemonic(KeyEvent.VK_O);
        panel1.add(btnOpen);
        btnOpen.setMargin(new Insets(-1, -1,-1,-1));
        panel1.add(new JLabel(" "));

//        container.addKeyListener(new ShiftKeyListener());
        // SAVE button -----------------------------------
        btnSave.addActionListener(e -> {
            Drawing.isFilling = false;
            btnFill.setBackground(null);
            Drawing.isEraser = false;
            btnEraser.setBackground(null);
            OpenAndSaveImage save = new OpenAndSaveImage();
            isSaved = save.SaveImg(Drawing.image);
        });
        btnSave.setMnemonic(KeyEvent.VK_S);
        panel1.add(btnSave);
        btnSave.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconSave = new ImageIcon(getClass().getResource("icons/Save.png"));
        btnSave.setIcon(iconSave);

        controlPanel.add(new JLabel(" "));

        // UNDO button ---------------------------------
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new GridLayout(2,1));

        btnUndo.addActionListener(e -> drawArea.Undo(true));
        btnUndo.setMnemonic(KeyEvent.VK_Z);
        editPanel.add(btnUndo);
        btnUndo.setMargin(new Insets(3, 3,3,3));
        Icon iconUndo = new ImageIcon(getClass().getResource("icons/Undo.png"));
        btnUndo.setIcon(iconUndo);

        // REDO button ---------------------------------
        btnRedo.addActionListener(e -> drawArea.Undo(false));
        btnRedo.setMnemonic(KeyEvent.VK_R);
        editPanel.add(btnRedo);
        btnRedo.setMargin(new Insets(3, 3,3,3));
        Icon iconRedo = new ImageIcon(getClass().getResource("icons/Redo.png"));
        btnRedo.setIcon(iconRedo);

        controlPanel.add(editPanel);

        controlPanel.add(new JLabel(" ")); // khoang trang

        controlPanel.add(new JLabel("<html><font color='Black'>   Painting : </font></html>"));
        controlPanel.add(new ColoredPainting().createCB());
//--------------------------------------------------------------------- CLEAR PANEL ------------------------

        controlPanel.add(btnEditColor);// add button edit color

//-------------------------------------------------------------------- SHAPE PANEL ------------------
        controlPanel.add(new JLabel("<html><font color='Black'>  Shape :  </font></html>"));

        JPanel shapePanel = new JPanel();
        shapePanel.setBackground(Color.lightGray);
        shapePanel.setLayout(new GridLayout(1,3));
        controlPanel.add(shapePanel);

        btnRect = new JButton();
        Icon icRect = new ImageIcon(getClass().getResource("image/rectangle.png"));
        btnRect.setIcon(icRect);
        btnRect.setBackground(Color.lightGray);
        btnRect.setMargin(new Insets(0,0,0,0));
        shapePanel.add(btnRect);

        btnOval = new JButton();
        Icon icOval = new ImageIcon(getClass().getResource("image/oval.png"));
        btnOval.setIcon(icOval);
        btnOval.setBackground(Color.lightGray);
        btnOval.setMargin(new Insets(0,0,0,0));
        shapePanel.add(btnOval);

        btnLine = new JButton();
        Icon icLine = new ImageIcon(getClass().getResource("image/line.png"));
        btnLine.setIcon(icLine);
        btnLine.setBackground(Color.lightGray);
        btnLine.setMargin(new Insets(0,0,0,0));
        shapePanel.add(btnLine);

        controlPanel.add(shapePanel);

        ActionListener shapeAction = e -> {
            btnText.setBackground(null);
            if(e.getSource() == btnRect){
                Drawing.isText = false;
                Drawing.isFilling = false;
                Drawing.isEraser = false;
                btnEraser.setBackground(null);
//                Drawing.isShape = !(Drawing.isShape);
                DrawingShape.changeRectState();
                Drawing.isShape = DrawingShape.CheckState();
                DrawingShape.typeOfShape = DrawingShape.RECT;

                ChangebtnRectState();
                ChangebtnOvalState();
                ChangebtnLineState();

            } else if (e.getSource() == btnOval){
                Drawing.isText = false;
                Drawing.isFilling = false;
                Drawing.isEraser = false;
                btnEraser.setBackground(null);
//                Drawing.isShape = !(Drawing.isShape);
                DrawingShape.changeOvalState();
                Drawing.isShape = DrawingShape.CheckState();
                DrawingShape.typeOfShape = DrawingShape.OVAL;

                ChangebtnRectState();
                ChangebtnOvalState();
                ChangebtnLineState();

            } else if (e.getSource() == btnLine){
                Drawing.isText = false;
                Drawing.isFilling = false;
                Drawing.isEraser = false;
                btnEraser.setBackground(null);
//                Drawing.isShape = !(Drawing.isShape);
                DrawingShape.changeLineState();
                Drawing.isShape = DrawingShape.CheckState();
                DrawingShape.typeOfShape = DrawingShape.LINE;

                ChangebtnRectState();
                ChangebtnOvalState();
                ChangebtnLineState();

            }
        };
        btnRect.addActionListener(shapeAction);
        btnOval.addActionListener(shapeAction);
        btnLine.addActionListener(shapeAction);
//------------------------------------------------------------------------------------------------------
        int max = 70, minVal = 3;
        String[] arrSz = new String[max];
        for (int i = 0; i < max; i++) {
            arrSz[i] = "  " + (i + 5) + " ";
        }

        JPanel cbPanel = new JPanel();
        cbPanel.setLayout(new GridLayout(2,2));
        cbPanel.setBackground(Color.lightGray);
        controlPanel.add(cbPanel);

        // PEN SIZE Combo_box --------------------------
        JLabel jSize = new JLabel("<html><font color='Black'>  Thickness : </font></html>");
        cbPanel.add(jSize);
        jcSize = new JComboBox<>(arrSz);
        jcSize.setSelectedIndex(0);
        cbPanel.add(jcSize);
        jcSize.addActionListener(e -> {
            for (int i = 0; i < max; i++) {
                if (jcSize.getSelectedIndex() == i) {
                    Drawing.penSize = i + minVal;
                }
            }
            if(Drawing.isText) {
                TextTool.setTextSize(Drawing.penSize);
                btnText.setBackground(Color.red);
            }
        });

        // BRUSH combo box ----------------------------
        JLabel label = new JLabel("<html><font color='Black'>  Brush : </font></html>");
        cbPanel.add(label);

        String[] arrBrush = {" Brush 1 ", //bs1
                " Brush 2 ", //brush
                " Pencil  "}; //bs4
        jcBrush = new JComboBox<>(arrBrush);
        jcBrush.setSelectedIndex(0);
        cbPanel.add(jcBrush);
        jcBrush.addActionListener(e -> {
            if(jcBrush.getSelectedIndex() == 0)
                Drawing.brushOption = 1;
            else if(jcBrush.getSelectedIndex() == 1)
                Drawing.brushOption = 2;
            else if(jcBrush.getSelectedIndex() == 2)
                Drawing.brushOption = 3;
        });

        controlPanel.add(new JLabel(" "));

        // TEXT button ---------------------------------
        btnText.setBackground(null);
        controlPanel.add(btnText);
        btnText.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconText = new ImageIcon(getClass().getResource("icons/Type.png"));
        btnText.setIcon(iconText);
        btnText.setMnemonic(KeyEvent.VK_T);

        btnText.addActionListener(e -> {
            Drawing.isFilling = false;
            btnFill.setBackground(null);
            Drawing.isEraser = false;
            btnEraser.setBackground(null);
            setShapeDisable();

            if(!Drawing.isText){
                TextTool.showLastDialog(Drawing.graphic2d);
                Drawing.isText = true;
                btnText.setBackground(Color.red);
            } else {
                Drawing.isText = false;
                btnText.setBackground(null);
            }
        });


        // FILL button -----------------------------------
        controlPanel.add(btnFill);
        btnFill.setMargin(new Insets(0, 0,0,0));
        btnFill.setMnemonic(KeyEvent.VK_D);
        Icon iconFill = new ImageIcon(getClass().getResource("icons/Fill-Color.png"));
        btnFill.setIcon(iconFill);

        btnFill.addActionListener(e -> {
            Drawing.isEraser = false;
            btnEraser.setBackground(null);
            Drawing.isShape = false;
            setShapeDisable();
            if(Drawing.isFilling){
                Drawing.isFilling = false;
                btnFill.setBackground(null);
            } else {
                Drawing.isFilling = true;
                Drawing.isText = false;
                btnText.setBackground(null);
                btnFill.setBackground(Color.YELLOW);
            }
        });


        // ERASER button --------------------------------
        controlPanel.add(btnEraser);
        btnEraser.setMnemonic(KeyEvent.VK_E);
        Icon iconEraser = new ImageIcon(getClass().getResource("icons/Eraser.png"));
        btnEraser.setIcon(iconEraser);
        btnEraser.setMargin(new Insets(-1, -1,-1,-1));
        btnEraser.addActionListener(e -> {
            setShapeDisable();
            Drawing.isFilling = false;
            btnFill.setBackground(null);
            Drawing.isEraser = !Drawing.isEraser;
            if(Drawing.isEraser) btnEraser.setBackground(Color.ORANGE);
            else btnEraser.setBackground(null);
            Drawing.isText = false;
            btnText.setBackground(null);
            drawArea.Eraser();
        });
//////////////////////////////////////////////////////////////////
        JPanel replayContainer = new JPanel();
        replayContainer.setLayout(new GridLayout(2,1));
        JCheckBox chkVid = new JCheckBox("Record Video");         // RECORD check box -----------------------------
        chkVid.setMnemonic(KeyEvent.VK_V);
        chkVid.addItemListener(e -> Drawing.isRecord =           // bat event cho checkbox
                e.getStateChange() == ItemEvent.SELECTED);

        replayContainer.add(chkVid);


        // Táº O VIDEO REPLAY ------------------
        Icon iconVideo = new ImageIcon(getClass().getResource("icons/Rotate Left.png"));
        btnVid.setIcon(iconVideo);
        replayContainer.add(btnVid);
        btnVid.setMargin(new Insets(-1, -1,-1,-1));
        btnVid.addActionListener(actionEvent -> {
            ReplayVideo Vid = new ReplayVideo();
            try {
                if(Drawing.MaxNumFrame != 1){
                    Vid.ShowVid(Drawing.sDir);      // Náº¿u sá»‘ frame lá»›n nháº¥t hiá»‡n táº¡i lá»›n hÆ¡n 1 -> PLAY VIDEO
                } else {
                    JOptionPane.showMessageDialog(null,"You must draw first !",
                            "Wait ...", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        });
        controlPanel.add(new JLabel(" "));
        controlPanel.add(replayContainer);




        JCheckBox chkShift = new JCheckBox("Shift");         // Shift check box -----------------------------
        chkShift.setMnemonic(KeyEvent.VK_Q);
        chkShift.addItemListener(e -> DrawingShape.isShift =           // báº¯t sá»± kiá»‡n cho checkbox
                e.getStateChange() == ItemEvent.SELECTED);
        //controlPanel.add(chkShift);
        controlPanel.add(new JLabel(" "));





        controlPanel.add(btnClear);                                     // CLEAR button -------------------
        btnClear.setMnemonic(KeyEvent.VK_C);
        Icon iconClear = new ImageIcon(getClass().getResource("icons/Trash.png"));
        btnClear.setIcon(iconClear);
        btnClear.setMargin(new Insets(3, 3,3,3));
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Drawing.isFilling = false;
                Drawing.isEraser = false;
                btnEraser.setBackground(null);
                Drawing.isText = false;
                btnText.setBackground(null);
                isSaved = true;             // áº£nh trá»‘ng -> khĂ´ng cáº§n save

                Icon logo = new ImageIcon(getClass().getResource("image/logo2.png"));
                int n = JOptionPane.showConfirmDialog(null,
                        "DO YOU WANT TO CLEAR ALL ?!",
                        "Wait ...!", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,logo);
                if(!(n == JOptionPane.CANCEL_OPTION || n == JOptionPane.CLOSED_OPTION)){
                    drawArea.Clear();
                    btnFill.setBackground(null);
                    drawArea.DeleteCapFrame();
                }
            }
        });
        controlPanel.add(new JLabel(" "));

        // HELP button: CĂ�C CHá»ˆ DáºªN Vá»€ PHĂ�M Táº®T -------------
        controlPanel.add(btnHelp);
        btnHelp.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconHelp = new ImageIcon(getClass().getResource("icons/info.png"));
        btnHelp.setIcon(iconHelp);
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Icon icon = new ImageIcon(getClass().getResource("image/logo1.png"));
                JOptionPane.showMessageDialog(null,
                        "1. Alt + C to Clear All\n" +
                                "2. Alt + E to use Eraser Tool\n" +
                                "3. Alt + D to turn on Fill Tool\n" + //ALT + F KHĂ”NG KHáº¢ Dá»¤NG
                                "4. Alt + O to Open image\n" +
                                "5. Alt + S to Save file as .png image\n" +
                                "6. Alt + T to choose Text Tool\n" +
                                "7. Alt + Z to undo\n" +
                                "8. Alt + R to redo\n" +
                                "9. Alt + V to start/end Record video", "HELP",
                        JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });

//////////////////////////////////// colorchooser ------------- colorpanel ben duoi
        //------------------------------------------------------------------------------------



        ratio = new JLabel(" ZOOM: 100.0% ");
        ratio.setForeground(Color.black);
        colorPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
        JLabel titleColor = new JLabel(" COLOR : ");
        titleColor.setForeground(Color.black);
        colorPanel.add(titleColor);

        colorPanel.add(curColor);
        colorPanel.add(ratio);
        /*colorPanel.add(btnGray);
        colorPanel.add(btnDarkGray);
        colorPanel.add(btnBlack); //1
        colorPanel.add(btnBrown);
        colorPanel.add(btnMaroon);

        colorPanel.add(btnPurple);

        colorPanel.add(btnMagenta);
        colorPanel.add(btnRed);
        colorPanel.add(btnOrange);
        colorPanel.add(btnYellow);
        colorPanel.add(btnLime);
        colorPanel.add(btnCyan);
        colorPanel.add(btnTeal);
        colorPanel.add(btnGreen);
        colorPanel.add(btnOlive); //16
        colorPanel.add(btnBlue);*/





//-----------------------------------------------------------------------------
        // EDIT COLOR button ---------------------------
        
        btnEditColor.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconColor = new ImageIcon(getClass().getResource("icons/colorchooser.png"));
        btnEditColor.setIcon(iconColor);
        btnEditColor.addActionListener(e -> {
            drawArea.ColorChooser(ColorChooser.EditColor());
            Drawing.isEraser = false;
            btnEraser.setBackground(null);
        });



        colorPanel.add(new JLabel("  "));
        JButton del = new JButton("Delete Records");   // XĂ“A CĂ�C Báº¢N GHI Cá»¦A VIDEO REPLAY ----------------
        colorPanel.add(del);
        colorPanel.add(new JLabel("  "));
        del.setMargin(new Insets(0,1,0,1));

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArea.DeleteCapFrame();
                Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
                JOptionPane.showMessageDialog(null, "Completed !",
                        "Notice ", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });

//--------------------
        JLabel titleZoom = new JLabel("  ZOOM  ");
        titleZoom.setForeground(Color.black);
        colorPanel.add(titleZoom);

        // ZOOM (IN/OUT) BUTTON -----------------------
        Icon iconZout = new ImageIcon(getClass().getResource("icons/Zoom-Out.png"));
        btnZoomOut.setIcon(iconZout);
        btnZoomOut.addActionListener(e -> Zoom(true));
        colorPanel.add(btnZoomOut);
        btnZoomOut.setMargin(new Insets(-1, -1,-1,-1));

        Icon iconZin = new ImageIcon(getClass().getResource("icons/Zoom-In.png"));
        btnZoomIn.setIcon(iconZin);
        btnZoomIn.setMargin(new Insets(-1, -1,-1,-1));
        btnZoomIn.addActionListener(e -> Zoom(false));
        colorPanel.add(btnZoomIn);

        drawArea.addMouseWheelListener(e -> {                       // Sá»± kiá»‡n lÄƒn chuá»™t ------------------
            int steps = e.getWheelRotation();
            scale -= steps*5;
            try {
                Zoom(scale);
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Too small/large !");
            }
        });

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {      // sá»± kiá»‡n close window -------------

                if(!isSaved) {
                    Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
                    int n = JOptionPane.showConfirmDialog(null,
                            "Do you want to SAVE image before EXIT ?",
                            "Before EXIT ...", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);
                    if (n == JOptionPane.NO_OPTION) {
                        drawArea.DeleteCapFrame();
                        Drawing.graphic2d.dispose();                        // Há»¦Y Ä�á»�I TÆ¯á»¢NG GRAPHIC KHI EXIT
                        System.exit(0);
                    } else if (n == JOptionPane.OK_OPTION){
                        if(new OpenAndSaveImage().SaveImg(Drawing.image)) {
                            drawArea.DeleteCapFrame();
                            Drawing.graphic2d.dispose();
                            System.exit(1);
                        }
                    }
                } else {
                    Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
                    int n = JOptionPane.showConfirmDialog(null,
                            "Do you want to EXIT ?",
                            "EXIT", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, icon);
                    if(n == JOptionPane.OK_OPTION){
                        System.exit(2);
                    }
                }
            }
        });
//        frame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode() == KeyEvent.VK_SHIFT)
//                DrawingShape.isShift = !DrawingShape.isShift;
//            }
//        });

        frame.setJMenuBar(CreateMenu());
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int frWidth = (int) (w * 0.85);
        int frHeight = (int) (h * 0.95);
        frame.setBounds((w - frWidth)/2, (h - frHeight)/2 - 10, frWidth, frHeight);

        String dir = getClass().getResource("icons/pen.png").toString().substring(5);
        File f = new File(dir);
        Image i = createImage(10,10);
        try{
            i = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(i != null){
            Cursor penCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                    i, new Point(0,0),"penCursor" );
            frame.setCursor(penCursor);
        }
        frame.setIconImage(Toolkit.getDefaultToolkit().
                getImage(getClass().getResource("image/icon.png")));
        frame.setVisible(true);
    }

    public JMenuBar CreateMenu(){                   // Táº¡o MENU cho chÆ°Æ¡ng trĂ¬nh ---------------------------
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu(" File ");
        JMenu menuEdit = new JMenu(" Edit ");

        JMenuItem iOpen = new JMenuItem(" Open ");
        JMenuItem iSave = new JMenuItem(" Save ");
        JMenuItem iUndo = new JMenuItem(" Undo ");
        JMenuItem iRedo = new JMenuItem(" Redo ");

        Icon iconOpen = new ImageIcon(getClass().getResource("image/open.png"));
        Icon iconSave = new ImageIcon(getClass().getResource("image/save.png"));
        Icon iconUndo = new ImageIcon(getClass().getResource("image/undo.png"));
        Icon iconRedo = new ImageIcon(getClass().getResource("image/redo.png"));

        iOpen.setIcon(iconOpen);
        iSave.setIcon(iconSave);
        iUndo.setIcon(iconUndo);
        iRedo.setIcon(iconRedo);

        iOpen.addActionListener(e -> {
            Drawing.isFilling = false;
            btnFill.setBackground(null);
            OpenAndSaveImage open = new OpenAndSaveImage();
            Drawing.buffImg2 = open.OpenImg();
            drawArea.Open(Drawing.buffImg2);
            scale = 0;
        });
        iSave.addActionListener(e -> {
//            Drawing.isFilling = false;
//            btnFill.setBackground(null);
//            Drawing.isEraser = false;
//            btnEraser.setBackground(null);
            OpenAndSaveImage save = new OpenAndSaveImage();
            isSaved = save.SaveImg(Drawing.image);
        });
        iUndo.addActionListener(e -> drawArea.Undo(true));
        iRedo.addActionListener(e -> drawArea.Undo(false));
        menuFile.add(iOpen);
        menuFile.add(iSave);
        menuEdit.add(iUndo);
        menuEdit.add(iRedo);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.setBackground(Color.gray);
        return menuBar;
    }

    void Zoom(boolean isZoomOut){               // Zoom khi báº¥m nĂºt
        scale += (isZoomOut)? -10:10;           // scale tÄƒng/giáº£m má»™t lÆ°á»£ng cá»‘ Ä‘á»‹nh
        try {
            drawArea.Open(ResizeImage.scale(Drawing.buffImg2, Drawing.fwidth, Drawing.fheight, scale));
            float a = (int)((scale/200f + 1) * 10000) / 100f;
            ratio.setText(" ZOOM: " + a + "%   ");
            ratio.setForeground(Color.black);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Too small/large !");
        }
    }
    void Zoom(long scale){                      // Zoom khi lÄƒn chuá»™t
        try {                                   // scale tÄƒng/giáº£m phá»¥ thuá»™c Ä‘á»™ lÄƒn cá»§a chuá»™t
//            scale -= scale % 5;
            drawArea.Open(ResizeImage.scale(Drawing.buffImg2, Drawing.fwidth, Drawing.fheight, scale));
            float a = (int)((scale/200f + 1) * 10000) / 100f;
            ratio.setText(" ZOOM: " + a + "%    ");
            ratio.setForeground(Color.black);

        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Too small/large !");
        }
    }
    void ChangebtnRectState(){
        if(!DrawingShape.isRect){
            btnRect.setIcon(new ImageIcon(getClass().getResource("image/rectangle.png")));
        } else {
            btnRect.setIcon(new ImageIcon(getClass().getResource("image/rectangle1.png")));
        }
    }
    void ChangebtnOvalState(){
        if(!DrawingShape.isOval){
            btnOval.setIcon(new ImageIcon(getClass().getResource("image/oval.png")));
        } else {
            btnOval.setIcon(new ImageIcon(getClass().getResource("image/oval1.png")));
        }
    }
    void ChangebtnLineState(){
        if(!DrawingShape.isLine){
            btnLine.setIcon(new ImageIcon(getClass().getResource("image/line.png")));
        } else {
            btnLine.setIcon(new ImageIcon(getClass().getResource("image/line1.png")));
        }
    }
    void setShapeDisable(){
        DrawingShape.setDisable();
        ChangebtnLineState();
        ChangebtnOvalState();
        ChangebtnRectState();
        Drawing.isShape = false;
    }
}