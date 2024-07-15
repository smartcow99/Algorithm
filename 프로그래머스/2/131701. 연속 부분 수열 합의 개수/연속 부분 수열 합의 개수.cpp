#include <vector>
#include <unordered_set>

using namespace std;

int solution(vector<int> elements) {
    int n = elements.size();
    unordered_set<int> sums;

    vector<int> ext(elements.begin(), elements.end());
    ext.insert(ext.end(), elements.begin(), elements.end());

    for (int length = 1; length <= n; ++length) {
        for (int start = 0; start < n; ++start) {
            int sum = 0;
            for (int i = 0; i < length; ++i) {
                sum += ext[start + i];
            }
            sums.insert(sum);
        }
    }

    return sums.size();
}
