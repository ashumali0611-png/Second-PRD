
public class Main {

    public static void main(String[] args) {
        String correctUsername = "learner01";
        int correctPin = 1234;

        String attempt1User = "learner01";
        int attempt1Pin = 9999;

        String attempt2User = "learner01";
        int attempt2Pin = 1234;

        String attempt3User = "wrongUser";
        int attempt3Pin = 0000;

        int currentAttempt = 1;
        int maxAttempts = 3;
        boolean isLoggedIn = false;

        System.out.println("LOGIN SECURITY REPORT\n");

        while (currentAttempt <= maxAttempts && !isLoggedIn) {
            String currentInputUser;
            int currentInputPin;

            if (currentAttempt == 1) {
                currentInputUser = attempt1User;
                currentInputPin = attempt1Pin;
            } else if (currentAttempt == 2) {
                currentInputUser = attempt2User;
                currentInputPin = attempt2Pin;
            } else {
                currentInputUser = attempt3User;
                currentInputPin = attempt3Pin;
            }

            boolean isUserCorrect = currentInputUser.equals(correctUsername);
            boolean isPinCorrect = currentInputPin == correctPin;

            System.out.println("Attempt" + currentAttempt);

            String userStatus = isUserCorrect ? "correct" : "Incorrect";
            String pinStatus = isPinCorrect ? "correct" : "Incorrect";

            System.out.println("Username Status: " + userStatus);
            System.out.println("Pin Status:" + pinStatus);

            if (isUserCorrect && isPinCorrect) {
                isLoggedIn = true;
                System.out.println("Login Result: Successful");
            } else {
                System.out.println("Login Result: Failed");

                int remainingAttempts = maxAttempts - currentAttempt;
                System.out.println("Remaining Attempts:" + remainingAttempts);
            }

            System.out.println();

            currentAttempt++;
        }

        if (isLoggedIn) {
            System.out.println("Welcome, " + correctUsername + ".");
        } else {
            System.out.println("Account Status: Locked");
            System.out.println("You have exceeded the maximum login attempts.");
        }

    }

}
