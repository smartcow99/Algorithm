#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 1;
    while(n > 2) {
        a = (a + 1) / 2;
        b = (b + 1) / 2;
        if(a == b)
            return answer;
        answer++;
        n /= 2;
    }
    return answer;
}