package misc.dp.gapStrategy;

/**
 * 1. You are given an array(arr) of length N which represents N number of balloons.
 * 2. Each balloon is painted with a number on it.
 * 3. You have to collect maximum coins by bursting all the balloons.
 * 4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
 * 5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
 *
 * 231564 - > suppose aakhri balloon 2 foota -> 2, 31564 ki keemat
 *         -> aakhri balloon 3 foota -> 2, 3, 1564 ki keemat
 *         -> aakhri balloon 1 foota -> 23, 1, 564 ki keemat --> 23 ko fodne ke 2 tareeke hai, pehle 2 ko fodo ya pehle 3 ko fodo. Dono mein se jisme zyada paise mile usey pehle fodo
 *         -> aakhri balloon 5 foota -> 231, 5, 64 ki keemat
 *         -> aakhri balloon 6 foota -> 2315, 6, 4 ki keemat
 *         -> aakhri balloon 4 foota -> 23156, 4 ki keemat
 *
 *         use gap strategy and fill the 2d matrix likewise
 * */
public class BurstBalloon {
}
