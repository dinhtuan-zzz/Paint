package com.company;

import javax.swing.*;
import java.awt.*;

public class ColorChooser {
    public static Color EditColor(){
        Drawing.isColorChooser = true;
        return JColorChooser.showDialog(null,
                "EDIT COLOR", Drawing.color);
    }
}
