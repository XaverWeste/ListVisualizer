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
        if(e.getX()>300&&e.getY()>200){
            if (e.getButton() == MouseEvent.BUTTON1) {
                programController.changeArrayBall((e.getX()-300)/50,(e.getY()-200)/50);
            }else if(e.getButton() == MouseEvent.BUTTON3){
                programController.changeColor((e.getX()-300)/50,(e.getY()-200)/50);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
