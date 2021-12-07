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

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputReceiver(ProgramController programController, ViewController viewController){
        this.programController = programController;
        viewController.register(this);
    }

    @Override
    public void keyPressed(int key) {
    }

    @Override
    public void keyReleased(int key) {
        switch (key){
            case KeyEvent.VK_A -> programController.addBall("List");
            case KeyEvent.VK_S -> programController.deleteBall();
            case KeyEvent.VK_Q -> programController.changeListPointer("toFirst");
            case KeyEvent.VK_E -> programController.changeListPointer("next");
            case KeyEvent.VK_W -> programController.addBall("current");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
}
