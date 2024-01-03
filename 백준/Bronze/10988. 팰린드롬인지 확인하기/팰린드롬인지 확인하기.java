import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        sc.close();
        for (int i = 0; i < word.length() + 1 / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}