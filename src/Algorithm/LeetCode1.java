package Algorithm;

/*
leetcode 161 Find distance 1 between words
Note: find most simple common factor while conducting the algorithm
 */
public class LeetCode1 {
    public static boolean isoneDistance(String firstString, String SecondString) {
        int fLength = firstString.length();
        int sLength = SecondString.length();
        if ((fLength - sLength) >= 2) {
            return false;
        } else {
            int differemt = 0;
            for (int i = 0; i < firstString.length(); i++) {
                if (firstString.charAt(i) != SecondString.charAt(i)) {
                    differemt = i;
                    break;
                }

            }

            int count = 0;
            for (int j = differemt+1; j < firstString.length(); j++) {
                if (firstString.charAt(j) != SecondString.charAt(j)) {
                    if (differemt != 0)
                        count = 1;
                }

            }
            if (count == 1)
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        String a = "abdccb";
        String b = "abdaca";
       boolean c= LeetCode1.isoneDistance(a, b);
       System.out.println(c);
    }
}

