class Solution {
    public String lcpduo(String a, String b) {
        StringBuilder lcp = new StringBuilder();
        
        for(int i = 0; (i < a.length()) && (i < b.length()); i++) {
            if(a.charAt(i) == b.charAt(i))
                lcp.append(a.charAt(i));
            else
                return lcp.toString();
        }
        return lcp.toString();
    }
    
    public String longestCommonPrefix(String[] strs) {
        String lcp = new String();
        if (strs.length != 0)
            lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            lcp = lcpduo(lcp, strs[i]);
        }
        
        return lcp.toString();
        
    }
}
