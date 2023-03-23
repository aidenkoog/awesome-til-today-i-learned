"""
[문제]
머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다. 
피자를 나눠먹을 사람의 수 n이 주어질 때, 
모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 
return 하도록 구현하여라.

[제한사항]
1 ≤ n ≤ 100
"""


def solution(n):
    if n <= 7:
        return 1

    share = n // 7
    reminder = n % 7

    if reminder == 0:
        return share
    return share + 1


'''
[Another Answer]
def solution(n):
    return (n - 1) // 7 + 1
'''
