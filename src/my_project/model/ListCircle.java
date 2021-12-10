package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListCircle extends GraphicalObject implements AnimatedList.AnimableList {

    public ListCircle(ViewController viewController){

        viewController.draw(this);
        radius = 0;
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(255,255,255,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    public boolean tryToDelete(){
        return false;
    }

}
