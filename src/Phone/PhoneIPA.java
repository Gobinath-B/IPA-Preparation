package Phone;
import java.util.*;


public class PhoneIPA {
    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       Phone[] list = new Phone[4];
        for (int i = 0; i < list.length ; i++) {
           int id= in.nextInt();in.nextLine();
           String os = in.nextLine();
           String brand = in.nextLine();
           int price = in.nextInt();in.nextLine();

           list[i] = new Phone(id,os,brand,price);
        }
        String targetBrand = in.nextLine();
        String targetOs = in.nextLine();
        in.close();
        int priceResult = findPriceForGivenBrand(list,targetBrand);
        Phone res = getPhoneIdBasedOnOs(list,targetOs);
        if(priceResult>0){
            System.out.println(priceResult);
        }
        else{
            System.out.println("The given Brand is not available");
        }

        if(res != null){
            System.out.println(res.getPhoneId());
        }
        else{
            System.out.println("No phones are available with specified os and price range");
        }
    }

    static int findPriceForGivenBrand(Phone[] list,String brand){
        int result = 0;
        for (int i = 0; i < list.length ; i++) {
            if(list[i].getBrand().equalsIgnoreCase(brand)){
                result+= list[i].getPrice();
            }
        }
       return result;
    }

    static Phone getPhoneIdBasedOnOs(Phone[] list, String os){
        for (int i = 0; i < list.length ; i++) {
            if(list[i].getOs().equalsIgnoreCase(os) && list[i].getPrice() >= 50000){
                return list[i];
            }
        }
        return null;
    }
}

class Phone{
    private int phoneId ;
    private String os;
    private String brand;
    private int price;


Phone(int id,String os,String brand,int price){
    this.phoneId = id;
    this.os = os;
    this.brand = brand;
    this.price = price;
}

String getBrand(){
    return brand;
}
String getOs(){
    return os;
}
int getPrice(){
    return price;
}
 int getPhoneId() {
        return phoneId;
    }
}
