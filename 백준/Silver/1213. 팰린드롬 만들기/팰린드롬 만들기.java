import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();
        int[] numOfChar = new int[26];
        for (int i = 0; i < name.length(); i++) {
            numOfChar[name.charAt(i) - 65]++;
        }
        int temp = -1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numOfChar.length; i++) {
            if (numOfChar[i] % 2 == 1) {
                if (temp != -1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                temp = i;
            }
            while (numOfChar[i] > 1) {
                builder.insert(builder.length() / 2, (char) (i + 65));
                builder.insert(builder.length() / 2, (char) (i + 65));
                numOfChar[i] -= 2;
            }
        }
        if (temp != -1) {
            builder.insert(builder.length() / 2, (char) (temp + 65));
        }
        System.out.println(builder.toString());
    }
}