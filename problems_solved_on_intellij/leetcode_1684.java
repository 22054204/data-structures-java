package problems_solved_on_intellij;

import java.util.*;
public class leetcode_1684 {
    static void main() {
        String allowed = "abc";
        String[] words = {"a","b","c","ab","ac","bc","abc"};
        int result = countConsistentStrings(allowed, words);
        System.out.println(result);

    }
    static int countConsistentStrings(String allowed, String[] words) {

        leetcode_1684 obj = new leetcode_1684();

        List<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            list.add(words[i]);
        }

        List<String> uniq = obj.helper(list);
        int count = 0;
        for(int i=0;i<uniq.size();i++){
            boolean flag = true;
            for(int j=0;j<uniq.get(i).length();j++){
                if(!allowed.contains("" + uniq.get(i).charAt(j))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }

    List<String> helper(List<String> list){
        List<String> uniq = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String s = list.get(i);
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<s.length();j++){
                set.add(s.charAt(j));
            }
            String temp = "";
            for(char x : set){
                temp += x;
            }
            uniq.add(temp);
        }
        return uniq;
    }
}
