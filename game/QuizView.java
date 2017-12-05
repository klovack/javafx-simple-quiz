package gui.mvp.quiz.game;

import java.util.ArrayList;

import gui.mvp.quiz.model.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * @author rizkifikri
 *
 */
public class QuizView extends VBox
{
    private QuizPresenter presenter;

    private Label questionLabel;

    private ToggleGroup answers;

    private ArrayList<RadioButton> possibleAnswers;

    private Button btnNext;

    public QuizView()
    {
        initView();
    }

    private void initView()
    {
        // Initialize all the attributes
        questionLabel = new Label();
        questionLabel.setId("question");
        answers = new ToggleGroup();
        possibleAnswers = new ArrayList<RadioButton>();
        btnNext = new Button("=>");

        // Set the button onAction
        btnNext.setOnAction(e -> answerQuestion());

        getChildren().add(0, questionLabel);
        getChildren().add(btnNext);
        setSpacing(10);
    }

    private void answerQuestion()
    {
        // check if the user has given the answer
        if (answers.getSelectedToggle() == null)
        {
            // if he hasn't, move to the next question
            presenter.nextQuestion();
        }
        else
        {
            // if he has, answer the question
            for (RadioButton choice : possibleAnswers)
            {
                if (choice.isSelected())
                {
                    presenter.answerQuestion(possibleAnswers.indexOf(choice));
                    break;
                }
            }
        }
    }

    private void reset()
    {
        possibleAnswers.clear();

        if (getChildren().size() > 2)
        {
            getChildren().remove(1, getChildren().size() - 1);
        }

        btnNext.setDisable(false);
    }

    public void showQuestion(Question question)
    {
        reset();

        if (question != null)
        {
            questionLabel.setText(question.getQuestion());
            for (int i = 0; i < question.getPossibleAnswers().length; i++)
            {
                RadioButton possibleAnswer = new RadioButton(question.getPossibleAnswers()[i]);
                possibleAnswers.add(i, possibleAnswer);
                possibleAnswer.setToggleGroup(answers);

                getChildren().add(i + 1, possibleAnswer);
            }
        }
        else
        {
            questionLabel.setText("Ende des Quiz");
            btnNext.setDisable(true);
        }
    }

    public void setPresenter(QuizPresenter presenter)
    {
        this.presenter = presenter;
    }

}
