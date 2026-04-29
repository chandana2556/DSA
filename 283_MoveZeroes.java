283_MoveZeroes
Brute Force Approach
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
            result[j]=nums[i];
            j++;
            }
        }
        for(int i=0;i<n;i++){
            nums[i]=result[i];
        }
    }
}

Two Pointers using Swap 
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }
        }
    }
}

Optimal Approach 
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                if(i!=j){
                    nums[j]=nums[i];
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}
