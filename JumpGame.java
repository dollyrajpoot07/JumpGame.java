// Given an array arr[] where each element represents the max number of steps that can be made 
// forward from that index. The task is to find the minimum number of jumps to reach the end of 
// the array starting from index 0. If the end isn’t reachable, return -1.

// Examples: 

// Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
// Output: 3 (1-> 3 -> 9 -> 9)
// Explanation: Jump from 1st element to 2nd element as there is only 1 step.
// Now there are three options 5, 8 or 9. I
// f 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.

// Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
// Output: 10
// Explanation: In every step a jump is needed so the count of jumps is 10.

public class JumpGame {

    static int minJumps(int arr[], int l, int h) {

        if (h == l)
            return 0;

        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumps(arr, i, h);
            if (jumps != Integer.MAX_VALUE
                    && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int n = arr.length;
        System.out.print(
                "Minimum number of jumps to reach end is "
                        + minJumps(arr, 0, n - 1));
    }
}
