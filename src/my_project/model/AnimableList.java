package my_project.model;

import KAGO_framework.view.DrawTool;

public interface AnimableList<T> {

    public void draw(DrawTool drawTool);

    public void update(double dt);

    public void setPrevious(T newPrevious);
    public void setNext(T theNext);

    public void changePointer();

    public ListBall getPrevious();

    public boolean tryToDelete();

}
