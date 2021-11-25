package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.model.AnimatedList;
import my_project.model.ListBall;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

public class ProgramController {

    private final ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private List<ListBall> ballList;
    private ListBall lastBallInList;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new InputReceiver(this,viewController);
        ballList = new List<>();
        ballList.toFirst();
        lastBallInList = null;
        new AnimatedList<ListBall>(lastBallInList,viewController);
    }

    public void addBall(String to){
        switch(to){
            case "List" -> {
                if(ballList.isEmpty()){
                    addListBall();
                    ballList.toFirst();
                    ballList.getContent().changePointer();
                }else {
                    ListBall previous = lastBallInList;
                    addListBall();
                    previous.setNext(lastBallInList);
                }
            }
            case "current" -> {
                if(ballList.hasAccess()) {
                    ListBall newListBall = new ListBall(ballList.getContent().getX(), ballList.getContent().getPrevious(), viewController);
                    newListBall.setY(1000);
                    newListBall.setNext(ballList.getContent());
                    ballList.getContent().setPrevious(newListBall);
                    if (newListBall.getPrevious() != null) {
                        newListBall.getPrevious().setNext(newListBall);
                    }
                    ballList.insert(newListBall);
                }
            }
        }
    }

    private void addListBall() {
        ListBall newListBall = new ListBall(850,lastBallInList,viewController);
        ballList.append(newListBall);
        lastBallInList = newListBall;
    }

    public void deleteBall(){
        if(!ballList.isEmpty()&& ballList.hasAccess()){
            if(ballList.getContent().tryToDelete()) ballList.remove();
        }
    }

    public void setColor(String color){
        if(!ballList.isEmpty()&&ballList.hasAccess()) {
            switch (color) {
                case "r" -> ballList.getContent().setR();
                case "g" -> ballList.getContent().setG();
                case "b" -> ballList.getContent().setB();
            }
        }
    }

    public void changeListPointer(String to){
        if(ballList.getContent()!=null)ballList.getContent().changePointer();
        switch (to){
            case "toFirst" -> ballList.toFirst();
            case "next" -> {
                if(ballList.hasAccess()) {
                    ballList.next();
                }else{
                    ballList.toFirst();
                }
            }
        }
        if(ballList.getContent()!=null)ballList.getContent().changePointer();
    }

    public void mouseClicked(MouseEvent e){

    }

    public void update(double dt){

    }
}
