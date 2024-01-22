import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String line = r.readLine();
            int N = Integer.parseInt(line.split(" ")[0]);
            int M = Integer.parseInt(line.split(" ")[1]);
            boolean[][] maze = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                line = r.readLine();
                for (int j = 0; j < M; j++) {
                    if (line.charAt(j) == '0') {
                        maze[i][j] = false;
                    } else if (line.charAt(j) == '1') {
                        maze[i][j] = true;
                    }
                }
            }
            r.close();
            boolean[][] visited = new boolean[N][M];
            visited[0][0] = true;
            ArrayList<int[]> queue = new ArrayList<int[]>();
            queue.add(new int[3]);
            while (!queue.isEmpty()) {
                int x = queue.get(0)[0];
                int y = queue.get(0)[1];
                int move = queue.get(0)[2];
                if (x == maze.length - 1 && y == maze[0].length - 1) {
                    System.out.println(move + 1);
                    return;
                }
                if (x > 0 && maze[x - 1][y] && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    int[] problem = queue.get(0).clone();
                    problem[0]--;
                    problem[2]++;
                    queue.add(problem);
                }
                if (x < maze.length - 1 && maze[x + 1][y] && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    int[] problem = queue.get(0).clone();
                    problem[0]++;
                    problem[2]++;
                    queue.add(problem);
                }
                if (y > 0 && maze[x][y - 1] && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    int[] problem = queue.get(0).clone();
                    problem[1]--;
                    problem[2]++;
                    queue.add(problem);
                }
                if (y < maze[0].length - 1 && maze[x][y + 1] && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    int[] problem = queue.get(0).clone();
                    problem[1]++;
                    problem[2]++;
                    queue.add(problem);
                }
                queue.remove(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}