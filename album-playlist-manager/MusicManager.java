import java.util.Scanner;

/**
 * @author Joshua Rogers
 * Console-based music manager for creating album collections
 * and building custom playlists
 */ 

public class MusicManager 
{
    public static void main(String[] args) 
    {
    AlbumCollection collection = new AlbumCollection();
        Playlist playlist = new Playlist();

        System.out.println("Welcome to Rogers's music manager!");

        int choice;
        do 
        {
            //display menu to get input choice from user
            displayMenu();
            choice = getChoice();

            switch (choice) 
            {
                case 1:
                    Album album = createAlbum();
                    if (collection.addAlbum(album)) 
                    {
                        System.out.println("Album added successfully!");
                    } 
                    else 
                    {
                        System.out.println("Collection is full. Cannot add more albums.");
                    }
                    break;
                case 2:
                    collection.displayAlbums();
                    break;
                case 3:
                    collection.displaySongs();
                    break;
                case 4:
                    collection.sortAlbums();
                    System.out.println("Albums sorted successfully.");
                    break;
                case 5:
                    addSongToPlaylist(collection, playlist);
                    break;
                case 6:
                    playlist.display();
                    break;
                case 7:
                    playlist.clear();
                    System.out.println("Playlist cleared.");
                    break;
                case 8:
                    System.out.println("Thank you for using Rogers's music manager!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid choice");
                    
            }
        } while (choice != 8);
    }
    
    //system output for display menu
    private static void displayMenu() 
    {
        System.out.println("\nChoose one of the following:");
        System.out.println("1. Add an album to the collection");
        System.out.println("2. Display the albums in the collection");
        System.out.println("3. Display the songs in the collection");
        System.out.println("4. Sort the albums in the collection");
        System.out.println("5. Add a song to the playlist");
        System.out.println("6. Display the playlist");
        System.out.println("7. Clear playlist");
        System.out.println("8. Exit the program");
    }

    //System output.
    private static int getChoice() 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        
        while (!keyboard.hasNextInt()) 
        {
            System.out.println("Invalid input. Please enter a number.");
            keyboard.nextLine();
        }
        
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        return choice;
    }

    private static Album createAlbum() 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(); //Line break  
        
        System.out.println("Album title: ");
        String title = keyboard.nextLine();
        System.out.println(); //Line break

        System.out.println("Album artist: ");
        String artist = keyboard.nextLine();
        System.out.println(); //Line break
        
  
        int numTracks;
        while (true) 
        {
            System.out.println("How many tracks are on the album? ");
                    
            if (keyboard.hasNextInt()) 
            {
                numTracks = keyboard.nextInt();
                keyboard.nextLine(); //Consumes leftover newline after nextInt()

                if (numTracks > 0) //ensures number is positive
                {
                    break;
                }
            } 
            else 
            {
                System.out.println("Invalid input. Please enter a positive number.");
                keyboard.next(); //prevents loop from indefinitely repeating
            }
        }

    Song[] tracklist = getTracklist(numTracks, artist);
    return new Album(title, artist, tracklist);
    }

    private static Song[] getTracklist(int numTracks, String artist) 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(); //linebreak
        Song[] songs = new Song[numTracks];

        for (int i = 0; i < numTracks; i++) 
        {
            System.out.printf("Track %d title: ", i + 1);
            String title = keyboard.nextLine();

            int minutes, seconds;
            System.out.printf("Track %d length (minutes seconds): ", i + 1);
            while (!keyboard.hasNextInt()) 
            {
                System.out.println("Invalid input. Please enter a number.");
                keyboard.next();
            }
            minutes = keyboard.nextInt();

            while (!keyboard.hasNextInt()) 
            {
                System.out.println("Invalid input. Please enter a number.");
                keyboard.next();
            }
            seconds = keyboard.nextInt();
            System.out.println(); //linebreak
            keyboard.nextLine(); // Consume newline

            songs[i] = new Song(title, artist, minutes, seconds);
        }
        return songs;
    }

    private static void addSongToPlaylist(AlbumCollection collection, Playlist playlist) 
    {
        Album album = getAlbumFromCollection(collection);
        if (album != null) 
        {
            Song song = getSongFromAlbum(album);
            if (song != null) 
            {
                if (playlist.addSong(song)) 
                {
                    System.out.println("Song added to playlist.");
                } 
                else 
                {
                    System.out.println("Playlist is full.");
                }
            }
        }
    }

    private static Album getAlbumFromCollection(AlbumCollection collection) 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println();//line break
        while (true) {
            System.out.print("Album title: ");
            String title = keyboard.nextLine();

            System.out.print("Album artist: ");
            String artist = keyboard.nextLine();

            Album album = collection.findAlbum(title, artist);
            if (album != null) {
                return album;
            }
            System.out.println("Album not found. Please try again.");
        }
    }

    private static Song getSongFromAlbum(Album album)  
    {
        Scanner keyboard = new Scanner(System.in);
        album.displayTracklist();
        
        int trackNumber;
        
        while (true) 
        {
            System.out.print("Choose a track: ");

            if (keyboard.hasNextInt()) 
            {  //Check if user input is a number
                trackNumber = keyboard.nextInt();
                keyboard.nextLine();  //Consume leftover newline character

                Song song = album.getTrack(trackNumber);
                
                if (song != null) 
                {
                    return song;  //Return valid song
                } 
            
                else 
                {   
                    System.out.println("Invalid input. Please enter a valid tack number");
                }            
            }
        } 
    }   
}
