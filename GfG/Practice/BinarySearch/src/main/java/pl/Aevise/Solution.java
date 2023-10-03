package main.java.pl.Aevise;

//Given a sorted array of size N and an integer K, find the position(0-based indexing)
// at which K is present in the array using binary search.
//Example 1:
//Input :N = 5 arr[] = {1 2 3 4 5} K = 4
//Output: 3
//Explanation: 4 appears at index 3.

//Example 2:
//Input: N = 5 arr[] = {11 22 33 44 55} K = 445
//Output: -1
//Explanation: 445 is not present.
//
//Your Task:
//You dont need to read input or print anything. Complete the function binarysearch()
// which takes arr[], N and K as input parameters and returns the index of K in the array.
// If K is not present in the array, return -1.
//Expected Time Complexity: O(LogN)
//Expected Auxiliary Space: O(LogN) if solving recursively and O(1) otherwise.
//
public class Solution {
    public static void main(String[] args) {
        Solution test = new Solution();
        test.binarySearch(new int[]{1, 2, 3, 4, 5}, 5, 4);

    }
    public int binarySearch(int[] arr, int n, int k) {
        int leftIndex = 0;
        int rightIndex = n - 1;
        while(leftIndex <= rightIndex){
            int index = (leftIndex + rightIndex) / 2;
            int number = arr[index];
            if(number < k){
                leftIndex = index + 1;
            } else if (number > k) {
                rightIndex = index - 1;
            }
            else {
                return index;
            }
        }
        return -1;
    }
}
