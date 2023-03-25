"""
[문제]
정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때, 
array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요

[제한사항]
1 ≤ array의 길이 ≤ 100
0 ≤ array의 원소 ≤ 1,000
0 ≤ n ≤ 1,000

"""


def solution(array, n):
    duplicatedNumberCount = 0
    for i in array:
        if i == n:
            duplicatedNumberCount += 1
    return duplicatedNumberCount


'''
[다른 풀이법]
def solution(array, n):
    return array.count(n)
'''
