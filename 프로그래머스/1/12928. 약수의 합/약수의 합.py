def solution(n):
    measure = []
    i = 1
    while i ** 2 <= n:
        if n % i == 0:
            measure.append(i)
            if n / i != i and n/i not in measure:
                measure.append(round(n/i))
        i += 1
    # print(measure)
    return sum(measure)