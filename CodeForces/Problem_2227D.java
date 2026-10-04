package CodeForces;

import java.util.*;
public class Problem_2227D{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while(testCases-- > 0){
            int n = scanner.nextInt();
            int[] arr = new int[n+n];
            for(int i=0;i<arr.length;i++){
                arr[i]=scanner.nextInt();
            }
            int MEX=0;
            for(int i=0;i<arr.length;i++){
                for(int j=i;j<arr.length;j++){
                    MEX=Math.max(MEX,helper(arr,new ArrayList<>(),i,j));
                }
            }
            System.out.println(MEX);
        }
        scanner.close();
    }
    public static int helper(int[] arr, List<Integer> list, int st, int end){
        for(int i=st;i<=end;i++){
            list.add(arr[i]);
        }
        //System.out.println("list "+list);
        if(isPalindrome(list)){
            for(int i=0;i<list.size();i++){
                if(!list.contains(i)){
                    //System.out.println(i);
                    return i;
                }
            }
            //System.out.println(list.size());
            return list.size();
        }
        return 0;
    }
    public static boolean isPalindrome(List<Integer> list){
        int i=0;
        int j=list.size()-1;
        while(i<j){
            if(list.get(i)!=list.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
