class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){        
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int matched = 0; //to store total noumber of characters found
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0; //to count the length of current substring having all elements of t
        for(int endWindow = 0; endWindow < s.length(); endWindow++){
            char right = s.charAt(endWindow);
            if(map.containsKey(right)){
                map.put(right,map.get(right)-1);
                if(map.get(right)==0)
                matched++;
            }
            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
        
    }
}
