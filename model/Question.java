package gui.mvp.quiz.model;

public class Question
{
    private String question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private int answerTries;

    private int correctAnswerTries;

    public Question(String question, String[] possibleAnswer, int indexOfCorrectAnswer)
    {
        this.question = question;
        this.possibleAnswers = possibleAnswer;
        if (indexOfCorrectAnswer < possibleAnswer.length)
        {
            if (indexOfCorrectAnswer < 0)
            {
                throw new IllegalArgumentException();
            }
            this.indexOfCorrectAnswer = indexOfCorrectAnswer;
        }
        else
        {
            throw new IllegalArgumentException();
        }
        this.answerTries = 0;
        this.correctAnswerTries = 0;
    }

    public String getQuestion()
    {
        return question;
    }

    public String[] getPossibleAnswers()
    {
        return possibleAnswers;
    }

    public int getIndexOfCorrectAnswer()
    {
        return indexOfCorrectAnswer;
    }

    public int getAnswerTries()
    {
        return answerTries;
    }

    public int getcorrectAnswerTries()
    {
        return correctAnswerTries;
    }

    private void addAnswerTries(boolean isAnswerCorrect)
    {
        answerTries++;
        if (isAnswerCorrect)
        {
            correctAnswerTries++;
        }
    }

    public void reset()
    {
        answerTries = 0;
        correctAnswerTries = 0;
    }

    public void answerQuestion(int answerIndex)
    {
        boolean isCorrect = indexOfCorrectAnswer == answerIndex;
        if (answerIndex < 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            addAnswerTries(isCorrect);
        }
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer(question + "? ");

        sb.append("(Antworten: " + answerTries + ", davon richtig: " + correctAnswerTries + ")");

        return sb.toString();
    }

}
