package misc.dp.pathFindingWithBFS;

/**
 * 1's ka sabse bada square kitne size ka hai
 * each cell says: isko apna top left bana kar 1 ka sabse bada square kitne 1's ka hai
 * choti problem arr[len][len] mein hai
 * 1. jaha pe bhi 0 para hua hai waha se sabse bada 1 ka square banana possible hi nhi hai. Toh usko 0 hi rakh do
 * 2. last row and last column mein jaha pe bhi 1 hai waha pe 1 hi ayega. kyuki koi square nhi ban sakta.
 * 3. beech wale cells mein agar 1 aya toh waha pe teen spots ka minimum lo (horizontal, diagonal and vertical ka) and wahi value + 1 uss beech wale cell ka value hoga
 * 4. ans is the maximum value contained in a cell in the dp matrix
 * */
public class LargestSquareSubmatrixWithAll1s {

    public static void main(String[] args) {

    }
}
