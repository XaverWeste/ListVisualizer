package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Ball extends GraphicalObject {

    protected boolean arrived;
    protected boolean deleted;
    protected ViewController viewController;
    protected QueueBall previousQueueBall;

    public Ball(double x, double y, QueueBall previousQueueBall, ViewController viewController){
        this.x = x;
        this.y = y;
        this.previousQueueBall = previousQueueBall;
        this.viewController = viewController;
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawCircle(x,y,20);
    }

    public boolean tryToDelete(){
        if(arrived){
            deleted = true;
            return deleted;
        }
        return false;
    }
}
