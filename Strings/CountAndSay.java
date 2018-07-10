class Solution {
    public String nextNum(String s) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int count = 1;
            while(((i+1) < s.length()) && (s.charAt(i) == s.charAt(i+1))) {
                count++;
                i++;
            }
            res.append(count);
            res.append(s.charAt(i));
        }
        return res.toString();
    }
    
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++)
            s = nextNum(s);
        
        return s;
    }
}
