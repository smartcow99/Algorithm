#include <string>
#include <vector>
#include <iostream>
#include <cctype>

using namespace std;

string solution(string s) {
    bool capitalize = true;
    for (int i = 0; i < s.size(); i++) {
        if (isspace(s[i])) {
            capitalize = true;
        } else {
            if (capitalize) {
                s[i] = toupper(s[i]);
                capitalize = false;
            } else {
                s[i] = tolower(s[i]);
            }
        }
    }
    return s;
}
