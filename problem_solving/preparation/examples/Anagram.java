
/**
 * 두 문자열이 주어졌을 때 두 단어가 서로 애너그램 관계에 있도록
 * 만들기 위해서 제거해야 하는 최소 문자의 개수
 * 애너그램: 단어의 구성(알파벳과 그 개수)이 완전히 같은 단어
 * 
 * 1. 두 단어 중 길이가 작은 단어가 무엇인지 구한다.
 * 2. 길이가 작은 단어의 길이만큼 루프를 돈다
 * 3. 첫번째 문자가 현재 내가 몇개 들고 있는지 구한다.
 * 4. ...
 * 
 * [접근법]
 * 1. 두 단어들의 캐릭터들을 펼친다.
 * 2. 각 캐릭터들의 카운트를 파악
 * 3. 두 단어 간의 각 캐릭터들의 카운트를 파악 후 삭제 카운트
 * 를 증가시킨다.
 */

import java.util.Scanner;

public class Anagram {

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        // 카운트 배열
        int[] countA = getAlphabetCount(a);
        int[] countB = getAlphabetCount(b);

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(countA[i] - countB[i]);
        }
        System.out.println(answer);
    }
}
