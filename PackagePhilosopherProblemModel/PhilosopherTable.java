package PackagePhilosopherProblemModel;

public class PhilosopherTable
{
    //Constants
    private static final int NumberOfPhilosophers = 5;
    private static final boolean NewUpdate = true;
    private static final boolean NoUpdate = false;

    //Components
    private PhilosopherState philosophersStates[]; //the state of philosopher 1 in the table

    //flag to indicate that one of the philosopher update their state, and now the view need to update itself
    private boolean update;

    //Constructor
    public PhilosopherTable()
    {
        philosophersStates = new PhilosopherState[NumberOfPhilosophers];
        for (int i = 0; i < NumberOfPhilosophers; i++)
        {
            philosophersStates[i] = PhilosopherState.THINKING;
        }
        update = NoUpdate;
    }

    //one of the philosopher change his state
    public synchronized void changePhilosopherState(PhilosopherState philosopherState, int index)
            throws InterruptedException
    {
        //if there was an update by one of the philosopher, stop the other from updating
        while (update == NewUpdate)
        {
           wait();
        }

        philosophersStates[index] = philosopherState;
        update = NewUpdate;
        notifyAll();
    }

    //update the view of the user about the philosophers table states
    public synchronized PhilosopherState[] updateTheView() throws InterruptedException
    {
        //if the was no update than don't change the view
        while (update == NoUpdate)
        {
            wait();
        }

        try
        {
            update = NoUpdate;
            return philosophersStates;
        }
        finally
        {
            notifyAll();
        }


    }

}
