/*
Given a string, find the length of the longest substring without repeating 
characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer
must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int[] map = new int[256];
        for (int i = 0, j = 1; i < s.length(); ++i) {
            if (map[s.charAt(i)] != 0) {
                j = Math.max(j, map[s.charAt(i)] + 1);
            }
            map[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 2);
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) != null) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

}