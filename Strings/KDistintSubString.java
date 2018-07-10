class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int cur = 0;
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        if(s.length() < 1 || k == 0)
            return 0;
        
        while(i< s.length() && j < s.length()) {
            while(map.size() <= k && j < s.length()) {
                if(map.size() == k && !map.containsKey(s.charAt(j)))
                    break;
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            cur = Math.max(cur, j-i);
            
            while(map.size() == k && i < s.length()) {
                if(map.get(s.charAt(i)) == 1)
                    map.remove(s.charAt(i));
                else
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
        }
        return cur;
    }
}
