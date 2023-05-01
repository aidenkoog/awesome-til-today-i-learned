import java.util.Scanner;

/**
 * 1. 각 알파벳의 개수를 구한다.
 * 2. 그 중 최댓값을 구한다.
 */
public class GetMaxAlphabetCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'A']++;

        /////////////////////////////////////////////////////
        // 기존 구현 코드
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < count.length; i++) {
            if (i == 0) {
                max = count[0];
                continue;
            }
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }

        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                maxCount++;
            }
        }
        if (maxCount > 1) {
            System.out.println("?");
        } else if (maxCount == 1) {
            System.out.println((char) ('A' + maxIndex));
        }

        /////////////////////////////////////////////////////////
        // 효율적인 방법으로 수정

        maxCount = -1;
        char maxAlphabet = '?';

        // 최대 개수의 알파벳 위치를 저장하는 것이 아닌
        // 실제 알파벳을 바로 지정하는 방식
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlphabet = (char) ('A' + i);
            } else if (count[i] == maxCount) {
                maxAlphabet = '?';
            }
        }
        System.out.println(maxAlphabet);
    }
}
