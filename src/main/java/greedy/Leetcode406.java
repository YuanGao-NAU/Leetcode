package greedy;

import java.util.*;

public class Leetcode406 {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2)-> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        List<int[]> list = new ArrayList<>();
        for(int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] peoples = new int[][] {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        Leetcode406.reconstructQueue(peoples);
    }
}
