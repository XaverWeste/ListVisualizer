package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.AnimatedList;
import my_project.model.ListBall;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

public class ProgramController {

    private final ViewController viewController;
    private AnimatedList<ListBall> listBall;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new InputReceiver(this,viewController);
        listBall = new AnimatedList<>(viewController);
    }

    public void addBall(String to){
        if(listBall.getList().getContent()!=null) {
            listBall.addToList(to, new ListBall(850, listBall.getList().getContent().getPrevious(), viewController));
        }else{
            listBall.addToList(to, new ListBall(850,null, viewController));
        }
    }

    public void deleteBall(){
        listBall.deleteFromList();
    }

    public void setColor(String color){
        if(!listBall.getList().isEmpty()&&listBall.getList().hasAccess()) {
            switch (color) {
                case "r" -> listBall.getList().getContent().setR();
                case "g" -> listBall.getList().getContent().setG();
                case "b" -> listBall.getList().getContent().setB();
            }
        }
    }

    public void changeListPointer(String to){
        listBall.changeListPointer(to);
    }

    public void mouseClicked(MouseEvent e){

    }

    public void update(double dt){

    }
}
