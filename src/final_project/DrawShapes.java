package final_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class DrawShapes extends JPanel {

    private Button pencilButton, lineButton, ovalButton, rectButton,redButton, greenButton, blueButton, yellowButton, cyanButton
            ,eraseButton, clearAllButton; 
    private Checkbox fillBox, dottedBox;
    private char currColor, currShape;
    private boolean fillChk = false, solidChk = true, eraseChk = false, clearAll = false, eraseHere = false, doddled = false;
    private int x0, y0,x1, y1, x2, y2;
    ArrayList<Shape> shapes = new ArrayList<>();
    Shape pencil = new Line(); 
    Shape line = new Line();
    Shape rect = new Rectangle();
    Shape rectEraser = new Rectangle();
    Shape oval = new Oval();

    public DrawShapes() {
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        pencilButton = new Button(" Free Hand ");
        lineButton = new Button(" Line ");
        ovalButton = new Button(" Oval ");
        rectButton = new Button(" Rect ");
        fillBox = new Checkbox(" Fill ");
        dottedBox = new Checkbox(" Dotted ");
        redButton = new Button();
        redButton.setBackground(Color.RED);
        redButton.setPreferredSize(new Dimension(40, 40));
        greenButton = new Button();
        greenButton.setBackground(Color.green);
        greenButton.setPreferredSize(new Dimension(40, 40));
        blueButton = new Button();
        blueButton.setBackground(Color.blue);
        blueButton.setPreferredSize(new Dimension(40, 40));
        yellowButton = new Button();
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setPreferredSize(new Dimension(40, 40));
        cyanButton = new Button();
        cyanButton.setBackground(Color.CYAN);
        cyanButton.setPreferredSize(new Dimension(40, 40));
        eraseButton = new Button(" Eraser ");
        clearAllButton = new Button(" Clear All ");
        
        pencilButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currShape = 'P';
                eraseChk = false;}
        });
        lineButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currShape = 'L';
                eraseChk = false;}
        });
        ovalButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currShape = 'O';
                eraseChk = false;}
        });
        rectButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currShape = 'R';
                eraseChk = false;}
        });
        fillBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fillChk = e.getStateChange()==1;  // if checked 1 checked again 2 
                eraseChk = false;}
        });
        dottedBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                solidChk = e.getStateChange() != 1;
            }
                 
        });
        redButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currColor = 'R';}
        });
        greenButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currColor = 'G';}
        });
        blueButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currColor = 'B';}
        });
        yellowButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currColor = 'Y';}
        });
        cyanButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                currColor = 'C';}
        });   
        eraseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                eraseChk = true;
                currShape = 'e';}
        });
        clearAllButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                clearAll = true;
                eraseChk = false;
                repaint();}
        });
        
        this.add(pencilButton);
        this.add(lineButton);
        this.add(ovalButton);
        this.add(rectButton);
        this.add(dottedBox);
        this.add(fillBox);
        this.add(redButton);
        this.add(greenButton);
        this.add(blueButton);
        this.add(yellowButton);
        this.add(cyanButton);
        this.add(eraseButton);
        this.add(clearAllButton);

        this.addMouseListener(new MouseEvents());
        this.addMouseMotionListener(new MouseEvents());
    }

    class MouseEvents extends MouseAdapter{
       @Override
        public void mousePressed(MouseEvent e){
            x0 = e.getX();
            y0 = e.getY();
            if(eraseChk)
                eraseHere = true;
        }
        @Override
        public void mouseDragged(MouseEvent e){
           
            if(eraseChk){
                eraseHere = true;
                x0 = e.getX(); //update currx with the mouse position
                y0 = e.getY();
                repaint();
            }
            else if(currShape == 'R' || currShape == 'O'){
                x1 = Math.min(e.getX(), x0); //x1 and y1 are the top-left coordinates of the rectangle
                y1 = Math.min(e.getY(), y0);
                x2 = Math.abs(e.getX() - x0);// the width of the rectangle/oval
                y2 = Math.abs(e.getY() - y0);  //the height of the rectangle/oval
                repaint();
            }
            else if (currShape == 'L'){
                x2 = e.getX();
                y2 = e.getY();
                repaint();
            }
            else if(currShape == 'P'){
                if (doddled){  
                    x0 = x2;
                    y0 = y2;
                }
                //hena hyrsm one point w hy5ly el flag b true so hyd5ol fel if w hy5ly el point di heya el bedaya w hakza till release el mouse
                x2 = e.getX(); 
                y2 = e.getY();
                repaint();
                shapes.add(new Line(pencil));
                doddled = true;
            }

            if(eraseHere)
                shapes.add(new Rectangle(rectEraser));
        }
@Override
        public void mouseReleased(MouseEvent e){
            if ( currShape != 'e'){
                switch (currShape){
                    case 'P':
                        doddled = false;
                        break;
                    case 'L':
                        shapes.add(new Line(line)); //create new Line object from copy it from line and add it to shapes array
                        break;
                    case 'O':
                        shapes.add(new Oval(oval));
                        break;
                    case 'R':
                        shapes.add(new Rectangle(rect));
                        break;
                }
            }
            else 
            {
                repaint();
                shapes.add(new Rectangle(rectEraser));
                eraseHere = false;
            }  
        }
    }
@Override
    public void paint(Graphics g){
        super.paint(g);
        if (!clearAll)
            for(Shape s:shapes) //s=shapes[i]
                  s.draw(g);
        if(clearAll){
            shapes.clear();
            clearAll = false;
        }
        else if(eraseChk){
            rectEraser.setStart(x0-5, y0-5); //slightly offest from mouse press position
            rectEraser.setEnd(15, 25);
            rectEraser.setAttributes('W', true, true);
            g.drawRect(x0-5, y0-5, 15, 25);
            if(eraseHere){
                rectEraser.draw(g); 
            }
        }
        else if(currShape == 'P'){
            pencil.setStart(x0, y0);
            pencil.setEnd(x2, y2);
            pencil.setAttributes(currColor, solidChk);
            pencil.draw(g);
        }
        else if(currShape == 'L'){
            line.setStart(x0, y0);
            line.setEnd(x2, y2);
            line.setAttributes(currColor, solidChk);
            line.draw(g);
        }
        else if(currShape == 'O'){
            oval.setStart(x1, y1);
            oval.setEnd(x2, y2);
            oval.setAttributes(currColor, solidChk, fillChk);
            oval.draw(g);
        }
        else if(currShape == 'R'){
            rect.setStart(x1, y1);
            rect.setEnd(x2, y2);
            rect.setAttributes(currColor, solidChk, fillChk);
            rect.draw(g);
        }
    }
}