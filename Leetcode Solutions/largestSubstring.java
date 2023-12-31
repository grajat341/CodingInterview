import java.util.HashMap;

public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();

        int result = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (!mp.containsKey(ch)) {
                mp.put(ch, i);
            } else {
                result = Math.max(result, i - mp.get(ch) - 1);
            }
        }

        return result;
    }
}