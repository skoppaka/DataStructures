class Solution {
    public int repeatedStringMatch(String A, String B) {
        
        StringBuilder str = new StringBuilder(A);
        int count = 1;
        while (str.length() < B.length()) {
            str.append(A);
            count++;
        }
        
        if(str.toString().contains(B))
            return count;
        else {
            str.append(A);
            if(str.toString().contains(B))
                return (count + 1);
            else
                return (-1);
        }
        
    }
}
