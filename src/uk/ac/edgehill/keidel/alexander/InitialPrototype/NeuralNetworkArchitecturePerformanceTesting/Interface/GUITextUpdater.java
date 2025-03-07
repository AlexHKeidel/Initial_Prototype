package uk.ac.edgehill.keidel.alexander.InitialPrototype.NeuralNetworkArchitecturePerformanceTesting.Interface;

import javafx.scene.control.TextArea;

/**
 * Created by Alexander Keidel, 22397868 on 18/02/2017.
 * This class was intended to be used by the different elements of the framework to update the main text area of the
 * main GUI. It was deemed unnecessary.
 */
public class GUITextUpdater implements Runnable {
    private final Thread observeThread;
    private TextArea parentTextArea;
    public GUITextUpdater(TextArea parentTextArea, Thread thread){
        this.parentTextArea = parentTextArea;
        observeThread = thread;
    }

    @Override
    public void run() {
        synchronized (observeThread){
            try {
                observeThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
