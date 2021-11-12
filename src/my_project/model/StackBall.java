package my_project.model;

import KAGO_framework.control.ViewController;

public class StackBall extends Ball {

    private ViewController viewController;
    private StackBall previousStackBall;

    public StackBall(double x, double y, StackBall previousStackBall, ViewController viewController){
        this.x=x;
        this.y = y;
        this.previousStackBall = previousStackBall;
        this.viewController = viewController;
        viewController.draw(this);
    }


    @Override
    public void update(double dt){
        if(!arrived){
            if(previousStackBall == null || y < previousStackBall.getY()+50) y += 100*dt;
            if (y > 950) arrived = true;
        }
        if(deleted){
            y -= 200*dt;
            if(y < -25) viewController.removeDrawable(this);
        }
    }
}