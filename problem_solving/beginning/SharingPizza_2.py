"""
[문제]
머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다. 
피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때, 
n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 
최소 몇 판을 시켜야 하는지를 return 하도록 구현하여라.

[제한사항]
1 ≤ n ≤ 100
"""

import math


def solution(n):
    if (n % 6 != 0):
        return getLcm(n, 6) / 6
    return n / 6


# 4, 6이 있다고 가정
# 4 * 6 => 24, 24 // 2 => 12 (필요한 피자 조각)
def getLcm(num1, num2):
    return (num1 * num2) // math.gcd(num1, num2)


'''
[다른 풀이]
import math

def solution(n):
    return (n * 6) // math.gcd(n, 6) / 6
'''
