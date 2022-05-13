package misc.dp.LIS;


/**
 * You are given a number n, representing the number of bridges on a river.
 * 2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
 * 3. You are required to print the count of maximum number of non-overlapping bridges.
 * i.e. kitne bridges maximum select karte ho jo apas mein overlap na kare
 *
 * Overlapping ka concept kya hai ? i ka north agar j ke north se chota hai toh i ka south bhi j ke south se chota hona chahiye
 * sort the array on the basis of northbank values and find LIS based on south bank, toh south bhi badhega. Since, dono badhenge toh kabhi overlap nhi hoga
 * */
public class MaximumNonOverlappingBridges {

    public static void main(String[] args) {


    }
}
