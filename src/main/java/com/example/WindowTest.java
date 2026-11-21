package com.example;

import javax.swing.*;
import java.awt.*;

public class WindowTest extends JFrame {

    public WindowTest(String title)  {
        super(title);
    }

    static void main() {

        WindowTest w=new WindowTest("My Window");
        w.setLayout(null);
        w.setSize(400,400);
        w.setVisible(true);
        w.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}