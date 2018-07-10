class Solution {
    public boolean isValid(String s) {
        if((s.length() < 2) || ((s.length()%2) != 0))
            return false;
        
        Stack<Character> cstack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a != ')' && a != ']' && a != '}') {
                cstack.push(s.charAt(i));
            }
            else {
                if(cstack.empty())
                    return false;
                char c = cstack.pop();
                if((a == ')' && c != '(') || (a == '}' && c != '{') || (a == ']' && c != '['))
                    return false;
            }
            
        }
        if(cstack.empty())
            return true;
        return false;
    }
}
