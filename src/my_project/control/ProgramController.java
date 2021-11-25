package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.AnimatedList;
import my_project.model.ListBall;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

public class ProgramController {

    private final ViewController viewController;
    private AnimatedList<ListBall> list;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new InputReceiver(this,viewController);
        list = new AnimatedList<>();
    }

    public void addBall(String to){
        if(list.getList().getContent()!=null) {
            list.addToList(to, new ListBall(850, list.getList().getContent().getPrevious(), viewController));
        }else{
            list.addToList(to, new ListBall(850,null, viewController));
        }
    }

    public void deleteBall(){
        list.deleteFromList();
    }

    public void setColor(String color){
        if(!list.getList().isEmpty()&&list.getList().hasAccess()) {
            switch (color) {
                case "r" -> list.getList().getContent().setR();
                case "g" -> list.getList().getContent().setG();
                case "b" -> list.getList().getContent().setB();
            }
        }
    }

    public void changeListPointer(String to){
        list.changeListPointer(to);
    }

    public void mouseClicked(MouseEvent e){

    }

    public void update(double dt){

    }
}
