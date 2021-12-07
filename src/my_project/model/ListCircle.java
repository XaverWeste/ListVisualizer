package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;

public class ListCircle extends ListObject implements AnimableList<ListCircle> {

    private final ViewController viewController;

    public ListCircle(ListCircle previousBall, ViewController viewController){
        arrived=deleted=false;
        if(previousBall!=null){
            x=previousBall.getX()+50;
        }else{
            x=100;
        }
        y=450;
        previous=previousBall;
        this.viewController=viewController;
        viewController.draw(this);
        radius = 0;
    }

    public void draw(DrawTool drawTool){
        if(isOnPointer){
            drawTool.setCurrentColor(150,150,0,255);
            drawTool.drawFilledCircle(x,y,radius+5);
        }
        drawTool.setCurrentColor(255,255,255,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    public void setPrevious(ListCircle newPrevious){ previous=newPrevious; }
    public void setNext(ListCircle theNext){ next=theNext; }
    public void changePointer(){ isOnPointer=!isOnPointer; }

    public ListCircle getPrevious(){ return previous; }

    public boolean tryToDelete(){
        if(this.getPrevious()!=null&&this.getNext()!=null){
            this.getPrevious().setNext(this.getNext());
        }else if(this.getPrevious()!=null&&this.getNext()==null){
            this.getPrevious().setNext(null);
        }
        return deleted=true;
    }

    public ListCircle getNext(){ return next; }

    public void update(double dt){
        if(radius>=20) arrived=true;
        if(!arrived) radius += 5*dt;
        if(deleted){
            radius=radius-5*dt;
            if(radius<=0) viewController.removeDrawable(this);
        }
    }

    @Override
    public void deleteAnimation(double dt) {

    }

    @Override
    public void spawnAnimation(double dt) {

    }

    public void sounds(SoundController soundController){

    }
}
