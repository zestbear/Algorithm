class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 1;
        int right = 200000000;
        while(left<=right) {
            int mid = (left + right) / 2;
            if(check(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public static boolean check(int[] stones, int k, int mid) {
        int count = 0;
        for(int i=0;i<stones.length;i++) {
            if(stones[i]-mid < 0) {
                count++;
                if(count >= k) return false;
            }
            else count = 0;
        }
        
        return true;
    }
}