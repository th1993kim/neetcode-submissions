class Solution {
    public int[] countBits(int n) {
        
        int[] answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int number = i;
            while(number > 0) {
                number = number&(number - 1);
                count++;
            }

            answer[i] = count;
        }

        return answer;
    }
}
