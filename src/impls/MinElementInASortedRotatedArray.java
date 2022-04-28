package impls;

public class MinElementInASortedRotatedArray {

    //1, 2, 3, 4, 5, 6, 7, 8
    //8, 1, 2, 3, 4
    //6,7,8,1,2,3,4,5 - input
    //2,3,4,6,7,8,1
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,6,7,8,1};

        int first = 0;
        int mid = arr.length/2;
        int last = arr.length-1;

        while(first < last){

            if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                System.out.println(arr[mid]);
                break;
            }
            else if(arr[mid] < arr[first]){
                //breaks here
                System.out.println("letf");
                System.out.println("first:" + first);
                System.out.println("last:" + last);
                System.out.println("mid:" + mid);
                System.out.println("mid ele: "+ arr[mid]);
                System.out.println("first ele: "+ arr[first]);
                last = mid;
                mid = (first+last)/2;

            }else if(arr[mid] > arr[last]){
                //breaks here
                System.out.println("right");
                System.out.println("last:" + last);
                System.out.println("first: "+ first);
                System.out.println("mid:" + mid);
                System.out.println("mid ele: "+ arr[mid]);
                System.out.println("last ele: "+ arr[last]);
                first = mid;
                mid = (first+last)/2;

            }else if(arr[mid] > arr[first] && arr[mid] < arr[last]){
                System.out.println(arr[first]);
                break;
            }
        }
    }
}
//I love India -> sentence
//i = 3
//l = 1