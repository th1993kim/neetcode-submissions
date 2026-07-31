class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int answer = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int index = 0;
        int currentStart = intervals[index][0];
        int currentEnd = intervals[index][1];
        index++;
        while (index < intervals.length) {
            int nextStart = intervals[index][0]; 
            int nextEnd = intervals[index][1];

            if (nextStart < currentEnd) {
                answer++;
            } else {
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
            index++;
        }

        return answer;
    }
}
