class Solution {
    public String addBinary(String a, String b) {
        
        if (a.length() == 0)
            return b;
        else if (b.length() == 0)
            return a;
        
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() -1;
        int j = b.length() -1;
        while( i>=0 || j >=0 || carry == 1) {
            carry += ((i >=0)?(a.charAt(i) - '0'):0);
            carry += ((j >=0)?(b.charAt(j) - '0'):0);
            
            char c = (char)((carry%2) + '0');
            result.append(c);
            carry = carry/2;
            i--;
            j--;
        }
        result.reverse();
        return result.toString();
    }
}
