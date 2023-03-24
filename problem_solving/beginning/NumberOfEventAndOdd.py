"""
[문제]
정수가 담긴 리스트 num_list가 주어질 때, 
num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

[제한사항]
1 ≤ num_list의 길이 ≤ 100
0 ≤ num_list의 원소 ≤ 1,000
"""


def solution(num_list):
    answer = []

    numberOfEven = 0
    numberOfOdd = 0

    for i in num_list:
        if (i % 2 == 0):
            numberOfEven += 1
        else:
            numberOfOdd += 1

    answer.append(numberOfEven)
    answer.append(numberOfOdd)

    return answer


'''
[다른 풀이법]
def solution(num_list):
    answer = [0,0]
    for n in num_list:
        # 짝수면 0, 홀수이면 1
        answer[n%2]+=1
    return answer
'''
