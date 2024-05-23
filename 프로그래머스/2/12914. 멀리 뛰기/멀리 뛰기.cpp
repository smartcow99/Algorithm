#include <string>
#include <vector>

using namespace std;

long long solution(int n) {
    long long answer = 0;
    vector<long long> v;
    v.push_back(0);
    v.push_back(1);
    v.push_back(2);
    for(int i=3; i<=n; i++)
        v.push_back((v[i-1] + v[i-2]) % 1234567);
    return v[n];
}


/*
1
11 2
111 21 12
1111 112 121 211 22
11111 1112 1121 1211 2111 122 212 221
1, 2, 3, 5, 8


*/