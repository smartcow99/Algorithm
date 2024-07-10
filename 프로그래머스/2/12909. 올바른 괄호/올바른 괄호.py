def solution(s):
    stk = []
    
    for ss in s:
        if ss == ')':
            if stk:
                stk.pop()
            else:
                return False
        else:
            stk.append(1)
    if stk:
        return False
    return True