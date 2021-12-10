package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

public class ProgramController {

    private final ViewController viewController;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new InputReceiver(this,viewController);
    }


    public void mouseClicked(MouseEvent e){

    }

    public void update(double dt){

    }
}
