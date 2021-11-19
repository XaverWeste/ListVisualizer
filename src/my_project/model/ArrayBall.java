package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;

public class ArrayBall extends Ball{

    private int r=255;
    private int g=255;
    private int b=255;

    public ArrayBall(double x, double y, ViewController viewController){
        this.x=x;
        this.y=y;
        this.viewController=viewController;
        radius=0;
        viewController.draw(this);
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledCircle(x,y,radius);
        super.draw(drawTool);
    }

    public void changeColor(){
        r=(int)(Math.random()*255);
        g=(int)(Math.random()*255);
        b=(int)(Math.random()*255);
    }

    public void clearColor(){ r=g=b=255; }

    @Override
    public boolean tryToDelete(){ return deleted=true; }

    public void update(double dt){
        if(radius<20) radius+=20*dt;
        if(deleted){
            viewController.removeDrawable(this);
        }
    }

}
