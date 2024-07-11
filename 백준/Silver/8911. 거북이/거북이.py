import sys
input = sys.stdin.readline

T = int(input())

# 각 방향에 대한 움직임 정의 (북, 동, 남, 서)
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

for _ in range(T):
    x, y = 0, 0
    direction_index = 0  # 초기 방향은 북쪽
    way = list(input().strip())
    
    left, right, top, bottom = 0, 0, 0, 0
    
    for w in way:
        if w == 'F':
            x += directions[direction_index][0]
            y += directions[direction_index][1]
        elif w == 'B':
            x -= directions[direction_index][0]
            y -= directions[direction_index][1]
        elif w == 'L':
            direction_index = (direction_index - 1) % 4
        elif w == 'R':
            direction_index = (direction_index + 1) % 4
        
        left = min(left, x)
        right = max(right, x)
        top = max(top, y)
        bottom = min(bottom, y)
    
    width = right - left
    height = top - bottom
    print(width * height)
