def solution(s):
    s = s.replace("}", "").replace("{", "").split(',')
    ss = list(set(s))
    ans = []
    for sss in ss:
        ans.append([int(sss), s.count(sss)])
    ans.sort(reverse = True, key = lambda x: x[1])
    result = []
    for a in ans:
        result.append(a[0])
    return result