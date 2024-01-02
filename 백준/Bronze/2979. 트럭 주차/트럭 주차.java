import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cost = new int[3];
        int[][] truck = new int[3][2];
        for (int i = 0; i < 3; i++) {
            cost[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                truck[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int totalCost = 0;
        for (int time = 0; time < truck[0][1] || time < truck[1][1] || time < truck[2][1]; time++) {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                if (time >= truck[i][0] && time < truck[i][1]) {
                    count++;
                }
            }
            if (count > 0) {
                totalCost += cost[count - 1] * count;
            }
        }
        System.out.println(totalCost);
    }
}