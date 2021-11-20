package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.model.ListBall;
import my_project.model.QueueTriangle;
import my_project.model.StackRectangle;
import my_project.model.TwoDimesionalArray;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

public class ProgramController {

    private final ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Queue<QueueTriangle> triangleQueue;
    private QueueTriangle lastTriangleinQueue;
    private Stack<StackRectangle> ballStack;
    private List<ListBall> ballList;
    private ListBall lastBallInList;
    private TwoDimesionalArray array;

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        new InputReceiver(this,viewController);
        triangleQueue = new Queue<>();
        lastTriangleinQueue = null;
        ballStack = new Stack<>();
        ballList = new List<>();
        ballList.toFirst();
        lastBallInList = null;
        array = new TwoDimesionalArray(viewController);
    }

    public void addBall(String to){
        switch (to){
            case "Stack" -> {
                if(!ballStack.isEmpty()&&ballStack.top().getY()>100) {
                    addStackBall();
                }else if(ballStack.isEmpty()){
                    addStackBall();
                }
            }
            case "Queue" -> {
                QueueTriangle newQueueBall = new QueueTriangle(850, 50, lastTriangleinQueue, viewController);
                triangleQueue.enqueue(newQueueBall);
                lastTriangleinQueue = newQueueBall;
            }
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
                ListBall newListBall = new ListBall(ballList.getContent().getX(),ballList.getContent().getPrevious(),viewController);
                newListBall.setY(1000);
                newListBall.setNext(ballList.getContent());
                ballList.getContent().setPrevious(newListBall);
                newListBall.getPrevious().setNext(newListBall);
                ballList.insert(newListBall);
            }
        }
    }

    public void changeArrayBall(int x, int y){
        array.changeBall(x,y);
    }

    private void addListBall() {
        ListBall newListBall = new ListBall(850,lastBallInList,viewController);
        ballList.append(newListBall);
        lastBallInList = newListBall;
    }

    private void addStackBall() {
        StackRectangle newStackRectangle = new StackRectangle( -50, ballStack.top(), viewController);
        ballStack.push(newStackRectangle);
    }

    public void changeFilled(){
        if(!ballStack.isEmpty())
            ballStack.top().changeFilled();
    }

    public void changeColor(int x,int y){ array.changeColor(x,y); }
    public void clearColor(int x,int y){ array.clearColor(x,y); }

    public void deleteBall(String from){
        switch (from){
            case "Stack" -> {
                if(!ballStack.isEmpty()){
                    if(ballStack.top().tryToDelete()) ballStack.pop();
                }
            }
            case "Queue" -> {
                if(!triangleQueue.isEmpty()){
                    if(triangleQueue.front().tryToDelete()) triangleQueue.dequeue();
                }
            }
            case "List" -> {
                if(!ballList.isEmpty()&& ballList.hasAccess()){
                    if(ballList.getContent().tryToDelete()) ballList.remove();
                }
            }
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
