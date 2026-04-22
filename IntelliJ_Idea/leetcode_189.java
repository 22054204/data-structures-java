package IntelliJ_Idea;

import java.util.Arrays;

public class leetcode_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        swap(nums, 0, n-1);
        swap(nums, 0, k-1);
        swap(nums, k, n-1);

    }
    public static void swap(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}