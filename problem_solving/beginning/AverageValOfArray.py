"""
[문제]
정수 배열 numbers가 매개변수로 주어집니다. 
numbers의 원소의 평균값을 return하도록 구현하여라.

[제한사항]
0 ≤ numbers의 원소 ≤ 1,000
1 ≤ numbers의 길이 ≤ 100
정답의 소수 부분이 .0 또는 .5인 경우만 입력으로 주어집니다.
"""


def solution(numbers):
    sumOfElements = 0
    for number in numbers:
        sumOfElements += number
    return sumOfElements / len(numbers)
