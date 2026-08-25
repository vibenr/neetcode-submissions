class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0; 
        for(int num : nums){
            xor ^= num; 
        }

        int diff_bit = 1; 
        // left shift to get most right bit set
        while((xor & diff_bit) == 0){
            diff_bit <<= 1; 
        }

        int a = 0, b = 0; 
        for(int num: nums){
            if((num & diff_bit) != 0){
                a^= num; 
            }
            else {
                b^= num; 
            }
        }

        return new int[] {a, b}; 
    }
}