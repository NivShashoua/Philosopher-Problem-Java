package PackagePhilosopherProblemModel;

import java.security.SecureRandom;

public class Philosopher extends Thread
{
    //Components
    private static final SecureRandom generator = new SecureRandom();

    private SticksArray sticks;
    private int indexStick1;    //the first chopstick the philosopher can use
    private int indexStick2;    //the second chopstick the philosopher can use
    private PhilosopherTable table; //the table save all the philosopher current statues
    private int id;             //the philosopher id number(the index in the array in the model class)

    //Constructor
    public Philosopher(SticksArray sticks, PhilosopherTable table,
                       int IndexStick1, int IndexStick2, int id)
    {
        super("Philosopher" + id);
        this.sticks = sticks;
        this.indexStick1 = IndexStick1;
        this.indexStick2 = IndexStick2;
        this.table = table;
        this.id = id;
    }

    @Override
    public void run()
    {
        while(true) {
            //try to catch stick 1
            try
            {
                sticks.getStick(indexStick1).tryToUseStick();
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }

            //try to catch stick 2
            try
            {
                sticks.getStick(indexStick2).tryToUseStick();
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }

            ///////////////////////
            //philosopher eating//
            try
            {
                table.changePhilosopherState(PhilosopherState.EATING, id);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            try
            {
                sleep(generator.nextInt(10000)); //eating random time between 0 to 10 seconds
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }

            ////////////////////////
            //put back the sticks//
            sticks.getStick(indexStick1).putBackStick(); //put back stick1
            sticks.getStick(indexStick2).putBackStick(); //put back stick2

            /////////////////////////
            //philosopher thinking//
            try
            {
                table.changePhilosopherState(PhilosopherState.THINKING, id);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            try
            {
                sleep(generator.nextInt(10000)); //eating random time between 0 to 10 seconds
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }

        }

    }


}
