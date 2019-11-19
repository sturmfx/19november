package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreen extends JFrame implements KeyListener
{
    public static boolean up = false;
    public static boolean down = false;
    public static boolean right = false;
    public static boolean left = false;

    public static int speed = 10;
    public static Color color = Color.RED;
    public static int tick = 10;

    public static int x = 250;
    public static int y = 250;
    public static double x1 = 250.0;
    public static double y1 = 250.0;
    public static int width = 50;
    public static int height = 50;

    public static long temp_time = System.currentTimeMillis();


    public GameScreen(String s)
    {
        super(s);
        JPanel p = new JPanel();
        add(p);
        addKeyListener(this);
        setSize(500, 500);
        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            down = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            down = false;
        }
    }

    public static void loop()
    {
        while(true)
        {
            if(((!up)&&down&&right&&left)||(up&&(!down)&&right&&left)||(up&&down&&(!right)&&left)||(up&&down&&right&&(!left)))
            {
                if(System.currentTimeMillis() - temp_time > tick)
                {
                    temp_time = System.currentTimeMillis();
                    if(up);
                }
            }
        }
    }

    public void paint(Graphics g)
    {
        g.clearRect(0, 0, 500, 500);
        g.fillOval((int)x1, (int)y1, width, height);
    }


    public static void main(String[] args)
    {
        new GameScreen("GAME 1");
        System.out.println(System.currentTimeMillis());
    }
}
