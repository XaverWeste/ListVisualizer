package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class TwoDimesionalArray extends GraphicalObject {

    private final ViewController viewController;
    private final ArrayBall[][] array;
    private final double[] koordinaten;

    public TwoDimesionalArray(ViewController viewController){
        this.viewController=viewController;
        array = new ArrayBall[8][4];
        koordinaten = new double[]{225,275,325,375,425,475,525,575,325,375,425,475};
        viewController.draw(this);
    }

    public void changeBall(int x,int y){
        if(x>=0&&y>=0&&y<8&&x<4){
            if(array[y][x]==null) {
                array[y][x] = new ArrayBall(koordinaten[8 + x], koordinaten[y], viewController);
            }else{
                array[y][x].tryToDelete();
                array[y][x] = null;
            }
        }
    }

    public void changeColor(int x,int y){
        if(x>=0&&y>=0&&y<8&&x<4&&array[y][x]!=null){
            array[y][x].changeColor();
        }
    }

    public void clearColor(int x,int y){
        if(x>=0&&y>=0&&y<8&&x<4&&array[y][x]!=null){
            array[y][x].clearColor();
        }
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(300,200,200,400);
        drawTool.drawLine(350,200,350,600);
        drawTool.drawLine(400,200,400,600);
        drawTool.drawLine(450,200,450,600);
        drawTool.drawLine(300,250,500,250);
        drawTool.drawLine(300,300,500,300);
        drawTool.drawLine(300,350,500,350);
        drawTool.drawLine(300,400,500,400);
        drawTool.drawLine(300,450,500,450);
        drawTool.drawLine(300,500,500,500);
        drawTool.drawLine(300,550,500,550);
    }

    public void update(double dt){

    }
}