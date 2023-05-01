
/**
 * 알파벳으로만 이루어진 문자열에서 소문자는 대문자로
 * 대문자는 소문자로 변경하여 출력
 * (2744)
 * 
 * 접근 순서
 * 1. 문자열에서 각각의 문자들을 어떻게 추출하여 다룰 수 있는가?
 * 2. 대문자인지 소문자인지 어떻게 판단하는가?
 * 3. 대문자, 소문자로 변경은 어떻게 하는가?
 */

import java.util.Scanner;

public class ChangeUpperLowerCases {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 매번 스트링 인스턴스 생성되는 것을 방지하기 위해
        // str.toCharArray() 를 사용
        char[] answerArray = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                answerArray[i] = ((char) ('a' + ch - 'A'));
            } else {
                answerArray[i] = ((char) ('A' + ch - 'a'));
            }
        }
        System.out.println(answerArray);
    }
}
