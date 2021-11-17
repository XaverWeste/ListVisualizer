package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;

public class ListBall extends Ball{

    private final List<ListBall> list;
    private ListBall previous;

    public ListBall(List<ListBall> ballList, ViewController viewController){
        x=850;
        y=950;
        list=ballList;
        this.viewController=viewController;
        viewController.draw(this);
        previous=getPrevius();
    }

    private ListBall getPrevius(){
        if(!list.isEmpty()) {
            list.toFirst();
            int i = 0;
            while (!list.equals(this)) i++;
            int j = 0;
            list.toFirst();
            while (j < i - 1) list.next();
            return list.getContent();
        }
        return null;
    }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previous == null || x > previous.getX()+50) x -= 100*dt;
            if (x < 100) arrived = true;
        }
        if(deleted){
            y -= 200*dt;
            if(y > 1100) viewController.removeDrawable(this);
        }
        previous=getPrevius();
    }
}
