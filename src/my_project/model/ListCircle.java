package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListCircle extends GraphicalObject implements AnimableList<ListCircle> {

    private int r,g,b;
    private boolean isOnPointer=false;
    private boolean arrived=false;
    private boolean deleted=false;
    private final ViewController viewController;
    private ListCircle previous;
    private ListCircle next=null;
    private SoundController soundController;

    public ListCircle(ListCircle previousBall, ViewController viewController){
        if(previousBall!=null){
            x=previousBall.getX()+50;
        }else{
            x=100;
        }
        y=450;
        previous=previousBall;
        this.viewController=viewController;
        viewController.draw(this);
        r=b=g=255;
        radius = 0;
        soundController=new SoundController();
        sounds(soundController);
    }

    public void draw(DrawTool drawTool){
        if(isOnPointer){
            drawTool.setCurrentColor(150,150,0,255);
            drawTool.drawFilledCircle(x,y,radius+5);
        }
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    public void setPrevious(ListCircle newPrevious){ previous=newPrevious; }
    public void setNext(ListCircle theNext){ next=theNext; }
    public void setColorBlack(){ r=g=b=0; }
    public void setR(){
        setColorBlack();
        r=255;
    }
    public void setG(){
        setColorBlack();
        g=255;
    }
    public void setB(){
        setColorBlack();
        b=255;
    }
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
        if(radius<20) radius+=5*dt;
        if(deleted){
            if(isOnPointer){
                if(next!=null) next.changePointer();
            }
            radius-=5*dt;
            if(radius<=0) viewController.removeDrawable(this);
            if(next!=null) next.setPrevious(previous);
        }
    }


    //TODO untere Methoden implementieren
    @Override
    public void deleteAnimation(double dt) {

    }

    @Override
    public void spawnAnimation(double dt) {

    }

    public void sounds(SoundController soundController){

    }
}
