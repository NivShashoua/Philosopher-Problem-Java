package PackagePhilosopherProblemModel;

public interface IPhilosopherProblemModel
{
    PhilosopherState[] updateView() throws InterruptedException;

    void activate();
}
