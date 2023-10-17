package Projects.CodeSoftInternship;

import java.util.Timer;
import java.util.TimerTask;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctAnswer;

    public QuizQuestion(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

public class Task4 {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;

    public Task4() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        score = 0;
        timer = new Timer();

        questions.add(new QuizQuestion("What is the capital of France?",
                new String[]{"1) London", "2) Berlin", "3) Paris", "4) Madrid"}, 3));
        questions.add(new QuizQuestion("What is 2 + 2?",
                new String[]{"1) 3", "2) 4", "3) 5", "4) 6"}, 2));

        startQuiz();
    }

    public void startQuiz() {
        if (currentQuestionIndex < questions.size()) {
            QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());
            String[] options = currentQuestion.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            int timeLimit = 10;
            startTimer(timeLimit);
        } else {
            endQuiz();
        }
    }

    public void startTimer(int seconds) {
        Timer questionTimer = new Timer();
        questionTimer.schedule(new TimerTask() {
            public void run() {
                System.out.println("Time's up!");
                questionTimer.cancel();
                nextQuestion();
            }
        }, seconds * 1000);
    }
    

    public void stopTimer() {
        timer.cancel();
    }

    public void nextQuestion() {
        stopTimer();
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            startQuiz();
        } else {
            endQuiz();
        }
    }

    public void submitAnswer(int userAnswer) {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        if (currentQuestion.isCorrect(userAnswer)) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect.");
        }
        nextQuestion();
    }

    public void endQuiz() {
        System.out.println("Quiz Ended!");
        System.out.println("Your Score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        Task4 quizApp = new Task4();
        Scanner scanner = new Scanner(System.in);

        while (quizApp.currentQuestionIndex < quizApp.questions.size()) {
            String userInput = scanner.nextLine();
            try {
                int userAnswer = Integer.parseInt(userInput);
                quizApp.submitAnswer(userAnswer);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option (1, 2, 3, 4, ...).");
            }
        }

        scanner.close();
    }
}
