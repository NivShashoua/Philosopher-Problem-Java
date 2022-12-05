package PackagePhilosopherProblemModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhilosopherProblemModel implements IPhilosopherProblemModel
{
    //Constants
    private static final int NumberOfPhilosophers = 5;

    private  static final int Philosopher1Id = 0;
    private  static final int Philosopher2Id = 1;
    private  static final int Philosopher3Id = 2;
    private  static final int Philosopher4Id = 3;
    private  static final int Philosopher5Id = 4;

    private static final int Stick1 = 0;
    private static final int Stick2 = 1;
    private static final int Stick3 = 2;
    private static final int Stick4 = 3;
    private static final int Stick5 = 4;

    //Components
    private SticksArray sticks;
    private PhilosopherTable table;
    private Philosopher[] philosophers;

    //Constructor
    public PhilosopherProblemModel()
    {
        sticks = new SticksArray();
        table = new PhilosopherTable();

        //create all the philosophers
        philosophers = new Philosopher[NumberOfPhilosophers];
        philosophers[0] = new Philosopher(sticks, table, Stick1, Stick2, Philosopher1Id);
        philosophers[1] = new Philosopher(sticks, table, Stick2, Stick3, Philosopher2Id);
        philosophers[2] = new Philosopher(sticks, table, Stick3, Stick4, Philosopher3Id);
        philosophers[3] = new Philosopher(sticks, table, Stick4, Stick5, Philosopher4Id);
        //[the order of the stick in the last philosopher is important,
        //it protect from the program to freeze].
        philosophers[4] = new Philosopher(sticks, table, Stick1, Stick5, Philosopher5Id);
    }

    //the view use this function to update itself
    public PhilosopherState[] updateView() throws InterruptedException
    {
        return table.updateTheView();
    }

    public void activate()
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < philosophers.length; i++)
        {
            executorService.execute(philosophers[i]);
        }
        executorService.shutdown();
    }
}
