package greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> item = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        for(String word1 : wordList) {
            for(String word2 : wordList) {
                if(canReach(word1, word2)) {
                    List<String> temp = map.getOrDefault(word1, new ArrayList<>());
                    temp.add(word2);
                    map.put(word1, temp);
                }
            }
        }

        Map<String, Boolean> visited = new HashMap<>();

        if(!map.containsKey(endWord)) return res;
        if(!map.containsKey(beginWord)) {
            for(String word : wordList) {
                if(canReach(beginWord, word)) {
                    List<String> temp = map.getOrDefault(beginWord, new ArrayList<>());
                    temp.add(word);
                    map.put(beginWord, temp);
                }
            }
        }

        item.add(beginWord);
        dfs(beginWord, endWord, map, visited, item, res);

        res.sort(Comparator.comparingInt(List::size));
        if(res.size() == 0) return res;

        int shortestLen = res.get(0).size();
        res = res.stream().filter(o->o.size() == shortestLen).collect(Collectors.toList());

        return res;
    }

    public void dfs(String currentWord, String endWord, Map<String, List<String>> map,  Map<String, Boolean> visited, List<String> temp, List<List<String>> res) {
        if(currentWord.equals(endWord)) {
            res.add(new ArrayList<>(temp));
            return;
        }

        List<String> linked = map.get(currentWord);
        for(String s : linked) {
            if(!visited.containsKey(s) || !visited.get(s)) {
                visited.put(s, true);
                temp.add(s);
                dfs(s, endWord, map, visited, temp, res);
                visited.put(s, false);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean canReach(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if(count > 1) return false;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        Leetcode126 leetcode126 = new Leetcode126();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        leetcode126.findLadders(beginWord, endWord, wordList);
    }
}
