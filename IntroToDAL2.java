import java.sql.*;

// This is an example DAL. Notice all the database logic is contained within this class.
public class IntroToDAL2
{
   
    private Connection getMySQLConnection(String databaseName, String user, String password)
    {
        try
        {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, user, password);
        } 
        catch (SQLException exception)
        {
            System.out.println("Failed to connect to the database" + exception.getMessage());
            return null;
        }
    }
      
    public boolean TryExecutingAQuery(String databaseName, String user, String password)
    {
        try
        {
            

            Connection myConnection = getMySQLConnection(databaseName, user, password);

            String query = "select * from Gamne";

            Statement myStatement = myConnection.createStatement();
            ResultSet myRelation = myStatement.executeQuery(query);

           
            while (myRelation.next())
            {
                
                String myGameName = myRelation.getString("GameName");
                int myGameId = myRelation.getInt("GameId");
                System.out.println("Tuple Values:" + myGameId + "," + myGameId);
                
                String myReleaseDate = myRelation.getString("ReleaseDate");
                int myReleaseDateId = myRelation.getInt("DateId");
                System.out.println("Tuple Values:" + myReleaseDateId + "," + myReleaseDateId);

                String myConsoleName = myRelation.getString("ConsoleName");
                int myConsoleId = myRelation.getInt("ConsoleId");
                System.out.println("Tuple Values:" + myConsoleId + "," + myConsoleId);
                
                String mySeries = myRelation.getString("Series");
                int mySeriesId = myRelation.getInt("SeriesId");
                System.out.println("Tuple Values:" + mySeriesId + "," + mySeriesId);

                String myNumplayer = myRelation.getString("Numplayers");
                int myNumPlayersId = myRelation.getInt("PlayersId");
                System.out.println("Tuple Values:" + myNumPlayersId + "," + myNumPlayersId);

                String myOnline = myRelation.getString("Online");
                int myOnlineId = myRelation.getInt("OnlineId");
                System.out.println("Tuple Values:" + myOnlineId + "," + myOnlineId);

                // But, really you should add an instance of the object to the array of objects
            }
        } 
            catch (SQLException exception)
        {
            System.out.println("Epic Fail Executing a Query:" + exception.getMessage());
            return false;
        }
        return true;
    }

    public boolean TryExecutingAStoredProcedure(String databaseName, String user, String password)
    {
        Connection myConnection = getMySQLConnection(databaseName, user, password);
        try
        {
            CallableStatement myStoredProcedureCall = myConnection.prepareCall("{Call GetGame()}");
            ResultSet myResults = myStoredProcedureCall.executeQuery();

            CallableStatement StoredProcedureCall = myConnection.prepareCall("{Call GetRecipe()}");
            ResultSet Results = myStoredProcedureCall.executeQuery();

            CallableStatement myStoredeCall = myConnection.prepareCall("{Call GetConsole()}");
            ResultSet Result = myStoredProcedureCall.executeQuery();



            // Iterate over the ResultSet, row by row
            while (myResults.next())
            {
                String myGameName = myResults.getString("GameName");
                int numPlayers = myResults.getInt("TotalPlayers");
                System.out.println("Tuple Values:" + myGameName + "," + numPlayers);
            }
        } catch (SQLException myException)
        {
            System.out.println("Failed to execute stored procedure:" + myException.getMessage());
            return false;
        }
        return true;
    }
}

