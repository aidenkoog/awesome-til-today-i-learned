"""
[문제]
머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다. 
머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때, 
머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.

[제한사항]
1 ≤ array의 길이 ≤ 100
1 ≤ height ≤ 200
1 ≤ array의 원소 ≤ 200
"""


def solution(array, height):
    array.sort()
    if height > array[len(array) - 1]:
        return 0

    tallPeopleCount = 0
    for i in array:
        if height < i:
            if i == 0:
                tallPeopleCount = len(array) - 1
                break
            tallPeopleCount += 1

    return tallPeopleCount


'''
[다른 풀이법 - 1]
# 문제를 잘 읽어야 한다.
# array 에는 다른 사람들의 키 정보만 들어 있고 나의 키 정보는 없으므로 나의 키 정보를 추가한 다음에
# 내림차순으로 정렬 후 나의 인덱스를 반환한다.
def solution(array, height):
    array.append(height)
    array.sort(reverse=True)
    return array.index(height)
'''
