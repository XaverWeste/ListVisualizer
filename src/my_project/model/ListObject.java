package my_project.model;

import KAGO_framework.model.GraphicalObject;

public class ListObject extends GraphicalObject {

    protected boolean isOnPointer=false;
    protected boolean arrived=false;
    protected boolean deleted=false;
    protected ListCircle previous;
    protected ListCircle next=null;

    public void changePointer(){ isOnPointer=!isOnPointer; }

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
}
