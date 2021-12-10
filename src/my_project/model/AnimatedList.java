package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;

public class AnimatedList <T extends GraphicalObject & AnimatedList.AnimableList> {

    public interface AnimableList {
        boolean tryToDelete();
    }

    private final List<T> list=new List();
    private final double xAbstand;
    private final double yAbstand;
    private T current;

    public void append(T t){
        if(!list.isEmpty()) {
            list.append(t);
            t.setX(getPrevious(t).getX() + xAbstand);
            t.setX(getPrevious(t).getY() + yAbstand);
        }
    }

    public void insert(T t){
        if(!list.isEmpty()) {
            toCurrent();
            list.insert(t);
            t.setX(getPrevious(t).getX() + xAbstand);
            t.setX(getPrevious(t).getY() + yAbstand);
            while (list.getContent() != null) {
                toCurrent();
                list.getContent().setX(getPrevious(t).getX() + xAbstand);
                list.getContent().setX(getPrevious(t).getY() + yAbstand);
            }
        }
    }

    public void delete(){
        if(!list.isEmpty()) {
            toCurrent();
            if (list.getContent().tryToDelete()) {
                list.remove();
            }
        }
    }

    public AnimatedList(double xAbstand,double yAbstand){
        this.xAbstand=xAbstand;
        this.yAbstand=yAbstand;
        list.toFirst();
    }

    public void toFirst(){
        if(list.hasAccess()) {
            list.toFirst();
            current = list.getContent();
        }
    }

    public void next(){
        if(list.hasAccess()) {
            toCurrent();
            list.next();
            current = list.getContent();
        }
    }

    public void previous(){
        if(list.hasAccess()) {
            toCurrent();
            list.toFirst();
            if(list.getContent()!=current) {
                int i=0;
                while(list.getContent()!=current) {
                    list.next();
                    i++;
                }
                list.toFirst();
                for(int j=0;j<i;j++) list.next();
                current = list.getContent();
            }
        }
    }

    private void toCurrent(){
        if(list.hasAccess()){
            while(list.getContent()!=current){
                list.next();
                if(list.getContent()==null)
                    list.toFirst();
            }
        }
    }

    public T getCurrent(){
        return list.getContent();
    }

    public T getNext(T t){
        list.toFirst();
        while(!list.equals(t)&&list.getContent()!=null){
            list.next();
        }
        if(list.equals(t)){
            list.next();
            return list.getContent();
        }
        toCurrent();
        return null;
    }

    public T getPrevious(T t){
        list.toFirst();
        if(list.getContent().equals(t)) {
            int i=0;
            while(list.getContent().equals(t)) {
                list.next();
                i++;
            }
            list.toFirst();
            for(int j=0;j<i;j++) list.next();
            return list.getContent();
        }
        toCurrent();
        return null;
    }
}