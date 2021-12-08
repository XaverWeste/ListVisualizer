package my_project.model;

import KAGO_framework.model.GraphicalObject;

public class ListObject extends GraphicalObject {

    protected boolean isOnPointer=false;
    protected boolean arrived=false;
    protected boolean deleted=false;
    protected ListCircle previous;
    protected ListCircle next=null;

    public void changePointer(){ isOnPointer=!isOnPointer; }

    public void changePointer(boolean to){ isOnPointer=to; }

    public boolean isArrived() {
        return arrived;
    }

    public void setArrived(boolean arrived) {
        this.arrived = arrived;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * muss in der unterklasse mit super aufgerufen werden
     */
    public void update(double dt){
        if(!arrived) spawnAnimation(dt);
        if(deleted) deleteAnimation(dt);
    }

    public void spawnAnimation(double dt){

    }

    public void deleteAnimation(double dt){

    }
}
