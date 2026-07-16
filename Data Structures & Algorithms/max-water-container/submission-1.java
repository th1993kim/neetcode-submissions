class Solution {
     public int maxArea(int[] heights) {
            int lt = 0;
            int rt = heights.length - 1;
            int answer = 0;
            while (lt < rt) {
                int area = Math.min(heights[lt], heights[rt]) * (rt - lt);
                answer = Math.max(answer, area);

                if (heights[lt] > heights[rt]) {
                    rt--;
                } else {
                    lt++;
                }
            }

            return answer;
        }
}
