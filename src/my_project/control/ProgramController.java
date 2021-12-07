package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.AnimatedList;
import my_project.model.ListCircle;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

public class ProgramController {

    private final ViewController viewController;
    private AnimatedList<ListCircle> list;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new InputReceiver(this,viewController);
        list = new AnimatedList<>();
    }

    public void addBall(String to){
        if (list.getlast() != null) {
            list.addToList(to, new ListCircle(list.getlast(), viewController));
        } else {
            list.addToList(to, new ListCircle(null, viewController));
            list.getList().toFirst();
        }
    }

    public void deleteBall(){
        list.deleteFromList();
    }

    public void changeListPointer(String to){
        list.changeListPointer(to);
    }

    public void mouseClicked(MouseEvent e){

    }

    public void update(double dt){

    }
}
