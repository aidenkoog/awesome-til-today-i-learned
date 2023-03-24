"""
[문제]
정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.

[제한사항]
0 < n ≤ 1000
"""


def solution(n):
    sumOfEvenNumbers = 0
    for i in range(n + 1):
        if (i % 2 == 0):
            sumOfEvenNumbers += i
    return sumOfEvenNumbers


'''
[다른 풀이법]

def solution(n):
    return sum([i for i in range(2, n + 1, 2)])
'''
