#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> result(2, 0);
    vector<string> said;
    said.push_back(words[0]);

    for (int i = 1; i < words.size(); i++) {
        if (words[i][0] != words[i-1].back() || find(said.begin(), said.end(), words[i]) != said.end()) {
            result[0] = (i % n) + 1;
            result[1] = (i / n) + 1;
            return result;
        }
        said.push_back(words[i]);
    }
    
    return result;
}