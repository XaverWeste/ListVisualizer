package my_project.model;

import KAGO_framework.control.ViewController;

/**
 * Repräsentiert eine Kugel (einen Kreis), der in eine Schlange eingefügt werden soll. Dabei muss jeder QueueBall immer
 * seinen Vorgänger kennen, damit er zu ihm Abstand halten kann.
 */
public class QueueBall extends Ball {

    protected QueueBall previousQueueBall;
    public QueueBall(QueueBall previousQueueBall){
        super(x,y,);
        this.previousQueueBall
    }

    /**
     * Wird mit jeder Frame vom Framework aufgerufen und dient zur Manipulation des Objekts im Verlauf
     * der Zeit.
     * @param dt die Sekunden, die seit dem letzten Aufruf von update vergangen sind
     */
    @Override
    public void update(double dt){
        if(!arrived){
            if(previousQueueBall == null || x > previousQueueBall.getX()+50) x -= 100*dt;
            if (x < 100) arrived = true;
        }
        if(deleted){
            x -= 200*dt;
            if(x < -25) viewController.removeDrawable(this);
        }
    }


}