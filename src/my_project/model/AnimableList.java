package my_project.model;

import KAGO_framework.view.DrawTool;

public interface AnimableList<T> {

    void draw(DrawTool drawTool);

    void update(double dt);

    void setPrevious(T newPrevious);

    void setNext(T theNext);

    void changePointer();

    T getPrevious();

    T getNext();

    boolean tryToDelete();

}
