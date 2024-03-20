import java.util.Scanner;

public class IntroToPresentationLayer
{
    public static void main(String[] args)
    {
        Scanner userInformation = new Scanner(System.in);
        System.out.println("Enter username and password:");
        // String input
        String userName = userInformation.nextLine();
        String password = userInformation.nextLine();
        String query = "select * from Recipe";

        
        IntroToDAL2 dal2 = new IntroToDAL2();
        IntroToPresentationLayer2 PL2 = new IntroToPL2();

        
        if (dal2.TryExecutingAQuery("MealPlanning", "Select * from Meal", userName, password))
        {
            System.out.println("Successfully connected to the database");
        }
        else
        {
            System.out.println("Failed to connect to the database");
        }

        // Let's try calling a stored procedure, and let's start simple.
        // I made a new stored procedure that just returns everything in the 
        // Recipe table, called GetRecipes. No parameters, just a simple call.
        if (dal2.TryExecutingAStoredProcedure("MealPlanning", userName, password))
        {
            System.out.println("Successfully ran a stored procedure");
        }
        else
        {
            System.out.println("Failed to run a stored procedure");
        }
        if (PL2.TryExecutingAStoredProcedure("MealPlanning", userName, password))
        {
            System.out.println("Successfully ran a stored procedure");
        }
        else
        {
            System.out.println("Failed to run a stored procedure");
        }
    }  
}