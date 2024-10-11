package FruitIPA;

import java.util.Scanner;

public class FruitIPA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fruits[] fruits = new Fruits[4];
        for (int i = 0; i < fruits.length ; i++) {
            int fruitId = in.nextInt();in.nextLine();
            String fruitName = in.nextLine();
            int price = in.nextInt();in.nextLine();
            int rating = in.nextInt();in.nextLine();
            fruits[i] = new Fruits(fruitId,fruitName,price,rating);
        }
        int rate = in.nextInt();in.nextLine();
        in.close();
        Fruits result = findMaximumPriceByRating(fruits,rate);
        if(result == null){
            System.out.println("No such fruit");
        }else{
            System.out.println(result.getFruitId());
        }
    }
    static Fruits findMaximumPriceByRating(Fruits[] arr,int rate){
        Fruits fruit= arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getPrice() > fruit.getPrice() && arr[i].getRating() > rate){
                fruit = arr[i];
            }
        }
        return fruit;
    }
}

class Fruits{
    private int fruitId;
    private  String fruitName;
    private int price;
    private int rating;
    
    Fruits(int id,String name,int price,int rating){
        this.fruitId = id;
        this.fruitName=name;
        this.price = price;
        this.rating = rating;
    }
    
    int getPrice(){
        return price;
    }
    int getRating(){
        return rating;
    }
    int getFruitId(){
        return fruitId;
    }
}
