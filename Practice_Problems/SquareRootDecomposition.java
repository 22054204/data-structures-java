package Practice_Problems;

import java.util.*;
// Range Sum Query with Sqrt Decomposition Method
public class SquareRootDecomposition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int BlockSize = (int) Math.sqrt(nums.length);
        int[] Block = new int[(nums.length + BlockSize - 1) / BlockSize];
        for(int i=0;i<nums.length;i++){
            Block[i/BlockSize] += nums[i];
        }
        System.out.println("nums Array: "+ Arrays.toString(nums));
        System.out.println("BlockSize: "+BlockSize);
        System.out.println("Block Array: "+ Arrays.toString(Block));

        System.out.println("Enter left: ");
        int left = scanner.nextInt();
        System.out.println("Enter left: ");
        int right = scanner.nextInt();
        System.out.println(QuerySumRange(nums, Block, BlockSize, left, right));
    }
    public static int QuerySumRange(int[] nums, int[] Block, int BlockSize, int left, int right){
        int sum = 0;
        // Case 1 => if left & right in same block
        int startBlock = left/BlockSize;
        int endBlock = right/BlockSize;
        if(startBlock == endBlock){ // same Block
            for(int i=left;i<=right;i++){ // O(Sqrt n);
                sum+=nums[i];
            }
        }else if(startBlock!=endBlock){ // case 2 => Both left and right is in different blocks
            // left - {may be full or partial block} // left to end of this block = left part
            int endOfStartBlock = (startBlock+1)*BlockSize - 1;
            for(int i=left;i<=endOfStartBlock;i++){
                sum+=nums[i];
            }
            // middle {full block, if you have} // (endOfStartBlock+1) to (startOfEndBlock-1)
            for(int i=startBlock+1;i<endBlock;i++){ // O(sqrt n)
                sum+=Block[i]; // O(1) because we already find this before
            }
            // right {may be full or partial block}
            int startOfEndBlock = endBlock*BlockSize;
            for(int i=startOfEndBlock;i<=right;i++){
                sum+=nums[i];
            }
        }
        return sum;
    }
}
