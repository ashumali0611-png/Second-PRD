
import java.util.Scanner;

public class Main {

    private static final String CORRECT_USERNAME = "learner01";
    private static final int CORRECT_PIN = 1234;
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentAttempt = 1;
        boolean isLoggedIn = false;

        System.out.println("LOGIN SECURITY REPORT\n");

        while (currentAttempt <= MAX_ATTEMPTS && !isLoggedIn) {
            System.out.println("Attempt " + currentAttempt);

            System.out.print("Enter Username: ");
            String currentInputUser = scanner.nextLine();

            System.out.print("Enter PIN: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. PIN must be a number.");
                scanner.next();
                System.out.print("Enter PIN: ");
            }
            int currentInputPin = scanner.nextInt();
            scanner.nextLine();

            boolean isUserCorrect = currentInputUser.equals(CORRECT_USERNAME);
            boolean isPinCorrect = (currentInputPin == CORRECT_PIN);

            String userStatus = isUserCorrect ? "correct" : "Incorrect";
            String pinStatus = isPinCorrect ? "correct" : "Incorrect";

            System.out.println("Username Status: " + userStatus);
            System.out.println("Pin Status: " + pinStatus);

            if (isUserCorrect && isPinCorrect) {
                isLoggedIn = true;
                System.out.println("Login Result: Successful");
            } else {
                System.out.println("Login Result: Failed");

                int remainingAttempts = MAX_ATTEMPTS - currentAttempt;
                System.out.println("Remaining Attempts: " + remainingAttempts);
            }

            System.out.println();
            currentAttempt++;
        }

        if (isLoggedIn) {
            System.out.println("Welcome, " + CORRECT_USERNAME + ".");
        } else {
            System.out.println("Account Status: Locked");
            System.out.println("You have exceeded the maximum login attempts.");
        }

        scanner.close();
    }
}
