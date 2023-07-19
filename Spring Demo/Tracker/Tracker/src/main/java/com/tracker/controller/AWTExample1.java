package com.tracker.controller;

import java.awt.*;
import java.util.LinkedList;

public class AWTExample1 extends Frame {
    // initializing using constructor
    AWTExample1() {

        // creating a button
        Button b = new Button("Slim!!");

        Frame f = new Frame();
        TextField t = new TextField();
        t.setBounds(20, 100, 80, 30);
        // setting button position on screen
        b.setBounds(30,100,80,30);

        // adding button into frame
        add(b);
        f.add(t);

        // frame size 300 width and 300 height
        setSize(30,30);

        // setting the title of Frame
        setTitle("This is our basic AWT example");

        // no layout manager
        setLayout(null);

        // now frame will be visible, by default it is not visible
        setVisible(true);

        // frame size 300 width and 300 height
        f.setSize(400,300);

        // setting the title of frame
        f.setTitle("Employee info");

        // no layout
        f.setLayout(null);

        // setting visibility of frame
        f.setVisible(true);

    }

    // main method
    public static void main(String args[]) {

// creating instance of Frame class
        AWTExample1 f = new AWTExample1();

    }

}
