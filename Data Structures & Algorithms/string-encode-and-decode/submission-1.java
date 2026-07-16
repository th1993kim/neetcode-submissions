class Solution {

    public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();

            for (String str : strs) {
                sb.append(str.length());
                sb.append(",");
                sb.append(str);
                sb.append(",");
            }

            return sb.toString();
        }

        public List<String> decode(String str) {
            List<String> answer = new ArrayList<>();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while(i < str.length()) {

                while(Character.isDigit(str.charAt(i))) {
                    sb.append(str.charAt(i));
                    i++;
                }
                int count = Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
                if (str.charAt(i) == ',') {
                    i++;
                }


                while(count > 0) {
                    sb.append(str.charAt(i));
                    i++;
                    count--;
                }
                if (str.charAt(i) == ',') {
                    i++;
                }
                answer.add(sb.toString());
                sb.delete(0, sb.length());
            }

            return answer;
        }
}
