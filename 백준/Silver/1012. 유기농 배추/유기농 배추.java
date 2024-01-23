import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String line;
            line = r.readLine();
            int T = Integer.parseInt(line);
            for (int i = 0; i < T; i++) {
                line = r.readLine();
                int M = Integer.parseInt(line.split(" ")[0]);
                int N = Integer.parseInt(line.split(" ")[1]);
                int K = Integer.parseInt(line.split(" ")[2]);
                boolean[][] farm = new boolean[M][N];
                for (int j = 0; j < K; j++) {
                    line = r.readLine();
                    int x = Integer.parseInt(line.split(" ")[0]);
                    int y = Integer.parseInt(line.split(" ")[1]);
                    farm[x][y] = true;
                }
                boolean[][] visited = new boolean[M][N];
                System.out.println(solveWithBFS(farm, visited));
            }
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solveWithBFS(boolean[][] farm, boolean[][] visited) {
        int worm = 0;
        for (int i = 0; i < farm.length; i++) {
            for (int j = 0; j < farm[0].length; j++) {
                if (farm[i][j] && !visited[i][j]) {
                    worm++;
                    ArrayList<int[]> queue = new ArrayList<int[]>();
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    queue.add(pos);
                    while (!queue.isEmpty()) {
                        int x = queue.get(0)[0];
                        int y = queue.get(0)[1];
                        if (x > 0 && farm[x - 1][y] && !visited[x - 1][y]) {
                            visited[x - 1][y] = true;
                            int[] problem = queue.get(0).clone();
                            problem[0]--;
                            queue.add(problem);
                        }
                        if (x < farm.length - 1 && farm[x + 1][y] && !visited[x + 1][y]) {
                            visited[x + 1][y] = true;
                            int[] problem = queue.get(0).clone();
                            problem[0]++;
                            queue.add(problem);
                        }
                        if (y > 0 && farm[x][y - 1] && !visited[x][y - 1]) {
                            visited[x][y - 1] = true;
                            int[] problem = queue.get(0).clone();
                            problem[1]--;
                            queue.add(problem);
                        }
                        if (y < farm[0].length - 1 && farm[x][y + 1] && !visited[x][y + 1]) {
                            visited[x][y + 1] = true;
                            int[] problem = queue.get(0).clone();
                            problem[1]++;
                            queue.add(problem);
                        }
                        queue.remove(0);
                    }
                }
            }
        }
        return worm;
    }

    private static int solveWithDFS(boolean[][] farm, boolean[][] visited) {
        int worm = 0;
        for (int i = 0; i < farm.length; i++) {
            for (int j = 0; j < farm[0].length; j++) {
                if (farm[i][j] && !visited[i][j]) {
                    worm++;
                    ArrayList<int[]> stack = new ArrayList<int[]>();
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    stack.add(pos);
                    while (!stack.isEmpty()) {
                        int index = stack.size() - 1;
                        int x = stack.get(index)[0];
                        int y = stack.get(index)[1];
                        if (x > 0 && farm[x - 1][y] && !visited[x - 1][y]) {
                            visited[x - 1][y] = true;
                            int[] problem = stack.get(index).clone();
                            problem[0]--;
                            stack.add(problem);
                        }
                        if (x < farm.length - 1 && farm[x + 1][y] && !visited[x + 1][y]) {
                            visited[x + 1][y] = true;
                            int[] problem = stack.get(index).clone();
                            problem[0]++;
                            stack.add(problem);
                        }
                        if (y > 0 && farm[x][y - 1] && !visited[x][y - 1]) {
                            visited[x][y - 1] = true;
                            int[] problem = stack.get(index).clone();
                            problem[1]--;
                            stack.add(problem);
                        }
                        if (y < farm[0].length - 1 && farm[x][y + 1] && !visited[x][y + 1]) {
                            visited[x][y + 1] = true;
                            int[] problem = stack.get(index).clone();
                            problem[1]++;
                            stack.add(problem);
                        }
                        stack.remove(index);
                    }
                }
            }
        }
        return worm;
    }
}