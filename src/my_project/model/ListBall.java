package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class ListBall extends Ball{

    private ListBall previous;
    private ListBall next=null;
    private int r,g,b;

    public ListBall(ListBall previousBall, ViewController viewController){
        x=850;
        y=950;
        previous=previousBall;
        this.viewController=viewController;
        viewController.draw(this);
        r=b=g=255;
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledCircle(x,y,radius-1);
        super.draw(drawTool);
    }

    public void setPrevious(ListBall newPrevius){ previous=newPrevius; }
    public void setNext(ListBall theNext){ next=theNext; }
    public void setR(int newR){ r=newR; }
    public void setG(int newG){ r=newG; }
    public void setB(int newB){ r=newB; }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previous == null || x > previous.getX()+50) x -= 100*dt;
            if (x < 50) arrived = true;
        }
        if(deleted){
            y -= 200*dt;
            if(y > 1100) viewController.removeDrawable(this);
            if(next!=null) next.setPrevious(previous);
        }
    }
}
