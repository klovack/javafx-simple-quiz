package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Model;

public class OverviewPresenter
{
    private Model model;

    private OverviewView view;

    public OverviewPresenter()
    {
    }

    public OverviewView getView()
    {
        return this.view;
    }

    public void setView(OverviewView view)
    {
        this.view = view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void deleteHistory()
    {
        model.deleteHistory();
        showOverview();
    }

    public void showOverview()
    {
        view.showAllQuestions(model.getAllQuestions());
    }

}
