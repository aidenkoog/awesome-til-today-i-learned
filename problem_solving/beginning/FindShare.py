"""
[문제]
정수 num1과 num2가 주어질 때, num1을 num2로 나눈 몫을 return 하도록
함수를 완성해보아라.

[제한사항]
- 0 <= num1 <= 100
- 0 <= num2 <= 100
"""

import math


def solution(num1, num2):
    answer = math.trunc(num1 / num2)
    # answer = math.floor(num1 / num2)
    # answer = num1 // num2
    return answer
