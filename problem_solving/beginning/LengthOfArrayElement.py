"""
[문제]
문자열 배열 strlist가 매개변수로 주어집니다. 
strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.

[제한사항]
1 ≤ strlist 원소의 길이 ≤ 100
strlist는 알파벳 소문자, 대문자, 특수문자로 구성되어 있습니다.
"""


def solution(strlist):
    answer = []
    for i in strlist:
        answer.append(len(i))
    return answer


'''
[다른 풀이법]

def solution(strlist):
    answer = list(map(len, strlist))
    return answer
'''
