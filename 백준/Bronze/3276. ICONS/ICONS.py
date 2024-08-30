import math

N = int(input())

min_sum = N + 1
best_i, best_j = 1, N

for i in range(1, int(math.sqrt(N)) + 1):
    j = math.ceil(N / i)
    if i * j >= N:
        if i + j < min_sum:
            min_sum = i + j
            best_i, best_j = i, j
print(best_i, best_j)
