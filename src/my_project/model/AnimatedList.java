package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.view.DrawTool;

public class AnimatedList <T extends GraphicalObject & AnimatedListInterface>{

    private ListBall previous;
    private ListBall next=null;
    private boolean isOnPointer;
    private boolean arrived;
    private boolean deleted;
    private ViewController viewController;
    private List<T> list=new List();

    public AnimatedList(ListBall previousBall, ViewController viewController){
        previous=previousBall;
        this.viewController=viewController;
        isOnPointer=false;
        arrived = false;
        deleted = false;

        //viewController.draw(this);
    }

    public void draw(DrawTool drawTool){

    }

    public void setPrevious(ListBall newPrevious){ previous=newPrevious; }
    public void setNext(ListBall theNext){ next=theNext; }
    public ListBall getPrevious(){ return previous; }
    public boolean tryToDelete(){
        return deleted=true;
    }

    public void update(double dt){

    }
}