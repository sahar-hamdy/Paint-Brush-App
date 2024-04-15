/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package final_project;

import javax.swing.JFrame;

/**
 *
 * @author sahar
 */
public class Paint_Brush_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          JFrame f =new JFrame();
        f.setTitle("Paint Brush");
        DrawShapes painter = new DrawShapes();
        f.setContentPane(painter);
        f.setSize(800, 800);
        f.setVisible(true);
    }
    
}
