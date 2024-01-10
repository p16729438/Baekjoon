import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String line = r.readLine();
            r.close();
            long A = Long.parseLong(line.split(" ")[0]);
            long B = Long.parseLong(line.split(" ")[1]);
            long C = Long.parseLong(line.split(" ")[2]);
            System.out.println(calc(A, B, C));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long calc(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }
        if (B % 2 == 0) {
            long result = calc(A, B / 2, C);
            return result * result % C;
        }
        long result = calc(A, B / 2, C);
        return result * result % C * A % C;
    }
}