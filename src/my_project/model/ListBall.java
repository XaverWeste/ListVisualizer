package my_project.model;

import KAGO_framework.control.ViewController;

public class ListBall extends Ball{

    private ListBall previous;

    public ListBall(ListBall previousBall, ViewController viewController){
        x=850;
        y=950;
        previous=previousBall;
        this.viewController=viewController;
        viewController.draw(this);
    }

    public void setPrevious(ListBall newPrevius){ previous=newPrevius; }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previous == null || x > previous.getX()+50) x -= 100*dt;
            if (x < 50) arrived = true;
        }
        if(deleted){
            y -= 200*dt;
            if(y > 1100) viewController.removeDrawable(this);
        }
    }
}
