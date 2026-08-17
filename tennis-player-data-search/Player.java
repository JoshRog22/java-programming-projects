/**
 * @author Joshua Rogers
 * Represents a tennis player with a name, age, ranking and country.
 */
public class Player 
{
    private String name;
    private int age;
    private int rank;
    private String country;

    // Constructor
    public Player(String name, int age, int rank, String country) 
    {
        this.name = name;
        this.age = age;
        this.rank = rank;
        this.country = country;
    }

    // Getters
    public String getName() 
    { 
        return name; 
    }
    public int getAge() 
    { 
        return age; 
    }
    public int getRank() 
    { 
        return rank; 
    }
    public String getCountry() 
    { 
        return country; 
    }

    // Setters
    public void setName(String name) 
    { 
        this.name = name; 
    }
    public void setAge(int age) 
    { 
        this.age = age; 
    }
    public void setRank(int rank) 
    { 
        this.rank = rank; 
    }
    public void setCountry(String country) 
    { 
        this.country = country; 
    }

    // toString() method
    @Override
    public String toString() 
    {
        return 
               "Name: " + name + "\n" +
               "Age: " + age + "\n" +
               "Rank: " + rank + "\n" +
               "Country: " + country;
    }
}
