class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1, zeroCount = 0;
        boolean hasZero = false, allZeros = true;

        for (int num : nums) {
            if (num == 0) {
                hasZero = true;
                zeroCount++;
            } else {
                allZeros = false;
                product *= num;
            }
        }
        
        if (allZeros) {
            return nums;
        }

        for (int i = 0; i < answer.length; i++) {
            if (nums[i] == 0 && zeroCount == 1) {
                answer[i] = product;
            } else if (hasZero) {
                answer[i] = 0;
            } else {
                answer[i] = product / nums[i];
            }
        }

        return answer;
    }
}