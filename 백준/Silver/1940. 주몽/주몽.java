import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashSet<Integer> materials = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            materials.add(sc.nextInt());
        }
        sc.close();
        int total = 0;
        for (int material : materials) {
            if (M - material == material) {
                continue;
            }
            if (materials.contains(material) && materials.contains(M - material)) {
                total++;
            }
        }
        total /= 2;
        System.out.println(total);
    }
}