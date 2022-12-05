package PackagePhilosopherProblemView;

import PackagePhilosopherProblemModel.IPhilosopherProblemModel;
import PackagePhilosopherProblemModel.PhilosopherState;

import javax.swing.*;

public class PhilosopherProblemView extends JFrame implements IPhilosopherProblemView
{
    //Constants
    private static final int NumberOfPhilosophers = 5;

    private static final int FrameSize = 600;
    private static final int PhilosopherImageWidth = 100;
    private static final int PhilosopherImageHeight = 180;

    private static final int Philosopher1_X_Location = 400;
    private static final int Philosopher1_Y_Location = 250;

    private static final int Philosopher2_X_Location = 375;
    private static final int Philosopher2_Y_Location = 50;

    private static final int Philosopher3_X_Location = 125;
    private static final int Philosopher3_Y_Location = 50;

    private static final int Philosopher4_X_Location = 100;
    private static final int Philosopher4_Y_Location = 250;

    private static final int Philosopher5_X_Location = 250;
    private static final int Philosopher5_Y_Location = 375;

    //Components
    private IPhilosopherProblemModel model;

    PhilosopherView philosopher1;
    PhilosopherView philosopher2;
    PhilosopherView philosopher3;
    PhilosopherView philosopher4;
    PhilosopherView philosopher5;


    //Constructor
    public PhilosopherProblemView(IPhilosopherProblemModel modelInput)
    {
        model = modelInput;
        philosopher1 = new PhilosopherView();
        philosopher2 = new PhilosopherView();
        philosopher3 = new PhilosopherView();
        philosopher4 = new PhilosopherView();
        philosopher5 = new PhilosopherView();

        setLayout(null);
        philosopher1.setBounds(Philosopher1_X_Location, Philosopher1_Y_Location,
                PhilosopherImageWidth, PhilosopherImageHeight);
        philosopher2.setBounds(Philosopher2_X_Location, Philosopher2_Y_Location,
                PhilosopherImageWidth, PhilosopherImageHeight);
        philosopher3.setBounds(Philosopher3_X_Location, Philosopher3_Y_Location,
                PhilosopherImageWidth, PhilosopherImageHeight);
        philosopher4.setBounds(Philosopher4_X_Location, Philosopher4_Y_Location,
                PhilosopherImageWidth, PhilosopherImageHeight);
        philosopher5.setBounds(Philosopher5_X_Location, Philosopher5_Y_Location,
                PhilosopherImageWidth, PhilosopherImageHeight);
        add(philosopher1);
        add(philosopher2);
        add(philosopher3);
        add(philosopher4);
        add(philosopher5);

        setSize(FrameSize, FrameSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void updateView()
    {
        PhilosopherState[] philosophersStates;
        try
        {
            philosophersStates = model.updateView();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            return;
        }

        philosopher1.changeState(philosophersStates[0]);
        philosopher2.changeState(philosophersStates[1]);
        philosopher3.changeState(philosophersStates[2]);
        philosopher4.changeState(philosophersStates[3]);
        philosopher5.changeState(philosophersStates[4]);
    }

}
