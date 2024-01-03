import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] temperature = new int[N];
        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = sc.nextInt();
        }
        sc.close();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < temperature.length - K + 1; i++) {
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += temperature[i + j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}