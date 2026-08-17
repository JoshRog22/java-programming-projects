/**
 * @author Joshua Rogers
 * Represents an album and its track list
 */
public class Album 
{
    private String title;
    private String artist;
    private Song[] tracklist;

    public Album(String title, String artist, Song[] songs) 
    {
        this.title = title;
        this.artist = artist;
        this.tracklist = new Song[songs.length];
        System.arraycopy(songs, 0, this.tracklist, 0, songs.length);
    }

    public String getTitle() 
    {
        return title;
    }

    public String getArtist() 
    {
        return artist;
    }

    public int getNumTracks() 
    {
        return tracklist.length;
    }

    public Song getTrack(int trackNumber) 
    {
        if (trackNumber < 1 || trackNumber > tracklist.length) 
        {
            return null;
        }
        return tracklist[trackNumber - 1];
    }

    public boolean comesBefore(Album other) 
    {
        int artistComparison = this.artist.compareToIgnoreCase(other.artist);
        if (artistComparison != 0) 
        {
            return artistComparison < 0;
        }
        return this.title.compareToIgnoreCase(other.title) < 0;
    }

    public void displayAlbum() 
    {
        System.out.printf("%s - %s (%d %s)\n", title, artist, tracklist.length, 
                tracklist.length == 1 ? "track" : "tracks");
    }

    public void displayTracklist() 
    {
        System.out.printf("%s - %s (%d tracks)\n", title, artist, tracklist.length);
        for (int i = 0; i < tracklist.length; i++) 
        {
            System.out.printf(" %2d. ", i + 1);
            tracklist[i].display();
        }
    }
}
