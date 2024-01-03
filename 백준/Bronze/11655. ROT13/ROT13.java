import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        StringBuilder rot13Builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 65 && str.charAt(i) <= 90)) {
                char c = (char) (str.charAt(i) + 13);
                if (c > 90) {
                    c -= 26;
                }
                rot13Builder.append(c);
                continue;
            }
            if ((str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                char c = (char) (str.charAt(i) + 13);
                if (c > 122) {
                    c -= 26;
                }
                rot13Builder.append(c);
                continue;
            }
            rot13Builder.append(str.charAt(i));
        }
        System.out.println(rot13Builder.toString());
    }
}