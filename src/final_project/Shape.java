/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author sahar
 */
abstract public class Shape {
    private int[] points = new int[4];
    private char color;
    private boolean solid;
    private boolean filled;


    public void setStart(int p1, int p2){
        points[0] = p1;
        points[1] = p2;
    }

    public void setEnd(int p3, int p4){
        points[2] = p3;
        points[3] = p4;
    }

    public void setAttributes(char col, boolean sol){
        color = col;
        solid = sol;
    }

    public void setAttributes(char col, boolean sol, boolean fill){
        color = col;
        solid = sol;
        filled = fill;
    }

    public int[] getPoints(){
        return points;
    }

    public char getColor(){
        return color;
    }

    public boolean getSolidState(){
        return solid;
    }

    public boolean getFilledState(){
        return filled;
    }

    public void draw(Graphics g){
        int[] pts = getPoints();
            char color = getColor();
            boolean solid = getSolidState();
            boolean fill = getFilledState();
            setStart(pts[0], pts[1]);
            setEnd(pts[2], pts[3]);
            setAttributes(color, solid, fill);
            Graphics2D g2d = (Graphics2D) g.create();

            switch (color){
                case 'R':
                    g2d.setColor(Color.RED);
                    break;
                case 'G':
                    g2d.setColor(Color.GREEN);
                    break;
                case 'B':
                    g2d.setColor(Color.BLUE);
                    break;
                    case 'Y':
                    g2d.setColor(Color.YELLOW);
                    break;
                    case 'C':
                    g2d.setColor(Color.CYAN);
                    break;
                    case 'W':
                    g2d.setColor(Color.WHITE); // for eraser
                    break;
            }
                    if (solid == false){
                Stroke dashed = new BasicStroke(2, BasicStroke.CAP_SQUARE, //cap square --- //2 is width of the stroke
                        BasicStroke.JOIN_MITER, 1, new float[]{2, 5}, 0);//5 gab between strokes
                g2d.setStroke(dashed);
            }
            drawThisShape( g2d,  pts, color,  solid,  fill); //el implementation bt3tha f kol class 3lshan trsm kol shape bl configration bt3to

            g2d.dispose(); // release resources after use it
            }
    abstract void drawThisShape(Graphics2D g2d, int[] pts, char color, boolean solid, boolean fill);
    }


