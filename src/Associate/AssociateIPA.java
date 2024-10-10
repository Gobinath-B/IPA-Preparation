package Associate;

import java.util.ArrayList;
import java.util.Scanner;

public class AssociateIPA {
    public static void main(String[] args) {
       Associate[] arr = new Associate[5];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            int Id = in.nextInt();in.nextLine();
            String Name = in.nextLine();
            String Technology = in.nextLine();
            int Experience = in.nextInt();in.nextLine();
            arr[i] = new Associate(Id,Name,Technology,Experience);
        }
        String ExpectedTech = in.nextLine();
        Associate[] res = search(arr,ExpectedTech);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i].getId());
        }
    }

    static Associate[] search(Associate[] arr,String tech){

        ArrayList<Associate> list = new ArrayList<Associate>(5);
        for (int i = 0; i < arr.length; i++) {
           if( arr[i].getTechnology().equalsIgnoreCase(tech) && arr[i].getExperience()%5==0){
               list.add(arr[i]);
               /*arr = Arrays.copyOf(arr,arr.length+1);
               arr[arr.length-1]=a[i];*/
           }
        }
        Associate[] result = new Associate[list.size()];
       list.toArray(result);
       return result;
    }
}

class Associate{
private int id;
private String name;
private String technology;
private int experience;

Associate(int id,String name,String technology,int experience){
    this.id = id;
    this.name =name;
    this.technology = technology;
    this.experience = experience;
}

int getId(){
    return id;
}
String getName(){
    return name;
}
String getTechnology(){
    return technology;
}

int getExperience(){
    return experience;
}

}

