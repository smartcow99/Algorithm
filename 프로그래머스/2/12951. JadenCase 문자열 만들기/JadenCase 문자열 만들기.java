class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.toLowerCase().split(" ", -1);

        for (String word : arr) {
            if (word.length() == 0) {
                sb.append(" ");
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1))
                  .append(" ");
            }
        }

        return sb.toString().substring(0, s.length());
    }
}
