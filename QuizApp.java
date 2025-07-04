import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, String[]> questions = new LinkedHashMap<>();
        LinkedHashMap<String, String> correctAnswers = new LinkedHashMap<>();

        questions.put("What is the capital of India?", new String[]{"(a) Delhi", "(b) Mumbai", "(c) Kolkata", "(d) Chennai"});
        correctAnswers.put("What is the capital of India?", "a");

        questions.put("Which language is used for Android development?", new String[]{"(a) Swift", "(b) Kotlin", "(c) Python", "(d) Ruby"});
        correctAnswers.put("Which language is used for Android development?", "b");

        questions.put("What does JVM stand for?", new String[]{"(a) Java Virtual Machine", "(b) Java Visual Model", "(c) Java Volume Manager", "(d) None"});
        correctAnswers.put("What does JVM stand for?", "a");

        int score = 0;
        int qNo = 1;

        for (Map.Entry<String, String[]> entry : questions.entrySet()) {
            String question = entry.getKey();
            String[] options = entry.getValue();

            System.out.println("Question " + qNo + ": " + question);
            for (String option : options) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (a/b/c/d): ");
            String userAnswer = sc.nextLine().trim().toLowerCase();

            String correctOptionLetter = correctAnswers.get(question);
            String correctOptionText = "";

            for (String option : options) {
                if (option.toLowerCase().startsWith(correctOptionLetter + ")")) {
                    correctOptionText = option;
                    break;
                }
            }

            if (userAnswer.equals(correctOptionLetter)) {
                score++;
            } else {
                System.out.println("Incorrect. The correct answer for Question " + qNo + " is: " + correctOptionText);
            }

            System.out.println();
            qNo++;
        }

        System.out.println("Quiz completed.");
        System.out.println("Your score is: " + score + "/" + questions.size());

        sc.close();
    }
}
