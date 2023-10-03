package greedy;

public class Dijkstra {

    public static int[] solution(int[][] nums, int start) {
        int[] dis = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        visited[start-1] = true;

        for(int i = 0; i < nums.length; i++) {
            dis[i] = nums[start-1][i];
        }

        int minDis = Integer.MAX_VALUE;
        int minLoc = -1;

        for(int i = 0; i < nums.length-1; i++) {
            minDis = Integer.MAX_VALUE;
            for(int j = 0; j < nums.length; j++) {
                if(dis[j] != Integer.MAX_VALUE && dis[j] < minDis && !visited[j]) {
                    minDis = dis[j];
                    minLoc = j;

                }
            }

            visited[minLoc] = true;

            for(int j = 0; j < nums.length; j++) {
                if(nums[minLoc][j] != Integer.MAX_VALUE) {
                    dis[j] = Math.min(dis[minLoc] + nums[minLoc][j], dis[j]);
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        int inf = Integer.MAX_VALUE;
        int[][] nums = new int[][] {
                {0, 1, 12, inf, inf, inf},
                {inf, 0, 9, 3, inf, inf},
                {inf, inf, 0, inf, 5, inf},
                {inf, inf, 4, 0, 13, 15},
                {inf, inf, inf, inf, 0, 4},
                {inf, inf, inf, inf, inf, 0}
        };

        int[] res = Dijkstra.solution(nums, 1);

        for(int i : res) {
            System.out.print(i);
            System.out.println('\t');
        }
        System.out.println();
    }
}
