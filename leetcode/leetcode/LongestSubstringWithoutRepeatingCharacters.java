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
        int[] map = new int[256];
        int result = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map[s.charAt(i)] != 0) {
                j = Math.max(j, map[s.charAt(j)] + 1);
            }
            map[s.charAt(i)] = i;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

}
