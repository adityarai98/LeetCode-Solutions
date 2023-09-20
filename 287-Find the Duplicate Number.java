class Solution {
    public int findDuplicate(int[] nums) {
        //Use Floyd's circle finding algorithm
        int slow = nums[0] , fast = nums[0];
        /*Move two pointers slow and fast
        If they meet then circle exists
        In this problem circle exists because:
        there is one elements is present more than once*/
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        /*Initialize slow as 0 and move at constant speed their
        meeting point is the duplicate point*/ 
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}