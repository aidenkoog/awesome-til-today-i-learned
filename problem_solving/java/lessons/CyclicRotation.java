/**
  배열을 총 K번 만큼 한칸씩 Shift.
 */

 class Solution {
    public int[] solution(int[] A, int K) {
        int aLength = A.length;
        if (aLength <= 0) {
            return A;
        }

        while(K >= 1) {
            int lastItem = A[aLength - 1];
            for (int i = aLength - 1; i >= 1; i--) {
                A[i] = A[i - 1];
            }
            A[0] = lastItem;
            K--;
        }
        return A;
    }
}