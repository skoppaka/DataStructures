class Solution {
    public int myAtoi(String str) {
        int result = 0;
        int index = 0;
        int sign = 1;
        for(; index < str.length(); index++) {
            char c = str.charAt(index);
            if(c == ' ')
                continue;
            if(((c - '0') >= 0) && ((c - '0') <= 9)) {
                break;
            }
            else if (c == '+' || c == '-') {
                index++;
                if(c == '-')
                    sign = -1;
                
                break;
            }
            else
                return 0;
        }
        
        for(; index < str.length(); index++) {
            char c = str.charAt(index);
            if(((c - '0') < 0) || ((c - '0') > 9)) {
                return result*sign;
            }
            int temp = result;
            result *= 10;
            result += c - '0';
            if(temp != ((result - (c - '0'))/10) || (result < temp)) {
                return (sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE);
            }
            
        }
        return result*sign;
        
    }
}
