import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> heightSet = new HashSet<Integer>();
        int total = 0;
        for (int i = 0; i < 9; i++) {
            int height = sc.nextInt();
            heightSet.add(height);
            total += height;
        }
        sc.close();
        for (int height : heightSet) {
            if (heightSet.contains(total - height - 100) && total - height - 100 != height) {
                heightSet.remove(height);
                heightSet.remove(total - height - 100);
                break;
            }
        }
        ArrayList<Integer> heightList = new ArrayList<Integer>(heightSet);
        heightList.sort(Comparator.naturalOrder());
        for (int height : heightList) {
            System.out.println(height);
        }
    }
}