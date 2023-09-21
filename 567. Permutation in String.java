class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        char[] s1_array = s1.toCharArray();
        char[] s2_array = s2.toCharArray();
        int[] s1_alphabet = new int[26];
        int[] s2_alphabet = new int[26];
        for (char c: s1_array){
            s1_alphabet[c-'a']++;
        }
        for (int i = 0; i < m; i++){
            s2_alphabet[s2_array[i] - 'a']++;
        }
        if (Arrays.equals(s1_alphabet, s2_alphabet)) return true;
        for (int i = m; i < n; i++){
            s2_alphabet[s2_array[i] - 'a']++;
            s2_alphabet[s2_array[i-m] - 'a']--;
            if (Arrays.equals(s1_alphabet, s2_alphabet)) return true;
        }
        return false;
        
    }
}
