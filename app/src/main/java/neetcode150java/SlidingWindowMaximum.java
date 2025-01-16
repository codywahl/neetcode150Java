package neetcode150java;

import java.util.Deque;

/**
 * Sliding Window Maximum
 * LeetCode 239
 * 
 * You are given an array of integers nums and an integer k. There is a sliding
 * window of size k that starts at the left edge of the array. The window slides
 * one position to the right until it reaches the right edge of the array.
 * 
 * Return a list that contains the maximum element in the window at each step.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,1,0,4,2,6], k = 3
 * 
 * Output: [2,2,4,4,6]
 * 
 * Explanation:
 * Window position Max
 * --------------- -----
 * [1 2 1] 0 4 2 6 2
 * 1 [2 1 0] 4 2 6 2
 * 1 2 [1 0 4] 2 6 4
 * 1 2 1 [0 4 2] 6 4
 * 1 2 1 0 [4 2 6] 6
 * Constraints:
 * 
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * 1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new java.util.LinkedList<>();
        int leftPointer = 0;
        int rightPointer = 0;

        while (rightPointer < nums.length) {
            // remove values from the deque that are smaller than the current value
            while (!deque.isEmpty() && nums[rightPointer] > nums[deque.peekLast()]) {
                // pollLast removes the last element
                deque.pollLast();
            }

            deque.addLast(rightPointer);

            if (leftPointer > deque.getFirst()) {
                deque.pollFirst();
            }

            if ((rightPointer + 1) >= k) {
                result[leftPointer] = (nums[deque.getFirst()]);
                leftPointer++;

            }

            rightPointer++;
        }

        return result;
    }
}