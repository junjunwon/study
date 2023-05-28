package test;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChickenDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int answer = 0;

        List<Node> chickens = new ArrayList<>();
        List<Node> homes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                //거리구할땐 항상 +1 해주기
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
//                    int totalDistance = bfs(i, j, map);
//                    if (totalDistance < answer) {
//                        answer = totalDistance;
//                    }
                    chickens.add(new Node(i, j));
                } else if (map[i][j] == 1) {
                    homes.add(new Node(i, j));
                }

            }
        }

        for (Node chicken : chickens) {

        }
        System.out.println(answer);
    }

    private static int bfs(int i, int j, int[][] map) {
        /**
         * 동서남북 찾아보자
         */
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int N = map.length;
        boolean[][] visit = new boolean[N][N];
        /**
         * QUEUE
         */
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        visit[i][j] = true;

        //result
        int localAnswer = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx > map.length - 1 || ny > map.length - 1) {
                    continue;
                }
                if (visit[nx][ny] == false) {
                    if (map[nx][ny] == 1) {
                        localAnswer += Math.abs(nx - i) + Math.abs(ny - j);
                    }

                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        return localAnswer;
    }

    static class Node {
        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
    }
}
