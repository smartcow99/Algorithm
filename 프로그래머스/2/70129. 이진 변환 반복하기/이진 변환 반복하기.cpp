#include <string>
#include <vector>
#include <queue>
#include <bitset>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer = {0, 0};

    while (s != "1") {
        int count = 0;
        for (char c : s) {
            if (c == '0') {
                answer[1]++;
            } else {
                count++;
            }
        }
        s = bitset<64>(count).to_string();
        s = s.substr(s.find('1'));
        answer[0]++;
    }

    return answer;
}