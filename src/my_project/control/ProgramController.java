package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.model.ListBall;
import my_project.model.QueueBall;
import my_project.model.StackBall;
import my_project.view.InputReceiver;

import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private final ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Queue<QueueBall> ballQueue;
    private QueueBall lastBallinQueue;
    private Stack<StackBall> ballStack;
    private List<ListBall> ballList;
    private ListBall lastBallInList;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        // Für Benutzerinteraktion
        new InputReceiver(this,viewController); // darf anonym sein, weil kein Zugriff nötig ist
        // Für die Queue:
        ballQueue = new Queue<>();
        lastBallinQueue = null; // die letzte Kugel muss für die Animation gemerkt werden
        ballStack = new Stack<>();
        ballList = new List<>();
        ballList.toFirst();
        lastBallInList = null;
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
                QueueBall newQueueBall = new QueueBall(850, 50, lastBallinQueue, viewController);
                ballQueue.enqueue(newQueueBall);
                lastBallinQueue = newQueueBall;
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
                ListBall newListBall = new ListBall(ballList.getContent().getPrevious(),viewController);
                newListBall.setNext(ballList.getContent());
                ballList.getContent().setPrevious(newListBall);
                newListBall.getPrevious().setNext(newListBall);
                ballList.insert(newListBall);
                newListBall.setColorBlack();
            }
        }
    }

    private void addListBall() {
        ListBall newListBall = new ListBall(lastBallInList,viewController);
        ballList.append(newListBall);
        lastBallInList = newListBall;
    }

    private void addStackBall() {
        StackBall newStackBall = new StackBall( -50, ballStack.top(), viewController);
        ballStack.push(newStackBall);
    }

    public void changeFilled(){
        if(!ballStack.isEmpty())
            ballStack.top().changeFilled();
    }

    public void deleteBall(String from){
        switch (from){
            case "Stack" -> {
                if(!ballStack.isEmpty()){
                    StackBall newTop = ballStack.top();
                    if(ballStack.top().tryToDelete()) ballStack.pop();
                }
            }
            case "Queue" -> {
                if(!ballQueue.isEmpty()){
                    if(ballQueue.front().tryToDelete()) ballQueue.dequeue();
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
                case "r" -> {
                    ballList.getContent().setR();
                }
                case "g" -> {
                    ballList.getContent().setG();
                }
                case "b" -> {
                    ballList.getContent().setB();
                }
            }
        }
    }

    public void changeListPointer(String to){
        if(ballList.getContent()!=null)ballList.getContent().changePointer();
        switch (to){
            case "toFirst" -> {
                ballList.toFirst();
            }
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

    /**
     * Aufruf bei Mausklick
     * @param e das Objekt enthält alle Informationen zum Klick
     */
    public void mouseClicked(MouseEvent e){

    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }
}
