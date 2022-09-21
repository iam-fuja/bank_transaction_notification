import java.util.Arrays;

public class PossibleFraudulentActivity {
    public static void main(String[] args) {
        int[] nDays = new int[]{9, 5};
        int[] expenditures = new int[]{2, 3, 3, 2, 3, 6, 8, 4, 5};
        numberOfNotifications(nDays, expenditures);
    }

    public static void numberOfNotifications(int[] nDays, int[] expenditures) {
        int notifications = 0;
        int requiredDaysForMedian = nDays[1];
            for (int i = requiredDaysForMedian; i < expenditures.length; i++) {
                int median;
                int[] prevNDays = Arrays.copyOfRange(expenditures, i-requiredDaysForMedian, i);
                Arrays.sort(prevNDays);
                if (requiredDaysForMedian % 2 != 0) {
                    // odd
                    median = prevNDays[requiredDaysForMedian/2];
                } else {
                    // even
                    median = (prevNDays[requiredDaysForMedian/2] + prevNDays[(requiredDaysForMedian/2) - 1]) / 2;
                }
                if (expenditures[i] >= (2 * median)) {
                    notifications++;
                }
            }
        System.out.println(notifications);
    }
}