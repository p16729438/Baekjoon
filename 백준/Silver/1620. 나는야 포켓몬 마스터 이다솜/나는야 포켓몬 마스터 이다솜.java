import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, String> idToName = new HashMap<Integer, String>();
        HashMap<String, Integer> nameToId = new HashMap<String, Integer>();
        for (int i = 1; i <= N; i++) {
            String name = sc.nextLine();
            idToName.put(i, name);
            nameToId.put(name, i);
        }
        for (int i = 0; i < M; i++) {
            String p = sc.nextLine();
            try {
                int id = Integer.parseInt(p);
                System.out.println(idToName.get(id));
            } catch (NumberFormatException e) {
                System.out.println(nameToId.get(p));
            }
        }
        sc.close();
    }
}