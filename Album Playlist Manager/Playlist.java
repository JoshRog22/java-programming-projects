/**
 * @author Joshua Rogers
 * Manages a playlist of songs and calculates total play time.
 */
public class Playlist 
{
    public static final int MAX_SONGS = 50; // Max  of songs allowed in the playlist

    private int numSongs;
    private Song[] songs;

    public Playlist() 
    {
        numSongs = 0;
        songs = new Song[MAX_SONGS];
    }

    public int getNumSongs() 
    {
        return numSongs;
    }

    public int getLength() 
    {
        int totalLength = 0;
        for (int i = 0; i < numSongs; i++) 
        {
            totalLength += songs[i].getLength();
        }
        return totalLength;
    }

    public boolean addSong(Song song) 
    {
        if (numSongs >= MAX_SONGS) 
        {
            return false;
        }
        songs[numSongs++] = song;
        return true;
    }

    public void display() 
    {
        if (numSongs == 0) 
        {
            System.out.println("Playlist is empty");
        } 
        else 
        {
            for (int i = 0; i < numSongs; i++) 
            {
                songs[i].display();
            }
        }
        int totalLength = getLength();
        int minutes = totalLength / 60;
        int seconds = totalLength % 60;
        System.out.printf("Total time: %d:%02d\n", minutes, seconds);
    }

    public void clear() 
    {
        numSongs = 0;
    }
}
