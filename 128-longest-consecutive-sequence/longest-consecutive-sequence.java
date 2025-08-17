class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int maxStreak = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int currStreak = 1;
                int currNum = num;
                while(set.contains(currNum+1)){
                    currStreak++;
                    currNum++;
                }
                 maxStreak = Math.max(maxStreak , currStreak);
            }
        }
        return maxStreak;
    }
}