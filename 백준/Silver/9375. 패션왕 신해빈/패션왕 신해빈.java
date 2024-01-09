import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            HashMap<String, Integer> clothes = new HashMap<String, Integer>();
            for (int j = 0; j < n; j++) {
                String type = sc.nextLine().split(" ")[1];
                if (clothes.containsKey(type)) {
                    clothes.put(type, clothes.get(type) + 1);
                } else {
                    clothes.put(type, 1);
                }
            }
            int numberOfCase = 1;
            for (String type : clothes.keySet()) {
                numberOfCase *= clothes.get(type) + 1;
            }
            numberOfCase--;
            System.out.println(numberOfCase);
        }
        sc.close();
    }
}