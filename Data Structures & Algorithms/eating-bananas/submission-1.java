class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int rt = 0;
        int lt = 1;
        int answer = Integer.MAX_VALUE;
        for (int pile : piles) {
            rt = Math.max(pile, rt);
        }

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int sum = 0;
            for (int pile : piles) {
                sum += pile / mid;
                if (pile % mid > 0) sum++;
            }

            if (sum > h) {
                lt = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                rt = mid - 1;
            }
        }
        return answer;
    }
}
