class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] courseRemain = new int[numCourses];
        List<Integer>[] subCourses = new ArrayList[numCourses];
        
        for (int i = 0; i < subCourses.length; i++) {
            subCourses[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            courseRemain[course]++;
            subCourses[pre].add(course);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < courseRemain.length; i++) {
            if (courseRemain[i] == 0) queue.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            int course = queue.poll();
            answer.add(course);

            List<Integer> subList = subCourses[course];
            for (Integer sub : subList) {
                courseRemain[sub]--;
                if (courseRemain[sub] == 0) {
                    queue.offer(sub);
                }
            }
        }


        return answer.size() == numCourses ? answer.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
