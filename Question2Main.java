import PackagePhilosopherProblemController.IPhilosopherProblemController;
import PackagePhilosopherProblemController.PhilosopherProblemController;
import PackagePhilosopherProblemModel.IPhilosopherProblemModel;
import PackagePhilosopherProblemModel.PhilosopherProblemModel;
import PackagePhilosopherProblemView.IPhilosopherProblemView;
import PackagePhilosopherProblemView.PhilosopherProblemView;

public class Question2Main
{
    public static void main(String[] args)
    {
        IPhilosopherProblemModel model = new PhilosopherProblemModel();
        IPhilosopherProblemView view = new PhilosopherProblemView(model);
        IPhilosopherProblemController controller = new PhilosopherProblemController(model, view);
        controller.activate();
    }
}
