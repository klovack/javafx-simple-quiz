package gui.mvp.quiz.model;

import java.util.ArrayList;

public class Model
{
    private int questionIndex;

    private ArrayList<Question> questions;

    public Model()
    {
        questionIndex = 0;
        questions = new ArrayList<Question>();
    }

    public void addQuestion(Question question)
    {
        questions.add(question);
    }

    public Question getFirstQuestion()
    {
        questionIndex = 0;
        if (questions != null)
        {
            return questions.get(0);
        }
        return null;
    }

    public Question getCurrentQuestion()
    {
        if (questionIndex >= questions.size())
        {
            return null;
        }
        return questions.get(questionIndex);
    }

    public ArrayList<Question> getAllQuestions()
    {
        return questions;
    }

    public void nextQuestion()
    {
        questionIndex++;
    }

    public void answerQuestion(int answerIndex)
    {
        questions.get(questionIndex).answerQuestion(answerIndex);
        nextQuestion();
    }

    public void deleteHistory()
    {
        for (Question question : questions)
        {
            question.reset();
        }
    }
}
