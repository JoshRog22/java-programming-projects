import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 * @author Joshua Rogers
 * tennis player data loaded from a text file.
 */

public class TennisPlayerSearch 
{
    
    public static void main(String[] args) 
    {
        Player[] player = new Player[1000];

        //load players from file 
        loadPlayers("data/womensSinglesDraw.txt", player);
        
        Scanner kb = new Scanner(System.in);

        int select;
        
        //display menu and process user input
        try 
        {           
            do {
                System.out.println("Press 1 to find a player by name");                
                System.out.println("Press 2 to find all players from a country");                
                System.out.println("Press 3 to find the youngest player");                
                System.out.println("Press 4 to find the oldest player");                
                System.out.println("Press 5 to exit Program");               
                System.out.print("Please make a selection: ");
                
                select = kb.nextInt();

                kb.nextLine();

                switch (select) 
                {
                    case 1:                        
                        System.out.print("Enter a player's name: ");
                        String name = kb.nextLine();
                        System.out.println();
    
                        try 
                        {
                            Player p = findPlayerByName(player, name);
                            System.out.println(p);
                        } 
                        catch (NoSuchPlayerException ex) 
                        {
                            System.out.println(ex.getMessage()); // Display message but continue program
                        }
                        break;

                    case 2:                       
                        System.out.print("Enter the country: ");
                        String country = kb.nextLine();
    
                        try 
                        {
                            Player[] countryPlayer = findPlayerByCountry(player, country);
                        
                            for (Player cp : countryPlayer) 
                            {                            
                                if (cp != null)  
                                {                                
                                    System.out.println(cp.getName());
                                }
                            }
                        } 
                        catch (NoSuchPlayerException ex) 
                        {
                            System.out.println(ex.getMessage()); // Display message but continue program
                        }
                        break;

                    case 3:                       
                        try 
                        {
                            Player youngest = findYoungestPlayer(player);
                             System.out.println(youngest);
                        } 
                        catch (NoSuchPlayerException ex) 
                        {
                            System.out.println(ex.getMessage());
                        }
                        break;

                    case 4:                        
                        try 
                        {
                            Player oldest = findOldestPlayer(player);
                             System.out.println(oldest);
                        } 
                        catch (NoSuchPlayerException ex) 
                        {
                            System.out.println(ex.getMessage());
                        }                        
                        break;

                    case 5: //exit program                  
                        System.out.println("Thank you for using the program.");
                        
                        break;

                    default:   
                        System.out.println();
                        System.out.println("Invalid Choice.");
                        System.out.println();
                }                
            } 
            while (select != 5);  
        }
        catch (Exception ex)  
        {
            System.out.println("An unexpected error occurred: " + ex.getMessage());
        }
    }

    public static void loadPlayers(String fileName, Player[] player) 
    { 
        try 
        {            
            Scanner fileReader = new Scanner(new File(fileName));
            
            int index = 0;
            
            while (fileReader.hasNextLine() && index < player.length) 
            {                
                String line = fileReader.nextLine();
                
                String[] value = line.split(",");
                
                String name = value[0];
                
                int age = Integer.parseInt(value[1]);
                
                int rank = Integer.parseInt(value[2]);
                
                String country = value[3];
                
                player[index++] = new Player(name, age, rank, country);
            }
        } 
        catch (FileNotFoundException ex) 
        {           
            System.out.println(ex.getMessage());
        }
    }

    public static Player findPlayerByName(Player[] player, String name) throws NoSuchPlayerException 
    {        
        for (Player p : player) 
        {            
            if (p != null && p.getName().equalsIgnoreCase(name)) 
            {               
                return p;
            }
        }
        throw new NoSuchPlayerException("There is no Player named " + name);   
    }

    public static Player[] findPlayerByCountry(Player[] player, String country) throws NoSuchPlayerException 
    {        
        if (country == null || country.trim().isEmpty()) 
        {  
            throw new NoSuchPlayerException("Error: Invalid country name entered.");
        }
        
        int count = 0;
        
        for (Player p : player) 
        {            
            if (p != null && p.getCountry().equalsIgnoreCase(country)) 
            {               
                count++;
            }
        }
        if (count == 0) 
        {            
            throw new NoSuchPlayerException("There are no players from " + country);
        }
        
        Player[] countryPlayer = new Player[count];
        int index = 0;
        
        
        for (Player p : player) 
        {            
            if (p != null && p.getCountry().equalsIgnoreCase(country)) 
            {               
                countryPlayer[index++] = p;
            }
        }
        return countryPlayer;
    }

    public static Player findYoungestPlayer(Player[] player) throws NoSuchPlayerException 
    {        
        Player youngest = null;
        
        for (Player p : player) 
        {           
            if (p != null) 
            {               
                if (youngest == null || p.getAge() < youngest.getAge()) 
                {                    
                    youngest = p;
                }
            }
        }
        if (youngest == null) 
        {            
            throw new NoSuchPlayerException("No players found!");
        }
        return youngest;
    }

    public static Player findOldestPlayer(Player[] player) throws NoSuchPlayerException 
    {        
        Player oldest = null;
        
        for (Player p : player) 
        {            
            if (p != null) 
            {                 
                if (oldest == null || p.getAge() > oldest.getAge()) 
                {                   
                    oldest = p;
                }
            }
        }
        if (oldest == null) 
        {            
            throw new NoSuchPlayerException("No players found!");
        }
        return oldest;        
    }
}    
