#include<vector>
#include <deque>

using namespace std;

int solution(vector<vector<int>> maps) {
    int n = maps.size();
    int m = maps[0].size();
    if(n == 1 && m == 1)
        return 1;
    vector<int> dx = {0, 0, 1, -1};
    vector<int> dy = {1, -1, 0, 0};
    
    deque<pair<int, int>> dq;

    dq.push_back(make_pair(0, 0));
    maps[0][0] = 0;
    bool visited = false;

    while(!dq.empty()) {
        pair<int, int> cur = dq.front();
        int cx = cur.first;
        int cy = cur.second;
        dq.pop_front();
        
        if(cx == n-1 && cy == m-1)
            visited = true;
        for(int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1)
                continue;
            if(maps[nx][ny] == 1) {
                maps[nx][ny] = maps[cx][cy] + 1;
                dq.push_back(make_pair(nx, ny));
            }
        }
    }

    return (maps[n - 1][m - 1] == 1 && !visited) ? -1 : maps[n - 1][m - 1] + 1;
}
