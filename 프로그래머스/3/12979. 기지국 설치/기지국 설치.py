# def solution(n, stations, w):
#     wifi = [0] * (n+1)
#     num = 0
    
#     # 기존 기지국 범위 체크
#     for s in stations:
#         for i in range(s-w, s+w+1):
#             if i < 1:
#                 i = 1
#             if i > n:
#                 break
#             if not wifi[i]:
#                 wifi[i] = 1
    
#     # 배열 돌면서 기지국 세우기
#     for i in range(1, n+1):
#         if not wifi[i]:
#             num += 1
#             for x in range(i, i+w*2+1):
#                 if x > n:
#                     break
#                 if not wifi[x]:
#                     wifi[x] = 1
#             i = i+w*2
#         else:
#             i = i+w-1
#     return num

def solution(n, stations, w):
    r = w*2+1
    s = 1
    e = 0
    ans = 0
    for st in stations:
        e = st - w - s
        if not st - w <= s:
            ans += e // r
            if e % r != 0 :
                ans += 1
        s = st + w + 1
    if s <= n:
        e = n + 1 - s
        ans += e // r
        if e % r != 0:
            ans += 1
    return ans