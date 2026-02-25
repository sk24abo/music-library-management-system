

// Importing ArrayList
import java.util.ArrayList;

/**
 * Represents a playlist created by the user.
 * 
 * a playlist had a name and an ordered list of songs
 * Songs can be added, removed and reordered within the playlist.
 */
public class Playlist {
    
    // the name of the playlist
    private String playlistName;
    // List of songs inside the playlist
    private ArrayList<Song> trackList;
    
    // Creates a new empty playlist with the name provided by the user.
    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.trackList = new ArrayList<>();
    }
    
    // Creates a new playlist by copying the content of another playlist.
    public Playlist(String playlistName, Playlist playlistToCopy) {
        this.playlistName = playlistName;
        this.trackList = new ArrayList<>(playlistToCopy.trackList);
    }
    
    // return the name of the playlist
    public String getName() {
        return playlistName;
    }
    
    //Updates the name of the playlist
    public void setName(String newName) {
        this.playlistName = newName;
    }
    
    // Adds a song at the end of the playlist.
    public void addSong(Song song) {
        if (song != null) {
            trackList.add(song);
        }
    }
    
    // Remove a song from the playlist using a zero-based index unless the index is invalid.
    public void removeSong(int index) {
        if (index >= 0 && index < trackList.size()) {
            trackList.remove(index);
        }
    }
    
    /*
    Moves a song from one position to another
    within the playlist.
    Both positions use zero-Based indexing.
    */
    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < trackList.size()
                && toIndex >= 0 && toIndex < trackList.size()) {

            Song songToMove = trackList.remove(fromIndex);
            trackList.add(toIndex, songToMove);           
        }
    }
    
    // Calculates and returns the total run time of all songs in the playlist.
    public int getTotalRunTime() {
        int totalTime = 0;
        
        for (Song currentSong : trackList) {
            totalTime += currentSong.getRunTime();
        }
        
        return totalTime;
    }
    
    /*
    Returns the list of songs in the playlist.
    This is used by the user interface to display playlist content.
    */
    public ArrayList<Song> getSongs() {
        return trackList;
    }
    
    // IMPORTANT
    public void toBottom(int index) {
        if (index >= 0 && index < trackList.size()) {
            Song s = trackList.remove(index);
            trackList.add(s);
        }
    }
    
    // Returns a string of playlist including its name and total run time.
    @Override
    public String toString() {
        return "Playlist:" + playlistName + "| Total time: " + getTotalRunTime() + "seconds";
    }
}

/*
// Searches the music library for songs matching a genre
public ArrayList<Song> searchByGenre(String genre) {
    ArrayList<Song> results = new ArrayList<>();

    for (Song currentSong : songList) {
        if (currentSong.getGenre().equalsIgnoreCase(genre)) {
            results.add(currentSong);
        }
    }

    return results;
}

*/

