class Solution {

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ans = 0;
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            max = Math.max(max, freq[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
