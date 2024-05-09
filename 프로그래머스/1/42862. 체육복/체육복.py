def solution(n, lost, reserve):
    c = [1 for _ in range(n)]  # 학생들의 체육복 상태를 나타내는 리스트 생성
    for r in reserve:
        c[r-1] += 1  # 여분의 체육복이 있는 학생의 체육복 개수 1 증가
    for l in lost:
        c[l-1] -= 1  # 체육복을 잃어버린 학생의 체육복 개수 1 감소
    for i in range(n):
        if c[i] == 0:  # 체육복이 없는 학생인 경우
            if i > 0 and c[i-1] == 2:  # 왼쪽 학생이 여분의 체육복이 있는 경우
                c[i] = 1
                c[i-1] = 1
            elif i < n-1 and c[i+1] == 2:  # 오른쪽 학생이 여분의 체육복이 있는 경우
                c[i] = 1
                c[i+1] = 1
    answer = sum(1 for x in c if x > 0)  # 체육 수업을 들을 수 있는 학생 수 계산
    return answer
