import java.util.*;
import java.util.stream.Collectors;

public class Leetcode126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0) return new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        List<String> temp = new ArrayList<>();
        return null;
    }

    public boolean distanceEqualOne(String currentWord,  String nextChoice) {
        int diff = 0;
        for(int i = 0; i < currentWord.length(); i++) {
            if(currentWord.charAt(i) != nextChoice.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
