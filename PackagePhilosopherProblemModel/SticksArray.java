package PackagePhilosopherProblemModel;

public class SticksArray
{
    //Constants
    private static final int NumberOfSticks = 5;

    //Components
    private Stick[] sticks;

    //Constructor
    public SticksArray()
    {
        sticks = new Stick[NumberOfSticks];

        for (int i = 0; i < sticks.length; i++)
        {
            sticks[i] = new Stick();
        }
    }

    public Stick getStick(int index)
    {
        return sticks[index];
    }
}
