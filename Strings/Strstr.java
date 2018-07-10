class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length())
            return -1;
        
        final int BASE = 26;
        int powerS = 0;
        int hayhash = 0, nedhash = 0;
        
        for(int i = 0; i < needle.length(); i++) {
            powerS = (i > 0)?(powerS*BASE):1;
            hayhash = hayhash*BASE + haystack.charAt(i);
            nedhash = nedhash*BASE + needle.charAt(i);
        }
        
        for(int i = needle.length(); i < haystack.length(); i++) {
            if(hayhash == nedhash && haystack.substring(i-needle.length(), i).equals(needle))
                return (i-needle.length());
            
            hayhash = hayhash - haystack.charAt(i-needle.length())*powerS;
            hayhash = hayhash*BASE + haystack.charAt(i);
        }
        
        if(hayhash == nedhash && haystack.substring(haystack.length()-needle.length()).equals(needle))
            return (haystack.length()-needle.length());
        
        return -1;
    }
}
