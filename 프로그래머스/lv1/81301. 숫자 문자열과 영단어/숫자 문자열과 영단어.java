class Solution {
    public int solution(String s) {
        String ans = "";
        String tmp = "";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                tmp += s.charAt(i);
                if(tmp.equals("one")) {
                    ans += '1';
                    tmp = "";
                }
                else if(tmp.equals("two")) {
                    ans += '2';
                    tmp = "";
                }
                else if(tmp.equals("three")) {
                    ans += '3';
                    tmp = "";
                }
                else if(tmp.equals("four")) {
                    ans += '4';
                    tmp = "";
                }
                else if(tmp.equals("five")) {
                    ans += '5';
                    tmp = "";
                }
                else if(tmp.equals("six")) {
                    ans += '6';
                    tmp = "";
                }
                else if(tmp.equals("seven")) {
                    ans += '7';
                    tmp = "";
                }
                else if(tmp.equals("eight")) {
                    ans += '8';
                    tmp = "";
                }
                else if(tmp.equals("nine")) {
                    ans += '9';
                    tmp = "";
                }
                else if(tmp.equals("zero")) {
                    ans += '0';
                    tmp = "";
                }
                else
                    continue;
            }
            else {
                ans += "" + s.charAt(i);
            }
        }
        int answer = Integer.parseInt(ans);
        return answer;
    }
}