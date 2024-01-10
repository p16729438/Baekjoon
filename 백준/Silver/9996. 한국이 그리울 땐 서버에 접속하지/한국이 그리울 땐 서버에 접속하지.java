import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String pattern = sc.nextLine();
        String left = pattern.split("\\*")[0];
        String right = pattern.split("\\*")[1];
        for (int i = 0; i < n; i++) {
            String fileName = sc.nextLine();
            if (fileName.length() < pattern.length() - 1) {
                System.out.println("NE");
                continue;
            }
            if (fileName.startsWith(left) && fileName.endsWith(right)) {
                System.out.println("DA");
                continue;
            }
            System.out.println("NE");
        }
        sc.close();
    }
}