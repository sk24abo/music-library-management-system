
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Main class is for the menu of MusicParty Application
 *
 * This class contains the program entry point and handles
 * all user interactions through a command-line printed menu.
 * It coordinates the music library and playlist collection
 * based on user menu selections.
 */
public class MusicParty {
    
    // Stores all available songs that can be searched.
    private static MusicLibrary musicLibrary = new MusicLibrary(); 
    
    // Stores all playlists created by the user.
    private static PlaylistCollection playlistCollection = new PlaylistCollection();
    
    // Uses the command line to read user inputs.
    private static Scanner input = new Scanner(System.in);
    
    /*
    This is the Program entry point
    Loading the initial songs into the music library
    and then starts the main menu loop.
    */
    public static void main(String[]args) {
        loadInitialSongs();
        showMainMenu();
    }
    
    /*
    Add your fav. songs to the music library.
    these songs will be available for searching when the program starts.
    */
    private static void loadInitialSongs() {
        musicLibrary.addSong(new Song("Shree Hanuman Chalisa", "Tulsidas Ji", 540, "pop"));
        musicLibrary.addSong(new Song("moment", "Vierre Cloud", 230, "pop"));
        musicLibrary.addSong(new Song("bargad", "sufr", 175, "pop"));
        musicLibrary.addSong(new Song("What did i miss", "Drake", 194, "pop"));
        musicLibrary.addSong(new Song("Like a Prayer", "I'll Take you ThereChoir", 153, "pop"));
    }
    
    /*
    Displays the main menu and processes user input.
    The menu continues to loop until the user chooses to exit.
    */
    private static void showMainMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("~~~ MusicParty ~~~");
            System.out.println("1. View existing playlists.");
            System.out.println("2. Create a new Playlist.");
            System.out.println("3. Edit a Playlist.");
            System.out.println("4. Remove a playlist");
            System.out.println("5. Exit program.");
            System.out.println("Select an option from above:- ");
            
            int userChoice = readUserOption(1,5);
            
            if (userChoice == 1) {
                displayPlaylists();
            } else if (userChoice == 2) {
                createPlaylist();
            } else if (userChoice == 3) {
                editPlaylist();
            } else if (userChoice == 4) {
                deletePlaylist();
            }else {
                running = false;
            }
        }
    }
    
    /*
    Display all existing playlists with their total Run Time (durantion).
    If no playlists exist, a message is shown to the user.
    */
    private static void displayPlaylists() {
        if (playlistCollection.getPlaylists().isEmpty()) {
            System.out.println("No Playlists found.");
            return;
        }
        
        for (int i = 0; i < playlistCollection.getPlaylists().size(); i++) {
            System.out.println((i + 1) + ". " + playlistCollection.getPlaylist(i));
        }       
    }
    
    /*
    Accepts a name for the new playlist from the user.
    */
    private static void createPlaylist() {
        System.out.println("Enter a name for your new Playlist:- ");
        String name = input.nextLine();
        
        playlistCollection.addPlaylist(new Playlist(name));
        System.out.println("Playlist created.");
    }
    
    /*
    Allows the users to modify an already existing playlist.
    give choice between renaming the playlist, adding songs, or removing songs.
    */
    private static void editPlaylist() {
        if (playlistCollection.getPlaylists().isEmpty()) {
            System.out.println("There are no playlists to edit");
            return;
        }
        
        displayPlaylists();
        System.out.println("Select a Playlist:- ");
        int index = readUserOption(1, playlistCollection.getPlaylists().size()) - 1;
        Playlist selectedPlaylist = playlistCollection.getPlaylist(index);
        
        System.out.println("1. Rename Playlist");
        System.out.println("2. Add a Song");
        System.out.println("3. Remove a Song");
        System.out.println("Choose an option from above:- ");
        
        int choice = readUserOption(1,3);
        
        if (choice == 1) {
            System.out.println("Enter new Playlist name:- ");
            selectedPlaylist.setName(input.nextLine());
        } else if (choice == 2) {
            addSongToPlaylist(selectedPlaylist);
        } else {
            removeSongFromPlaylist(selectedPlaylist);
        }
    }
    
    /*
    Takes input from the user and searches it in the music library.
    */
    private static void addSongToPlaylist(Playlist playlist) {
        System.out.println("Enter a song title to search for:- ");
        String term = input.nextLine();
        
        ArrayList<Song> results = musicLibrary.searchByTitle(term);
        
        if (results.isEmpty()) {
            System.out.println("No matching songs found.");
            return;
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }
        
        System.out.println("Select a song to add:- ");
        int choice = readUserOption(1, results.size()) - 1;
        playlist.addSong(results.get(choice));
    }
    
    /*
    Displays all the songs in the selected playlist
    and allows the user to remove one by searching through it's number.
    */
    private static void removeSongFromPlaylist(Playlist playlist) {
        if (playlist.getSongs().isEmpty()) {
            System.out.println("This playlist has no songs.");
            return;
        }
        
        // does not allow removal is the playlist comes out to be empty.
        
        for (int i = 0; i < playlist.getSongs().size(); i++) {
            System.out.println((i + 1) + ". " + playlist.getSongs().get(i));
        }
        
        System.out.println("Select a song to remove:- ");
        int choice = readUserOption(1, playlist.getSongs().size()) - 1;
        playlist.removeSong(choice);
    }
    
    /*
    Removes a playlist selected by the user and if the
    playist does not exists, the action will not be allowed.
    */
    private static void deletePlaylist() {
        if (playlistCollection.getPlaylists().isEmpty()) {
            System.out.println("There are no playlists to delete.");
            return;
        }
        
        displayPlaylists();
        System.out.println("Select a playlist to remove:- ");
        int index = readUserOption(1, playlistCollection.getPlaylists().size()) - 1;
        playlistCollection.removePlaylist(index);
    }
    
    /*
    Reads and validates numeric inputs from the user,
    also ensures that the entered values is within the specified rangs.
    */
    private static int readUserOption(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(input.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Please try again:- ");
        }
    }
}

