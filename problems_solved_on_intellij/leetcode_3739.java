/*
Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= target <= 10^9
 */
package problems_solved_on_intellij;
import java.util.*;
public class leetcode_3739 {
    public static void main() {
        int[] nums = {1,2,2,3};
        int target = 2;
        System.out.println("nums - "+ Arrays.toString(nums));
        System.out.println(countMajoritySubarrays(nums, target));
    }
    public static long countMajoritySubarrays(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                nums[i] = 1;
            }else{
                nums[i] = -1;
            }
        }
        System.out.println("nums - "+ Arrays.toString(nums));
        int[] prefix = new int[nums.length];
        prefix[0] = 0;
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        System.out.println("prefix - "+ Arrays.toString(prefix));
        return 0;
    }
}
