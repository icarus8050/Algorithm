public class MakeBiggestNumber {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        while (k-- > 0) {
            int size = sb.length();

            for (int i = 0; i < size - 1; i++) {
                if (sb.charAt(i + 1) > sb.charAt(i)) {
                    sb.deleteCharAt(i);
                    break;
                }
                if (i == size - 2)
                    sb.deleteCharAt(size - 1);
            }
        }

        return sb.toString();
    }
}
