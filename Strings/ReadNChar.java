/* The read4 API is defined in the parent class Reader4.
 int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        
        while(count < n) {
            char[] read_buf = new char[4];
            int cur_read = read4(read_buf);
            for(int i = 0; i < cur_read && count < n; i++) {
                buf[count] = read_buf[i];
                count++;
            }
            if(cur_read < 4)
                break;
        }
        
        return count;
    }
}
