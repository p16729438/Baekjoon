import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[sc.nextLine().charAt(0) - 97]++;
        }
        sc.close();
        StringBuilder str = new StringBuilder();
        for (char i = 0; i < count.length; i++) {
            if (count[i] >= 5) {
                str.append((char) (i + 97));
            }
        }
        if (str.toString().equalsIgnoreCase("")) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(str.toString());
        }
    }
}