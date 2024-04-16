def solution(participant, completion):
    participant.sort()
    completion.sort()
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
    return participant[-1]
#     # 참가자 1인 경우
#     if not completion:
#         return participant[0]
    
#     # set으로 차집합 연산
#     dif = list(set(participant) - set(completion))
#     if dif: # 차집합이 존재한다면 출력
#         return dif[0]
    
#     # 차집합이 존재하지 않는다면 참가자 중 중복인 값 출력
#     check = set()
#     ans = set()
#     for p in participant:
#         if p not in check:
#             check.add(p)
#         else:
#             return p
