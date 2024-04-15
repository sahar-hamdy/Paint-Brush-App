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
class Oval extends Shape{

        public Oval(){

        }

        public Oval(Shape oval){
            int[] pts = oval.getPoints();
            char color = oval.getColor();
            boolean solid = oval.getSolidState();
            boolean fill = oval.getFilledState();
            setStart(pts[0], pts[1]);
            setEnd(pts[2], pts[3]);
            setAttributes(color, solid, fill);
        }
        @Override
         void drawThisShape(Graphics2D g2d, int[] pts, char color, boolean solid, boolean fill) {
        if (fill == true)
            g2d.fillOval(pts[0], pts[1], pts[2], pts[3]);
        else
            g2d.drawOval(pts[0], pts[1], pts[2], pts[3]);
    }
    }
