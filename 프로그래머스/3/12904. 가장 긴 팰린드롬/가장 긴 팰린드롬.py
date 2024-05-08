def check_palindrome(word):
    return word == word[::-1]

def solution(s):
    l = len(s)
    if l == 1:
        return 1
    if l == 2:
        if s[0] == s[1]:
            return 2
        return 1
    maxi = 2
    for i in range(3, l+1):
        for j in range(l-i+1):
            word = s[j:j+i]
            if check_palindrome(word):
                if len(word) > maxi:
                    maxi = len(word)
                    j = l-i+1
    return maxi