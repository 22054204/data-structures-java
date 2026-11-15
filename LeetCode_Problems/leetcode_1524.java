package LeetCode_Problems;

public class leetcode_1524 {

    /*
    LeetCode 1524 - Number of Sub-arrays With Odd Sum

    Difficulty: Medium

    Topics: Array, Math, Dynamic Programming, Prefix Sum

    Problem Statement:

    You are given an array of integers arr. Your task is to find the
    total number of subarrays that have an odd sum.

    A subarray is a contiguous sequence of elements from the array.

    For example, if arr = [1, 2, 3], then the subarrays are:
    [1], [2], [3], [1, 2], [2, 3], and [1, 2, 3].

    You need to count how many of these subarrays have a sum
    that is an odd number.

    Since the answer can be very large, return the result modulo 10^9 + 7.

    Examples:

    Example 1:

    Input:
    arr = [1, 3, 5]

    Output:
    4

    Explanation:
    The subarrays with odd sums are:
    [1], [3], [5], and [1, 3, 5].

    Therefore, the total number of subarrays with odd sums is 4.

    A subarray like [1, 3] has sum 4 (even), so it is not counted.


    Constraints:

    1 <= arr.length <= 10^5
    1 <= arr[i] <= 1000

    Approach 1: Brute Force
    Time Complexity: O(n^3)
    Space Complexity: O(1)

    Approach 2: Better Brute Force
    Time Complexity: O(n^2)
    Space Complexity: O(1)

    Approach 3: Optimal using Prefix Sum Array
    Time Complexity: O(n)
    Space Complexity: O(n)

    Approach 4: Optimal using Constant Space
    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};

        System.out.println("Approach 1: " + numOfSubarraysApproach1(arr));
        System.out.println("Approach 2: " + numOfSubarraysApproach2(arr));
        System.out.println("Approach 3: " + numOfSubarraysApproach3(arr));
        System.out.println("Approach 4: " + numOfSubarraysApproach4(arr));
    }

    // Approach 1: Brute Force
    // T.C: O(n^3)
    // S.C: O(1)
    public static int numOfSubarraysApproach1(int[] arr) {
        int n = arr.length;
        long count = 0;
        int M = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                if (sum % 2 != 0) {
                    count++;
                }
            }
        }

        return (int) (count % M);
    }

    // Approach 2: Better Brute Force
    // T.C: O(n^2)
    // S.C: O(1)
    public static int numOfSubarraysApproach2(int[] arr) {
        int n = arr.length;
        int count = 0;
        int M = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum % 2 != 0) {
                    count = (count + 1) % M;
                }
            }
        }

        return count % M;
    }

    // Approach 3: Optimal using Prefix Sum Array
    // T.C: O(n)
    // S.C: O(n)
    public static int numOfSubarraysApproach3(int[] arr) {
        int n = arr.length;
        int M = (int) 1e9 + 7;

        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int count = 0;
        int odd = 0;
        int even = 1;

        for (int i = 0; i < n; i++) {
            if (prefix[i] % 2 == 0) {
                count = (count + odd) % M;
                even++;
            } else {
                count = (count + even) % M;
                odd++;
            }
        }

        return count;
    }

    // Approach 4: Optimal using Constant Space
    // T.C: O(n)
    // S.C: O(1)
    public static int numOfSubarraysApproach4(int[] arr) {
        int n = arr.length;
        int M = (int) 1e9 + 7;

        int count = 0;
        int odd = 0;
        int even = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum % 2 == 0) {
                count = (count + odd) % M;
                even++;
            } else {
                count = (count + even) % M;
                odd++;
            }
        }

        return count;
    }
}