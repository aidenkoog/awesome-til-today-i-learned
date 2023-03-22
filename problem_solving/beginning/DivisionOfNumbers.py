"""
[문제]
정수 num1과 num2가 매개변수로 주어질 때, 
num1을 num2로 나눈 값에 1,000을 곱한 후 
정수 부분을 return 하도록 구현하여라.

[제한사항]
0 < num1 ≤ 100
0 < num2 ≤ 100
"""

import math


def solution(num1, num2):
    answer = math.trunc(num1 / num2 * 1000)
    return answer
