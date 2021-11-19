package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;

public class StackBall extends Ball {

    private final StackBall previousStackBall;
    private boolean isFilled=false;

    public StackBall(double y, StackBall previousStackBall, ViewController viewController){
        this.x=50;
        this.y = y;
        this.previousStackBall = previousStackBall;
        this.viewController = viewController;
        viewController.draw(this);
    }

    public void draw(DrawTool drawTool){
        super.draw(drawTool);
        if(isFilled) drawTool.drawFilledCircle(x,y,radius);
    }

    public void changeFilled(){
        isFilled = !isFilled;
    }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousStackBall == null || y < previousStackBall.getY()-50) y += 100*dt;
            if (y > 850||previousStackBall!=null&&previousStackBall.arrived&&y >= previousStackBall.getY()-49) arrived = true;
        }
        if(deleted){
            x -= 200*dt;
            if(x < -25) viewController.removeDrawable(this);
        }
    }
}