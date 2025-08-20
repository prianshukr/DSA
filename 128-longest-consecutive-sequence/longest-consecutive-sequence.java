class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int maxLen = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int curr = num;
                int count = 1;
                int next = curr+1;
                while(set.contains(next)){
                    count++;
                    next++;
                }
                maxLen= Math.max(maxLen , count);
            }
        }
        return maxLen;
    }
}