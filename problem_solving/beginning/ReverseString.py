"""
[문제]
문자열 my_string이 매개변수로 주어집니다. 
my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.

[제한사항]
1 ≤ my_string의 길이 ≤ 1,000
"""


def solution(myString):
    # 문자열 => 리스트로 변환
    myStringList = list(myString)

    # 리스트 역순 처리
    myStringList.reverse()

    # 리스트 => 문자열로 변환
    return ''.join(myStringList)


'''
[다른 풀이법 - 1]
def solution(my_string):
    return my_string[::-1]
'''

'''
[다른 풀이법 - 2]
def solution(my_string):
    return ''.join(list(reversed(my_string)))
'''

'''
[다른 풀이법 - 3]
def solution(my_string):
    reverse_name = ''
    for c in my_string:
        reverse_name = c + reverse_name
    return reverse_name
'''
