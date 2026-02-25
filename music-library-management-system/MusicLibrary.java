/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// importing ArrayList
import java.util.ArrayList;

/**
 *Stores and Manages all the song already available in the application.
 * 
 * This class looks out for holding the music library
 * and providing functionality to the search songs by title.
 */
public class MusicLibrary {
    
    // List containing all of the songs present in the music library.
    private ArrayList<Song> songList;
    
    // Creates an empty music library.
    public MusicLibrary() {
        songList = new ArrayList<>();
    }
    
    // Adds a song to the music library, and only adds valid songs.
    public void addSong(Song song) {
        if (song != null) {
            songList.add(song);
        }
    }
    
    /*
    Searches the music library for the songs whose title matches the search term.
    */
    public ArrayList<Song> searchByTitle(String searchTerm) {
        ArrayList<Song> results = new ArrayList<>();
        
        for (Song currentSong : songList) {
            if (currentSong.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(currentSong);
            }
        }
        
        return results;
    }
    
    public ArrayList<Song> searchByGenre(String genre) {
    ArrayList<Song> results = new ArrayList<>();

    for (Song s : songList) {
        if (s.getGenre().equalsIgnoreCase(genre)) {
            results.add(s);
        }
    }
    return results;
}

}
