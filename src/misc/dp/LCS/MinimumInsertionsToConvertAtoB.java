package misc.dp.LCS;

/**
 * Minimum number of insertions and deletions to convert string a to b
 * find out how to relate it with lcs.
 * 1. find the lcs between a and b. Remaining elements you need to think
 * Ex: convert heap to pea
 *  remove h and p
 *  add p in the beginning
 *  no of insertions: 1
 *  no of deletions: 2
 *
 *  convert a to lcs and then convert lcs to b
 *  lcs between heap and pea -> ea
 *  heap to ea -> 2 deletions => length of heap - length of ea
 *  ea to pea -> 1 insertion => length of pea - length of ea
 * */
public class MinimumInsertionsToConvertAtoB {

    public static void main(String[] args) {

        String s1 = "heap";
        String s2 = "pea";

        int[] minimumInsertionsAndDeletions = minimumInsertionsAndDeletions(s1, s2);
        System.out.println(minimumInsertionsAndDeletions[0] + " " + minimumInsertionsAndDeletions[1]);

    }

    private static int[] minimumInsertionsAndDeletions(String s1, String s2) {

        int lcsLength = findLCSLength(s1, s2, s1.length(), s2.length());

        int deletions = s1.length() - lcsLength;
        int insertions = s2.length() - lcsLength;

        return new int[]{insertions, deletions};
    }

    private static int findLCSLength(String s1, String s2, int length1, int length2) {

        if(length1 == 0 || length2 == 0)
            return 0;

        if(s1.charAt(length1-1) == s2.charAt(length2-1))
            return 1 + findLCSLength(s1, s2, length1-1, length2-1);

        return Math.max(findLCSLength(s1, s2, length1-1, length2), findLCSLength(s1, s2, length1, length2-1));
    }
}
