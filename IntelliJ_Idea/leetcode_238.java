package IntelliJ_Idea;
import java.util.*;
public class leetcode_238 {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];//[1,]

        result[0] = 1;
        for(int i=1 ;i<nums.length;i++){
            result[i] = nums[i-1]*result[i-1];
        }

        int suffix = 1;
        for(int i=nums.length-1 ;i>=0;i--){
            result[i] = result[i]*suffix;
            suffix = suffix * nums[i];
        }

        return result;
    }
}
