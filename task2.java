import java.util.*;
public class task2 {
    public static void main(String[] args) {
        float sum =0;
        System.out.println("Enter merks of 6 subject (out of 100)");
        Scanner sc = new Scanner (System.in);
        for( int i=1 ; i<=6 ; i++ ){
            System.out.println("Enter marks of subject "+i);
            int subject_i = sc.nextInt();
            sum = sum + subject_i;
        }
            System.out.println("Sum of allsubject is "+sum);
            float average_per = sum/6;
            System.out.println("Average percentage is "+average_per+"%");
           
            int grade;
            
            if(average_per>=90){
                grade=10;
                System.out.println("Grade for "+average_per+ " % is "+grade);
            }else if(average_per>=80){
                grade=9;
                System.out.println("Grade for "+average_per+ " % is "+grade);
            }else if(average_per>=70){
                grade=8;
                System.out.println("Grade for "+average_per+ " % is "+grade);
            }else if(average_per>=60){
                grade=7;
                System.out.println("Grade for "+average_per+ " % is "+grade);
            }else if(average_per>=50){
                grade=6;
                System.out.println("Grade for "+average_per+ " % is "+grade);
            }else{
                grade=5;
                System.out.println("Grade for "+average_per+ " % is "+grade);
            }
        
            if(average_per<40){
                grade=0;
                System.out.println("Your percentage is less than 40");
                System.out.println("You are failed");
                System.out.println("Grade="+grade);
            } 
            
            System.out.println("*****************************");
            System.out.println("------------Result-----------");
            System.out.println("total marks= "+sum);
            System.out.println("average_per= "+average_per+"%");
            System.out.println("Grade= "+grade);
            
        }
}
