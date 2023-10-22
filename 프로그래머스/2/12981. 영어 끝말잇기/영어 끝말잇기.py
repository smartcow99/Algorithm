def solution(n, words):
    stack = [words[0]]
    for i in range(1, len(words)):
        if words[i] not in stack:
            if words[i-1][-1] != words[i][0]:
                return [i % n + 1, i // n + 1]
            else:
                stack.append(words[i])
        else:
            return [i % n + 1, i // n + 1]
    return [0, 0]