class Solution {
    public String longestPalindrome(String s) {
        int longest = 0;
        int si = 0;
        int ei = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int oddlen = checkpalin(s, i, i);
            int evenlen = checkpalin(s, i, i+1);
            longest = Math.max(oddlen, evenlen);
            
            if(longest > (ei - si)) {
                si = i - (longest -1)/2;
                ei = i + longest/2;
            }
        }
        
        return s.substring(si, ei+1);
    }
    
    public int checkpalin(String s, int left, int right) {
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
