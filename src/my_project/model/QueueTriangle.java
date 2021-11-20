package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;

public class QueueTriangle extends Object {

    private final QueueTriangle previousQueueTriangle;
    private boolean up;

    public QueueTriangle(double x, double y, QueueTriangle previousQueueTriangle, ViewController viewController){
        this.previousQueueTriangle=previousQueueTriangle;
        this.x = x;
        this.y = y;
        this.viewController = viewController;
        if(previousQueueTriangle!=null){
            up=!previousQueueTriangle.getUp();
        }else{
            up=true;
        }
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0,0,0,255);
        if(up){
            drawTool.drawTriangle(x,y-20,x-20,y+20,x+20,y+20);
        }else{
            drawTool.drawTriangle(x,y+20,x-20,y-20,x+20,y-20);
        }
    }

    public boolean getUp(){ return up; }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousQueueTriangle == null || x > previousQueueTriangle.getX()+30) x -= 100*dt;
            if (x < 120) arrived = true;
        }
        if(deleted){
            x -= 200*dt;
            if(x < -25) viewController.removeDrawable(this);
        }
    }
}