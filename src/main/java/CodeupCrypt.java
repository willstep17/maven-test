public class CodeupCrypt {
    private static String password;
    private static char[] hashInitial = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'};
    private static char[] hashKey = {'4', '4', '3', '3', '1', '1', '0', '0', '9', '9'};

    public static void main(String[] args) {
        password = "Rabbit aEiOU";
        password = hash(password);
        System.out.println(password);
    }

    public static String hash(String inputPassword) {
        char[] inputPasswordChars = inputPassword.toCharArray();
        for(int i=0;i<inputPasswordChars.length;i++) {
            for(int j=0;j<hashInitial.length;j++) {
                if(inputPasswordChars[i] == hashInitial[j]) {
                    inputPasswordChars[i] = hashKey[j];
                }
            }
        }
        return new String(inputPasswordChars);
    }

}
