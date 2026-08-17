/**
 * @author Joshua Rogers
 * Represents a song with a title, artist, and duration.
 */
public class Song 
{
    private String title;
    private String artist;
    private int length; // lenth will be in seconds

    public Song(String title, String artist, int minutes, int seconds) 
    {
        this.title = title;
        this.artist = artist;
        this.length = (minutes * 60) + seconds;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getArtist() 
    {
        return artist;
    }

    public int getLength() 
    {
        return length;
    }

    public void display() 
    {
        int minutes = length / 60;
        int seconds = length % 60;
        System.out.printf("%s - %s (%d:%02d)\n", title, artist, minutes, seconds);
    }
}