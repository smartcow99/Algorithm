#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int ans = 0;
    sort(citations.rbegin(), citations.rend());
    for(int i=0; i<citations.size(); i++) {
        if(i+1 <= citations[i])
            ans++;
    }
    return ans;
}