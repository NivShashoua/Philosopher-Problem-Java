package PackagePhilosopherProblemView;

import PackagePhilosopherProblemModel.PhilosopherState;

import javax.swing.*;

public class PhilosopherView extends JPanel
{
    //Components
    private ImageIcon philosopherThinking;
    private ImageIcon philosopherEating;
    private JLabel label;


    //Constructor
    public PhilosopherView()
    {
        String theProjectPath = System.getProperty("user.dir") + "\\src"; //the path of this specific project
        //image of the thinking Philosopher
        philosopherThinking = new ImageIcon(theProjectPath + "\\philosopherThinking.png");
        //image of the eating Philosopher
        philosopherEating = new ImageIcon(theProjectPath+ "\\philosopherEating.png");

        label = new JLabel(philosopherThinking);
        add(label);
    }

    //change the image of the philosopher
    public void changeState(PhilosopherState newState)
    {
        if(newState == PhilosopherState.THINKING)
        {
            label.setIcon(philosopherThinking);
        }
        else if(newState == PhilosopherState.EATING)
        {
            label.setIcon(philosopherEating);
        }
    }

}
