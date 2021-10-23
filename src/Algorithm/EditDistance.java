package Algorithm;
 * The given code is provided to assist you to complete the required tasks. But the
 * given code is often incomplete. You have to read and understand the given code
 * carefully, before you can apply the code properly.
 */


/*
 * Please review Lecture 7 Algorithms Part III, slides 10-14 to complete this task.
 * */

/*
* EditCost defines three character edit costs. INSERT and DELETE will cost 1, and REPLACE will cost 2.
* Do not modify the character edit costs. Otherwise, your answers will not be marked correctly.
* */
enum EditCost
{
    INSERT (1),
    DELETE (1),
    REPLACE (2);

    private final int costValue;

    EditCost(int value) {
        this.costValue = value;
    }

    public int getEditCost(){
        return this.costValue;
    }
}

public class EditDistance {


    /* This method computes the minimal total cost of a sequence of character edits between two strings.
     * The costs of character edits are defined in EditCost enum
     * @param seq1 the original string.
     * @param seq2 the target string.
     * @return the minimal cost of the character edits.
     * */
    public static int minDistance(String seq1, String seq2) {
        int lengeth_of_s1 = seq1.length();
        int lengenth_of_s2 = seq2.length();
        int[][] dynamic_memorize = new int[lengeth_of_s1 + 1][lengenth_of_s2 + 1];
        for (int i = 0; i < lengeth_of_s1+1; i++) {
            dynamic_memorize[i][0] = i;
        }
        for (int i = 0; i < lengenth_of_s2+1; i++) {
            dynamic_memorize[0][i] = i;
        }
        for (int i = 0; i < lengeth_of_s1; i++) {
            char of_sqe1 = seq1.charAt(i);
            for (int j = 0; j < lengenth_of_s2; j++) {
                char of_sqe2 = seq2.charAt(j);
                if (of_sqe1 == of_sqe2) {
                    dynamic_memorize[i + 1][j + 1] = dynamic_memorize[i][j];
                } else {
                    int insertcost = dynamic_memorize[i + 1][j] + EditCost.INSERT.getEditCost();
                    int deletcost = dynamic_memorize[i][j + 1] + EditCost.DELETE.getEditCost();
                    int replacecost = dynamic_memorize[i][j] + EditCost.REPLACE.getEditCost();
                    int least = EditDistance.find_minimal(insertcost,deletcost,replacecost);
                    dynamic_memorize[i+1][j+1]=least;
                }
            }
        }
        return dynamic_memorize[lengeth_of_s1][lengenth_of_s2];


    }

    public static int find_minimal(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c)
            return b;
        else return c;

    }

    public static void main(String[] args) {

        String str1 = "gasd";
        String str2 = "asdw";
        int d=minDistance(str1,str2);
        System.out.println(d);
    }
}
