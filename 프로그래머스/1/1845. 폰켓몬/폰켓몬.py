def solution(nums):
    half = len(nums) // 2
    ss = set(nums)
    ss = list(ss)
    if len(ss) >= half:
        return half
    return len(ss)