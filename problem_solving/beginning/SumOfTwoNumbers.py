"""
[문제]
정수 num1과 num2가 주어질 때, num1과 num2의 합을 return하도록 구현

[제한사항]
- -50,000 <= num1 <= 50,000
- -50,000 <= num2 <= 50,000
"""

MIN_VALUE = -50000
MAX_VALUE = 50000


def solution(num1, num2):
    answer = -1

    if num1 < MIN_VALUE or num1 > MAX_VALUE:
        return -1
    if num2 < MIN_VALUE or num2 > MAX_VALUE:
        return -1

    answer = num1 + num2
    return answer
