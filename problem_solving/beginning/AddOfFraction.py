'''
[문제]
첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 
두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어진다.
두 분수를 더한 값을 기약 분수로 나타냈을 때 
분자와 분모를 순서대로 담은 배열을 return 하도록 구현하여라.

[제한사항]
0 <numer1, denom1, numer2, denom2 < 1,000

[입출력 예]
1 / 2 + 3 / 4 = 5 / 4입니다. 따라서 [5, 4]를 return
'''


def solution(numer1, denom1, numer2, denom2):
    answer = []

    if denom1 == denom2:
        numer = numer1 + numer2
        denom = denom1
    else:
        denom = denom1 * denom2
        numer = numer1 * denom2 + numer2 * denom1

    gcd = getGcd(numer, denom)

    # answer[numer / gcd, denom / gcd]
    answer.append(numer / gcd)
    answer.append(denom / gcd)

    return answer


def getGcd(number1, number2):
    for i in range(1, number1 + 1):
        '''
          기본적인 and, or, shift 등의 연산은 비트 연산보다 상대적으로 느리다.
          if (number1 % i == 0) and (number2 % i == 0):
          참고.
            몫 구하는 산술연산자: //
            Ex. 10 // 3 = 3
            나머지 구하는 산술연산자: %
            Ex. 10 % 3 = 1
        '''
        if (number1 % i == 0) & (number2 % i == 0):
            gcd = i
    return gcd


'''
[다른 풀이]
import math

def solution(denum1, num1, denum2, num2):
    # 분모가 같은지 여부 상관없이 일단 무조건 분모를 같게 만들기 위해 서로의 분모를 곱한다.
    denum = denum1 * num2 + denum2 * num1
    num = num1 * num2

    # math 라이브러리의 gcd 함수 활용
    gcd = math.gcd(denum, num)

    # // 연산자 활용해서 몫을 구하고 배열에 삽입
    return [denum//gcd, num//gcd]
'''
