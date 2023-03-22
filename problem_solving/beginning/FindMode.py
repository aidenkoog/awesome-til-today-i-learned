"""
[문제]
최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 
정수 배열 array가 매개변수로 주어질 때, 
최빈값을 return 하도록 구현하여라. 최빈값이 여러 개면 -1을 return 합니다.

[제한사항]
0 < array의 길이 < 100
0 ≤ array의 원소 < 1000

[입출력 예]
array	                result
[1, 2, 3, 3, 3, 4]	    3
[1, 1, 2, 2]	        -1
[1]	                    1
"""


from collections import Counter

def solution(array):
    
    counter = Counter(array)
    most = counter.most_common()
    maxCount = most[0][1]
    modeList = []
    
    for item in most:
        if item[1] == maxCount:
            modeList.append(item[0])
    
    if len(modeList) > 1:
        return -1
    
    return modeList[0]