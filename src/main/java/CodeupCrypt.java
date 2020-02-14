import org.apache.commons.lang3.StringUtils;
import util.Input;
import java.util.Random;

public class CodeupCrypt {
    private final static char[] HASH_INITIAL = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'T', 't'};
    private final static char[] HASH_KEY_ONE = {'4', '4', '3', '3', '1', '1', '0', '0', '9', '9', '@', '@'};
    private final static char[] HASH_KEY_TWO = {'r', 'v', '&', '6', '2', 'i', 'j', '[', '|', '|', 'r', 'p'};

    public static void main(String[] args) {
        Input input = new Input();
        String password;
        String encrypted;
        int userInput;

        while (true) {
            System.out.println("1 - Encrypt Password  2 - Decrypt Password  3 - Exit");
            userInput = input.getInt("Selection: ");
            if (userInput == 1) {
                password = input.getString("Enter a password to encrypt: ");
                password = hash(password);
                System.out.println("Encrypted password: " + password);
            } else if (userInput == 2) {
                encrypted = input.getString("Enter an encrypted password: ");
                encrypted = decryptHash(encrypted);
                System.out.println("Decrypted password: " + encrypted);
            } else if (userInput == 3) {
                System.out.println("Goodbye.");
                return;
            }
        }

    }

    public static String hash(String inputPassword) {
        Random random = new Random();
        char[] hashKey = new char[0];
        int rand_int = random.nextInt(2);
        switch (rand_int) {
            case 0:
                hashKey = HASH_KEY_ONE.clone();
                break;
            case 1:
                hashKey = HASH_KEY_TWO.clone();
                break;
        }
        char[] inputPasswordChars = inputPassword.toCharArray();
        for (int i = 0; i < inputPasswordChars.length; i++) {
            for (int j = 0; j < HASH_INITIAL.length; j++) {
                if (inputPasswordChars[i] == HASH_INITIAL[j]) {
                    inputPasswordChars[i] = hashKey[j];
                }
            }
        }
        String returnString = new String(inputPasswordChars);
        return StringUtils.reverse(returnString);
    }

    public static String decryptHash(String inputEncrypted) {
        char[] inputEncryptedChars = inputEncrypted.toCharArray();
        for (int i = 0; i < inputEncryptedChars.length; i++) {
            for (int j = HASH_KEY_ONE.length - 1; j > 0; j--) {
                if (inputEncryptedChars[i] == HASH_KEY_ONE[j]) {
                    inputEncryptedChars[i] = HASH_INITIAL[j];
                }
            }
        }
        String returnString = new String(inputEncryptedChars);
        return StringUtils.reverse(returnString);
    }
}
