/*
Input:
nums = [1, 2, 3, 2, 4, 1, 5]

Frequencies:
1 → 2
2 → 2
3 → 1
4 → 1
5 → 1

Output:
3 + 4 + 5 = 12
*/

package Practice_Problems;
import java.util.*;
public class SumOfUniqueElements {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter Array's Element One by One: ");
        for(int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        //System.out.println(Arrays.toString(nums));
        System.out.print("Output: " + solve(nums));
    }
    public static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max, num);
        }
        return (max==Integer.MIN_VALUE)?-1:max;
    }
    public static int solve(int[] nums){
        int result = 0;
        int size = max(nums);
        int[] freq = new int[size+1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        //System.out.println(Arrays.toString(freq));
        for(int i=0;i<=size;i++){
            if(freq[i]==1){
                result+=i;
            }
        }
        return result;
    }
}
