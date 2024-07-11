import sys
input = sys.stdin.readline

# 입력 받기
n = int(input())
arr = list(map(int, input().split()))

# 좌표 압축을 위해 정렬된 리스트를 만들고 중복 제거
sorted_arr = sorted(set(arr))

# 압축된 좌표 값을 저장할 딕셔너리
coord_dict = {value: index for index, value in enumerate(sorted_arr)}

# 결과 리스트
result = [coord_dict[value] for value in arr]

# 결과 출력
print(' '.join(map(str, result)))
