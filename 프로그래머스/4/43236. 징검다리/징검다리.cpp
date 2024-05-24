#include <string>
#include <vector>
#include <algorithm>
#include <deque>

using namespace std;

bool check(vector<int>& rocks, int n, int mini, int dist) {
    int cur = 0;
    int cnt = 0;
    
    for(int rock : rocks) {
        if(rock - cur < mini) {
            cnt++;
            if(cnt > n) {
                return false;
            }
        }
        else {
            cur = rock;
        }
    }
    if(dist - cur < mini) {
        cnt++;
    }
    return cnt <= n;
}

int solution(int distance, vector<int> rocks, int n) {
    sort(rocks.begin(), rocks.end());
    int left = 1;
    int right = distance;
    int answer = 0;
    
    while(left <= right) {
        int mid = (left + right) / 2;
        if(check(rocks, n, mid, distance)) {
            answer = mid;
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    return answer;
}