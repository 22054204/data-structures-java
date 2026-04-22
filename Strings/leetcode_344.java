// Leetcode-344
// Reverse String
//https://leetcode.com/problems/reverse-string/
package Strings;
import java.util.*;
public class leetcode_344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i<j){
            swap(s, i , j);
            i++;
            j--;
        }
    }
    public static void swap(char[] s , int first, int second){
        char temp = s[first];
        s[first] = s[second];
        s[second] = temp;
    }
}
