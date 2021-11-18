package my_project.model;

import KAGO_framework.control.ViewController;

public class ArrayBall extends Ball{

    public ArrayBall(double x, double y, ViewController viewController){
        this.x=x;
        this.y=y;
        radius=20;
        viewController.draw(this);
    }


}
