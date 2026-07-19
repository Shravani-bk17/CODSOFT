import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
public class task1confirm {
    public static void main(String[] args) {
        

    int secret_number = ThreadLocalRandom.current().nextInt(1, 101);

        int max_attempts = 5; 
        int attempts = 0;     
        boolean has_won = true;
     
        
        System.out.println("Welcome! Try to guess the secret number between 1 and 100.");
        System.out.println("You have " + max_attempts + " chances.");
        System.out.println("*************************************");
        System.out.print("Enter the number:");
        Scanner sc = new Scanner(System.in);
        
            int i;
            for(i = 1 ; i <= 5 ; i++){
            System.out.println("This is your " +i+ " attempt");
            System.out.print("Enter no." );
            int n = sc.nextInt();
            if (secret_number<n) {
                System.out.println("entered no. is greater");
                System.out.println("Try Again");
            }else if(secret_number>n){
                System.err.println("entered no. is lesser");
                System.out.println("Try Again");
            }else{
                System.out.println("The secret_number is "+secret_number);
                System.out.println("entered no. is equal to "+secret_number+" which is a secret_number");
                System.out.println("Congractulations! You Won!");
                
                break;
            }
            }
             sc.close();
    }        
        }
           

        
    
