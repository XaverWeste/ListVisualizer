package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;

public class AnimatedList <T extends ListObject & AnimableList<T>> extends GraphicalObject {

    private final List<T> list=new List();
    private T lastInList;
    private final SoundController soundController=new SoundController();

    public AnimatedList(){
        list.toFirst();
    }

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
        if(list.hasAccess()){
            if(list.getContent().tryToDelete()){
                if(list.getContent().next!=null&&list.getContent().previous!=null) {
                    list.getContent().next.setPrevious(list.getContent().previous);
                    list.getContent().previous.setNext(list.getContent().next);
                    list.getContent().next.changePointer(true);
                }else if(list.getContent().next!=null){
                    list.getContent().next.setPrevious(null);
                    list.getContent().next.changePointer(true);
                }else if(list.getContent().previous!=null){
                    list.getContent().previous.setNext(null);
                }
                list.getContent().changePointer(false);
                list.getContent().deleted=true;
                list.remove();
            }
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

    public void update(double dt){
        T current=list.getContent();
        while(list.getContent()!=current){
            T t=list.getContent();
            if(t.deleted) t.deleteAnimation(dt);
            if(!t.arrived) t.spawnAnimation(dt);
            t.sounds(soundController);
            if(list.getContent()!=current) {
                if (list.getContent().next != null) {
                    list.next();
                } else {
                    list.toFirst();
                }
            }
        }
    }
}