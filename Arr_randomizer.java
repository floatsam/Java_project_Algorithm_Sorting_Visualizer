import java.util.Random;
public class Arr_randomizer{
    
    final public static int[] rand_logic(int arr[]){
        Random r = new Random();
        for(int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(500);
        return arr;
    }

/*
    public static void main(String[] args){
        paintCompOverride.fin_array = rand_logic(paintCompOverride.fin_array);
        for(int i = 0; i < paintCompOverride.fin_array.length; i++){
            System.out.print(paintCompOverride.fin_array[i] + " ");
        }
    }
*/

}