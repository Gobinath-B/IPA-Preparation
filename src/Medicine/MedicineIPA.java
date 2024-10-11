package Medicine;

import java.util.Arrays;
import java.util.Scanner;

public class MedicineIPA {
    public static void main(String[] args) {
        Medicine[] arr = new Medicine[4];
        Scanner in = new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            String med = in.nextLine();
            String batch = in.nextLine();
            String disease = in.nextLine();
            int price = in.nextInt();in.nextLine();
            arr[i] = new Medicine(med,batch,disease,price);
        }
        String targetDisease = in.nextLine();
        int [] result  = getPriceByDisease(arr,targetDisease);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] getPriceByDisease(Medicine[] medList,String target){
       int[] arr = new int[0];
        for (int i = 0; i < medList.length; i++) {
          if( medList[i].getDisease().equalsIgnoreCase(target)) {
              arr = Arrays.copyOf(arr, arr.length + 1);
              arr[arr.length - 1] = medList[i].getPrice();
          }
        }
        Arrays.sort(arr);
        return arr;
    }

}
class Medicine{
    private String Medicine;
    private String Batch;
    private String Disease;
    private int Price;

    Medicine(String medicine,String batch,String disease,int price){
        this.Medicine = medicine;
        this.Batch = batch;
        this.Disease = disease;
        this.Price = price;
    }

    String getDisease(){
        return Disease;
    }
    int getPrice(){
        return Price;
    }
}
