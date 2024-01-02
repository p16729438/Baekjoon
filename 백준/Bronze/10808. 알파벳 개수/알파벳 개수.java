import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphabetCount = new int[26];
        String S = sc.nextLine();
        sc.close();
        for (int i = 0; i < S.length(); i++) {
            alphabetCount[S.charAt(i) - 97]++;
        }
        for (int i : alphabetCount) {
            System.out.print(i + " ");
        }
    }
}