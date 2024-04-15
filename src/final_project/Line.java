/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_project;

import java.awt.Graphics2D;

/**
 *
 * @author sahar
 */
public class Line extends Shape {
     public Line(){

        }

        public Line(Shape line){    // why shape line argument???
            int[] pts = line.getPoints();
            char color = line.getColor();
            boolean solid = line.getSolidState();
            setStart(pts[0], pts[1]);
            setEnd(pts[2], pts[3]);
            setAttributes(color, solid);
        }

@Override
          void drawThisShape(Graphics2D g2d, int[] pts, char color, boolean solid, boolean fill) {
        g2d.drawLine(pts[0], pts[1], pts[2], pts[3]);
    }  
    }

