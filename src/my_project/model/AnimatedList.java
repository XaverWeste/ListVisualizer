package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;

public class AnimatedList <T extends GraphicalObject & AnimableList<T>>{

    private final List<T> list=new List();
    private T lastInList;

    public AnimatedList(){ list.toFirst(); }

    public void addToList(String to,T newT){
        switch(to){
            case "List" -> {
                if(list.isEmpty()){
                    add(newT);
                    list.toFirst();
                    list.getContent().changePointer();
                }else {
                    T previous = lastInList;
                    add(newT);
                    previous.setNext(lastInList);
                }
            }
            case "current" -> {
                if(list.hasAccess()) {
                    newT.setNext(list.getContent());
                    newT.setX(newT.getNext().getX());
                    newT.setY(1000);
                    list.getContent().setPrevious(newT);
                    if (newT.getPrevious() != null) {
                        newT.getPrevious().setNext(newT);
                    }
                    list.insert(newT);
                }
            }
        }
    }

    public void deleteFromList(){
        if(!list.isEmpty()&& list.hasAccess()){
            if(list.getContent().tryToDelete()) list.remove();
        }
    }

    public void changeListPointer(String to){
        if(list.getContent()!=null)list.getContent().changePointer();
        switch (to){
            case "toFirst" -> list.toFirst();
            case "next" -> {
                if(list.hasAccess()) {
                    list.next();
                }else{
                    list.toFirst();
                }
            }
        }
        if(list.getContent()!=null) list.getContent().changePointer();
    }

    private void add(T newT) {
        list.append(newT);
        lastInList = newT;
    }

    public T getlast(){ return lastInList; }

    public List<T> getList(){ return list; }
}