package strings;

public class leetcode_1980 {
    public static void main(String[] args) {
        String[] nums = {"01","10"};
        String s = findDifferentBinaryString(nums);
        System.out.println(s);
    }
    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] result = new char[n];

        for(int i = 0; i < n; i++){
            if(nums[i].charAt(i) == '0'){
                result[i] = '1';
            } else {
                result[i] = '0';
            }
        }

        return new String(result);
    }
}
