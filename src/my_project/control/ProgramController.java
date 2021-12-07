package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.AnimatedList;
import my_project.model.ListBall;
import my_project.model.ListCircle;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

public class ProgramController {

    private final ViewController viewController;
    private AnimatedList<ListCircle> list;
    private AnimatedList<ListBall> lisst;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new InputReceiver(this,viewController);
        list = new AnimatedList<>();
        lisst= new AnimatedList<>();
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

    public void adBall(String to){
        if (lisst.getlast() != null) {
            lisst.addToList(to, new ListBall(1000,lisst.getlast(), viewController));
        } else {
            lisst.addToList(to, new ListBall(1000,null, viewController));
            lisst.getList().toFirst();
        }
    }

    public void deletteBall(){
        lisst.deleteFromList();
    }

    public void changeLisstPointer(String to){
        lisst.changeListPointer(to);
    }

    public void mouseClicked(MouseEvent e){

    }

    public void update(double dt){

    }
}
