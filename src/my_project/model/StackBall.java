package my_project.model;

import KAGO_framework.control.ViewController;

public class StackBall extends Ball {

    private ViewController viewController;
    private QueueBall previousQueueBall;

    public StackBall(double x, double y, QueueBall previousQueueBall, ViewController viewController){
        this.x=x;
        this.y = y;
        this.previousQueueBall = previousQueueBall;
        this.viewController = viewController;
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }


    @Override
    public void update(double dt){
        if(!arrived){
            if(previousQueueBall == null || y < previousQueueBall.getY()+50) y += 100*dt;
            if (y > 950) arrived = true;
        }
        if(deleted){
            y -= 200*dt;
            if(y < -25) viewController.removeDrawable(this);
        }
    }
}