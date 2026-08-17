/**
 * @author Joshua Rogers
 * Manages a collection of albums, including searching,
 *sorting, and displaying album information.
 */
public class AlbumCollection 
{
    public static final int MAX_ALBUMS = 100; // Maximum number of albums allowed

    private int numAlbums;
    private Album[] albums;

    public AlbumCollection() 
    {
        numAlbums = 0;
        albums = new Album[MAX_ALBUMS];
    }

    public int getNumAlbums() 
    {
        return numAlbums;
    }

    public boolean addAlbum(Album album) 
    {
        if (numAlbums >= MAX_ALBUMS) 
        {
            return false;
        }
        albums[numAlbums++] = album;
        return true;
    }

    public Album findAlbum(String title, String artist) 
    {
        for (int i = 0; i < numAlbums; i++) 
        {
            if (albums[i].getTitle().equalsIgnoreCase(title) 
                    && albums[i].getArtist().equalsIgnoreCase(artist)) 
            {
                return albums[i];
            }
        }
        return null;
    }

    public void sortAlbums() 
    {
        for (int i = 0; i < numAlbums - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < numAlbums; j++) 
            {
                if (albums[j].comesBefore(albums[minIndex])) 
                {
                    minIndex = j;
                }
            }
            // Swap albums[i] and albums[minIndex]
            Album temp = albums[i];
            albums[i] = albums[minIndex];
            albums[minIndex] = temp;
        }
    }

    public void displayAlbums() 
    {
        if (numAlbums == 0) 
        {
            System.out.println("No albums in the collection.");
            return;
        }
        for (int i = 0; i < numAlbums; i++) 
        {
            albums[i].displayAlbum();
        }
    }

    public void displaySongs() 
    {
        if (numAlbums == 0) 
        {
            System.out.println("No albums in the collection.");
            return;
        }
        for (int i = 0; i < numAlbums; i++) 
        {
            albums[i].displayTracklist();
        }
    }
}
