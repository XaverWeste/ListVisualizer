package my_project.model;

import KAGO_framework.control.ViewController;

public class ArrayBall extends Ball{

    public ArrayBall(double x, double y, ViewController viewController){
        this.x=x;
        this.y=y;
        this.viewController=viewController;
        radius=20;
        viewController.draw(this);
    }

    @Override
    public boolean tryToDelete(){
        deleted = true;
        return deleted;
    }

    public void update(double dt){
        if(deleted) viewController.removeDrawable(this);
    }

}
