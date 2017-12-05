package gui.mvp.quiz.overview;

import java.util.ArrayList;

import gui.mvp.quiz.model.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class OverviewView extends VBox
{
    private OverviewPresenter presenter;

    private ListView<Question> questionList;

    public OverviewView()
    {
        initView();
    }

    private void initView()
    {
        // Put label
        getChildren().add(new Label("Übersicht"));

        // Put The list view and fill it with the questions
        questionList = new ListView<Question>();
        questionList.setId("overviewList");
        getChildren().add(questionList);

        // Put the button and set its function
        Button btnDeleteHistory = new Button("Ergebnisse löschen");
        btnDeleteHistory.setId("deleteHistory");
        btnDeleteHistory.setOnAction(e -> presenter.deleteHistory());
        getChildren().add(btnDeleteHistory);

        setSpacing(10);
    }

    public void setPresenter(OverviewPresenter presenter)
    {
        this.presenter = presenter;
    }

    public void showAllQuestions(ArrayList<Question> questions)
    {
        questionList.getItems().setAll(questions);
    }
}
