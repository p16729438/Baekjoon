import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> heightList = new ArrayList<Integer>();
        int total = 0;
        for (int i = 0; i < 9; i++) {
            int height = sc.nextInt();
            heightList.add(Integer.valueOf(height));
            total += height;
        }
        sc.close();
        for (int height : heightList) {
            if (total - height - 100 != height && heightList.contains(Integer.valueOf(total - height - 100))) {
                heightList.remove(Integer.valueOf(height));
                heightList.remove(Integer.valueOf(total - height - 100));
                break;
            }
        }
        heightList.sort(Comparator.naturalOrder());
        for (int height : heightList) {
            System.out.println(height);
        }
    }
}