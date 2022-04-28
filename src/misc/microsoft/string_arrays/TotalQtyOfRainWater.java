package misc.microsoft.string_arrays;

public class TotalQtyOfRainWater {

    public static void main(String[] args) {

        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        int totalQtyOfWater = trap(height);
        System.out.println("total qty of water: "+ totalQtyOfWater);
    }

    private static int trap(int[] arr) {
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
