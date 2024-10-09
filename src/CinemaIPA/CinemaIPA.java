package CinemaIPA;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CinemaIPA {
    public static void main(String[] args) {
       Cinema[] movies = new Cinema[4];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < movies.length; i++) {
            int id = in.nextInt();
            in.nextLine();
            String director = in.nextLine();
            int rating = in.nextInt();in.nextLine();
            int budget = in.nextInt();in.nextLine();
            movies[i] = new Cinema(id,director,rating,budget);

        }
        String dir = in.nextLine();
        int rate = in.nextInt();in.nextLine();
        int bud = in.nextInt();in.nextLine();

        int avgResult = avgBudget(movies,dir);
        if(avgResult>0){
            System.out.println(avgResult);
        }else{
            System.out.println("Sorry - The given director has not yet directed any movie");
        }
        Cinema mov = movie(movies,rate,bud);
        if(mov == null){
            System.out.println("Sorry - No movie is available with the specified rating and budget requiremen");
        }else{
            System.out.println(mov.getMovieId());
        }
    }

    public static Cinema movie (Cinema[] movies,int rating,int budget){

        for (int i = 0; i < movies.length; i++) {
            if(movies[i].getRating() == rating && movies[i].getBudget() == budget && budget %rating ==0){
                return movies[i];
            }

        }
        return null;
    }

    public static int avgBudget(Cinema[] movies,String director){
        int Result =0;
        int sum=0,count =0;
        for (int i = 0; i <movies.length ; i++) {
            if(movies[i].getDirector().equals(director)){
                sum +=  movies[i].getBudget();
                count +=1;
            }
        }
        if(count ==0){
            return 0;
        }else{
            Result = sum/count;
            return Result;

        }

    }
}

class Cinema{
    private int movieId;
    private String director;
    private int rating;
    private  int budget;

    Cinema(int movieId,String director,int rating,int budget){
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }








   int getMovieId(){
        return movieId;
   }

   int getRating(){
        return rating;
   }
   String getDirector(){
        return director;
   }
   int getBudget(){
        return budget;
   }
}
