package gui.mvp.quiz;

import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.game.QuizView;
import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.main.MainView;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.overview.OverviewPresenter;
import gui.mvp.quiz.overview.OverviewView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        MainPresenter mainPresenter = initApplication();
        mainPresenter.startGame();
        Scene scene = new Scene(mainPresenter.getMainView(), 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz");
        primaryStage.show();
    }

    private MainPresenter initApplication() throws Exception
    {
        MainPresenter mainPresenter = new MainPresenter();
        OverviewPresenter overviewPresenter = new OverviewPresenter();
        QuizPresenter quizPresenter = new QuizPresenter();
        MainView mainView = new MainView();
        OverviewView overviewView = new OverviewView();
        QuizView quizView = new QuizView();
        Model model = ModelInitializer.initModel(getParameters().getRaw().get(0));

        mainPresenter.setMainView(mainView);
        mainPresenter.setOverviewPresenter(overviewPresenter);
        mainPresenter.setQuizPresenter(quizPresenter);
        mainView.setPresenter(mainPresenter);

        overviewPresenter.setModel(model);
        overviewPresenter.setView(overviewView);
        overviewView.setPresenter(overviewPresenter);

        quizPresenter.setModel(model);
        quizPresenter.setView(quizView);
        quizView.setPresenter(quizPresenter);

        return mainPresenter;
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
