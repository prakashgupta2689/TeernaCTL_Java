package misc.morganStanley.stacks;

//difference between rainwater trapping and MAH is that rainwater trapping needs the absolute greater
//whereas maximum histogram needs the nearest greater.
//so none of the NGR/NGL/NSL/NSR would apply for this question.
public class RainwaterTrapping {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 0, 0, 2, 0, 4};
        int qty = findQtyOfWaterTrapped(arr);
        System.out.println("qty: " + qty);
    }

    private static int findQtyOfWaterTrapped(int[] arr) {

        int[] maxLeft = new int[arr.length];
        int[] maxRight = new int[arr.length];
        int[] water = new int[arr.length];
        int sum = 0;

        maxLeft[0] = arr[0];
        maxRight[arr.length-1] = arr[arr.length-1];

        for(int i  = 1; i < arr.length; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }

        for(int i = arr.length-2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }

        for(int i = 0; i < arr.length; i++){
            water[i] = Math.min(maxLeft[i], maxRight[i]) - arr[i];
        }

        //total qty of water
        for(int i = 0; i< water.length; i++){
            sum = sum + water[i];
        }
        return sum;
    }
}
