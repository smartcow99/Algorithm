def solution(routes):
    routes.sort(key = lambda x: x[1])
    cmr = routes[0][1]
    cnt = 1
    for r in routes:
        if cmr < r[0]:
            cmr = r[1]
            cnt += 1
    return cnt