package my_project.view;

import KAGO_framework.control.Interactable;
import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputReceiver implements Interactable {

    private final ProgramController programController;
    private ViewController viewController;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputReceiver(ProgramController programController, ViewController viewController){
        this.programController = programController;
        this.viewController = viewController;
        viewController.register(this);
    }

    @Override
    public void keyPressed(int key) {
    }

    @Override
    public void keyReleased(int key) {
        switch (key){
            case KeyEvent.VK_DOWN -> {
                programController.addBall("Stack");
            }
            case KeyEvent.VK_UP -> {
                programController.deleteBall("Stack");
            }
            case KeyEvent.VK_SPACE -> {
                programController.changeFilled();
            }
            case KeyEvent.VK_A -> {
                programController.addBall("List");
            }
            case KeyEvent.VK_S -> {
                programController.deleteBall("List");
            }
            case KeyEvent.VK_R -> {
                programController.setColor("r");
            }
            case KeyEvent.VK_G -> {
                programController.setColor("g");
            }
            case KeyEvent.VK_B -> {
                programController.setColor("b");
            }
            case KeyEvent.VK_Q -> {
                programController.changeListPointer("toFirst");
            }
            case KeyEvent.VK_E -> {
                programController.changeListPointer("next");
            }
            case KeyEvent.VK_W -> {
                programController.addBall("current");
            }
            case KeyEvent.VK_Y -> {
                programController.addBall("Queue");
            }
            case KeyEvent.VK_X -> {
                programController.deleteBall("Queue");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {/*
        double x=e.getX();
        double y=e.getY();
        if(x>300 && x<500 && y>200 && y<600 ){
            if(x<350){
                if(y<250){
                    programController.addArrayBall(0,0);
                }else if(y<300){
                    programController.addArrayBall(0,1);
                }else if(y<350){
                    programController.addArrayBall(0,2);
                }else if(y<400){
                    programController.addArrayBall(0,3);
                }else if(y<450){
                    programController.addArrayBall(0,4);
                }else if(y<500){
                    programController.addArrayBall(0,5);
                }else if(y<550){
                    programController.addArrayBall(0,6);
                }else{
                    programController.addArrayBall(0,7);
                }
            }else if(x<400){
                if(y<250){
                    programController.addArrayBall(1,0);
                }else if(y<300){
                    programController.addArrayBall(1,1);
                }else if(y<350){
                    programController.addArrayBall(1,2);
                }else if(y<400){
                    programController.addArrayBall(1,3);
                }else if(y<450){
                    programController.addArrayBall(1,4);
                }else if(y<500){
                    programController.addArrayBall(1,5);
                }else if(y<550){
                    programController.addArrayBall(1,6);
                }else{
                    programController.addArrayBall(1,7);
                }
            }else if(x<450){
                if(y<250){
                    programController.addArrayBall(2,0);
                }else if(y<300){
                    programController.addArrayBall(2,1);
                }else if(y<350){
                    programController.addArrayBall(2,2);
                }else if(y<400){
                    programController.addArrayBall(2,3);
                }else if(y<450){
                    programController.addArrayBall(2,4);
                }else if(y<500){
                    programController.addArrayBall(2,5);
                }else if(y<550){
                    programController.addArrayBall(2,6);
                }else{
                    programController.addArrayBall(2,7);
                }
            }else{
                if(y<250){
                    programController.addArrayBall(3,0);
                }else if(y<300){
                    programController.addArrayBall(3,1);
                }else if(y<350){
                    programController.addArrayBall(3,2);
                }else if(y<400){
                    programController.addArrayBall(3,3);
                }else if(y<450){
                    programController.addArrayBall(3,4);
                }else if(y<500){
                    programController.addArrayBall(3,5);
                }else if(y<550){
                    programController.addArrayBall(3,6);
                }else{
                    programController.addArrayBall(3,7);
                }
            }
        }*/
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    public void update(double dt){

    }
}
