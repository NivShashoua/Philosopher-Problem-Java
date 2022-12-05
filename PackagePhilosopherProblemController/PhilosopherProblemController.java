package PackagePhilosopherProblemController;

import PackagePhilosopherProblemModel.IPhilosopherProblemModel;
import PackagePhilosopherProblemView.IPhilosopherProblemView;


public class PhilosopherProblemController implements IPhilosopherProblemController
{
    //Components
    private IPhilosopherProblemModel model;
    private IPhilosopherProblemView view;

    //Constructor
    public PhilosopherProblemController(IPhilosopherProblemModel model, IPhilosopherProblemView view)
    {
        this.model = model;
        this.view = view;
    }

    public void activate()
    {
        model.activate();

        while (true)
        {
            view.updateView();
        }
    }

}
