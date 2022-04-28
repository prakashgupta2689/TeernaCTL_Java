package basicCoding;

/**
 * Design hash set without using any built in java libraries
 * what are the apis do you need ?
 * add(value)
 * contains(value)
 * remove(value)
 * what should be the data type of the hash set
 * assumptions:
 * the numbers provided would  be in a range[0, 100000]
 * the number of operations should be in the range of [0, 10000]
 * please do not use built in hash set library
 * can I use tree set ? the result would be same
 * no built in set implementations
 * */
public class CustomHashSet {

    public static void main(String[] args) {

        //1. create a boolean array of range [0, 100000].
        //when anyone adds an element in the set, set the boolean value to true in the boolean array for that corresponding index
        //set contains -> check if the boolean array contains true. If true return true
        //remove -> set the boolean array for the corresponding element to false
        //add -> set to true

        //2. better approach
    }
}
