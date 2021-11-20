package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;

public class StackRectangle extends Object {

    private final StackRectangle previousStackRectangle;
    private boolean isFilled=false;

    public StackRectangle(double y, StackRectangle previousStackRectangle, ViewController viewController){
        this.x = 50;
        this.y = y;
        this.previousStackRectangle = previousStackRectangle;
        this.viewController = viewController;
        viewController.draw(this);
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,40,20);
        if(isFilled) drawTool.drawFilledRectangle(x,y,40,20);
    }

    public void changeFilled(){
        isFilled = !isFilled;
    }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousStackRectangle == null || y < previousStackRectangle.getY()-20) y += 100*dt;
            if (y > 850|| previousStackRectangle !=null&& previousStackRectangle.arrived&&y >= previousStackRectangle.getY()-25) arrived = true;
        }
        if(deleted){
            x -= 200*dt;
            if(x < -25) viewController.removeDrawable(this);
        }
    }
}