/**
  Ex. 529(10001000001)가 주어질 때 1과 1 사이의 0의 최대 개수를 구하여라.
  Answer: 3, 5 중 5가 정답
 */

 class Solution {
    public int solution(int number) {
        int result = 0;

        // int형 값을 바이너리 스트링으로 변환
        String binaryString = Integer.toBinaryString(number);

        // 스트링 내 특정 문자의 개수를 반환
        long delimeterCount = binaryString.chars().filter(c -> c == '1').count();

        // 1의 개수가 한개 이하면 0을 반환
        if (delimeterCount <= 1) {
            return result;
        }

        // 1을 기준으로 데이터를 분리하여 배열로 저장
        // 예. "110" => " 1 1 0" => ['', '', 0]
        // 예. "1101" => " 1 1 0" => ['', '', 0]
        String[] splitString = binaryString.split("1");

        // 분리된 배열 사이즈만큼 반복
        for(int i = 0; i < splitString.length; i++) {
            // 분리된 배열 아이템의 개수, 즉, 0의 개수를 저장
            int itemLength = splitString[i].length();

            // 첫 루프 동작 시에는 반환된 배열 아이템의 개수를 결과 변수에 바로 저장
            if (i == 0) {
                result = itemLength;
            }
            // 두번째 루프 동작부터는 저장된 결과 변수값과 현재 아이템 개수를 비교 후 저장된 값보다 현재값이 크면 아래 코드 수행
            if (result >= itemLength) {
                continue;
            }
            // 마지막 배열 아이템이고 바이너리 스트링의 맨마지막 문자가 0이면 스킵
            if ((i == splitString.length - 1 
                && "0".equals(binaryString.substring(binaryString.length() - 1)))) {
                continue;
            }
            // 현재 아이템 값이 저장된 값보다 큰 상태이므로 결과값을 갱신
            result = itemLength;
        }
        return result;
    }
}