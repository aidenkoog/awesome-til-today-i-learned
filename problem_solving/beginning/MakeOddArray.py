"""
[문제]
정수 n이 매개변수로 주어질 때, 
n 이하의 홀수가 오름차순으로 담긴 배열을 
return하도록 구현하여라.

[제한사항]
1 ≤ n ≤ 100
"""


def solution(n):
    answer = []
    # n이 5이라 가정하면, 실제 인덱스값은 0, 1, 2, 3, 4 까지 들어온다.
    for i in range(n):
        if (i + 1) % 2 != 0:
            answer.append(i + 1)
    answer.sort()
    return answer
