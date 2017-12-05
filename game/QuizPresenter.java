package gui.mvp.quiz.game;

import gui.mvp.quiz.model.Model;

public class QuizPresenter
{
    private Model model;

    private QuizView view;

    public QuizPresenter()
    {
    }

    public QuizView getView()
    {
        return this.view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void setView(QuizView view)
    {
        this.view = view;
    }

    public void startGame()
    {
        view.showQuestion(model.getFirstQuestion());
    }

    public void continueGame()
    {
        view.showQuestion(model.getCurrentQuestion());
    }

    public void nextQuestion()
    {
        model.nextQuestion();
        continueGame();
    }

    public void answerQuestion(int answerIndex)
    {
        model.answerQuestion(answerIndex);
        continueGame();
    }
}
