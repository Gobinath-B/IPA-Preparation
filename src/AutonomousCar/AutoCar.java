package AutonomousCar;

import java.util.Scanner;

public class AutoCar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Car[] cars = new Car[4];
        for (int i = 0; i < cars.length ; i++) {
            int id = in.nextInt(); in.nextLine();
            String brand = in.nextLine();
             int noOfTest = in.nextInt();in.nextLine();
             int noOfPassed = in.nextInt();in.nextLine();
             String environment = in.nextLine();
             cars[i] = new Car( id, brand, noOfTest, noOfPassed, environment);
        }
        String env = in.nextLine();
        String Brand = in.nextLine();
        in.close();

        int result = findTestPassedByEnv(cars,env);
        if(result>0){
            System.out.println(result);
        }else{
            System.out.println("There are no tests passed in this particular environment");
        }
        Car car = updateCarGrade(cars,Brand);
        if(car != null){
            System.out.println(car.getBrand()+"::"+car.getGrade());
        }else{
            System.out.println("No Car is available with the specified brand");
        }
    }

    static int findTestPassedByEnv(Car[] arr, String env){
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getEnvironment().equalsIgnoreCase(env)){
                sum += arr[i].getNoOfPassed();
            }
        }
        return sum;
    }

    static Car updateCarGrade(Car[] arr, String brand ){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getBrand().equalsIgnoreCase(brand)){
                Car temp = arr[i];
                int rating = (temp.getNoOfPassed()*100)/ temp.getNoOfTest();
                if(rating>=80){
                    temp.setGrade("A1");
                }else{
                    temp.setGrade("B2");
                }
                return temp;
            }

        }
        return null ;
    }
}

class Car{
    private int id;
    private String brand;
    private int noOfTest;
    private int noOfPassed;
    private String environment;

    private String grade;

    Car(int id,String brand,int noOfTest,int noOfPassed,String environment){
        this.id= id;
        this.brand = brand;
        this.noOfTest = noOfTest;
        this.noOfPassed = noOfPassed;
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    public int getNoOfPassed() {
        return noOfPassed;
    }

    public String getBrand() {
        return brand;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public int getNoOfTest() {
        return noOfTest;
    }
}
