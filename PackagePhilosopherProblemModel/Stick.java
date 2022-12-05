package PackagePhilosopherProblemModel;

public class Stick
{
    //Constants
    private static final boolean Used = true;
    private static final boolean NotUsed = false;

    //Components
    boolean stickIsUsed;

    //Constructor
    public Stick()
    {
        stickIsUsed = NotUsed;
    }

    //philosopher try to catch the stick
    public synchronized void tryToUseStick() throws InterruptedException
    {
        //if the stick is used, wait
        while (stickIsUsed == Used)
        {
            wait();
        }

        //if the stick is not used, use it
        stickIsUsed = Used;
    }

    //the philosopher put the stick back, and notify it
    public synchronized void putBackStick()
    {
        stickIsUsed = NotUsed;
        notifyAll();
    }
}
