package gui.mvp.quiz.main;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MainView extends BorderPane
{
    private MainPresenter presenter;

    public MainView()
    {
        initView();
    }

    private void initView()
    {
        HBox menuBar = new HBox();
        Button btnStart = new Button("Quiz starten!");
        Button btnContinue = new Button("Quiz fortsetzen!");
        Button btnOverview = new Button("Überblick!");

        btnOverview.setId("overview");

        menuBar.getChildren().addAll(btnStart, btnContinue, btnOverview);

        setTop(menuBar);
        menuBar.setSpacing(10);
        menuBar.setPadding(new Insets(0, 0, 10, 0));

        setPadding(new Insets(10));

        btnStart.setOnAction(e -> presenter.startGame());
        btnContinue.setOnAction(e -> presenter.continueGame());
        btnOverview.setOnAction(e -> presenter.showOverview());
    }

    public void setContent(Pane content)
    {
        setCenter(content);
    }

    public void setPresenter(MainPresenter presenter)
    {
        this.presenter = presenter;
    }
}
