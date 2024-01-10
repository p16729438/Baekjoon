import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int goodWordNumber = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (!builder.isEmpty()) {
                    if (builder.charAt(builder.length() - 1) == str.charAt(j)) {
                        builder.deleteCharAt(builder.length() - 1);
                        continue;
                    }
                }
                builder.append(str.charAt(j));
            }
            if (builder.isEmpty()) {
                goodWordNumber++;
            }
        }
        sc.close();
        System.out.println(goodWordNumber);
    }
}