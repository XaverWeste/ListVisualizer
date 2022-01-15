package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.AnimatedList;
import my_project.model.ListAnimation;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

public class ProgramController {

    private final ViewController viewController;
    private final AnimatedList<ListAnimation> list=new AnimatedList<>(25,0,100,100);

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new InputReceiver(this,viewController);
    }

    public AnimatedList<ListAnimation> getList(){ return list; }

    public void mouseClicked(MouseEvent e){

    }

    public void update(double dt){

    }
}
