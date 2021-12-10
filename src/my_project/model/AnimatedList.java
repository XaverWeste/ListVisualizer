package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;

public class AnimatedList <T extends GraphicalObject & AnimableList<T>> {

    public interface AnimableList {
        boolean tryToDelete();
    }

    private final List<T> list=new List();
    private final double xAbstand;
    private final double yAbstand;
    private T current;

    public AnimatedList(double xAbstand,double yAbstand){
        this.xAbstand=xAbstand;
        this.yAbstand=yAbstand;
        list.toFirst();
    }


}