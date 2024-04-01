def solution(s):
    answer = 0
    s = list(s)
    for _ in range(len(s)):
        stack = []
        for i in s:
            if not stack:
                stack.append(i)
            else:
                top = stack[-1]
                if top == '(' and i == ')':
                    stack.pop()
                elif top == '[' and i == ']':
                    stack.pop()
                elif top == '{' and i == '}':
                    stack.pop()
                else:
                    stack.append(i)
        if not stack:
            answer += 1
        s.append(s[0])
        s = s[1:]
    return answer