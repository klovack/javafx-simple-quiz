package gui.mvp.quiz.main;

import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.overview.OverviewPresenter;

public class MainPresenter
{
    private QuizPresenter quizPresenter;

    private OverviewPresenter overviewPresenter;

    private MainView mainView;

    public MainPresenter()
    {
    }

    public MainView getMainView()
    {
        return mainView;
    }

    public void setMainView(MainView mainView)
    {
        this.mainView = mainView;
    }

    public void setOverviewPresenter(OverviewPresenter overviewPresenter)
    {
        this.overviewPresenter = overviewPresenter;
    }

    public void setQuizPresenter(QuizPresenter quizPresenter)
    {
        this.quizPresenter = quizPresenter;
    }

    public void showOverview()
    {
        overviewPresenter.showOverview();
        mainView.setContent(overviewPresenter.getView());
    }

    public void startGame()
    {
        quizPresenter.startGame();
        mainView.setContent(quizPresenter.getView());
    }

    public void continueGame()
    {
        mainView.setContent(quizPresenter.getView());
    }

}
