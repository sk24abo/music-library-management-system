/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 * Manages a collection of playlists created by the user.
 * This class is responsible for storing, accesing, and removing
 * playlists, but does not take user inputs.
 */
public class PlaylistCollection {
    
    // a list which stores all playlists.
    private ArrayList<Playlist> playlists;
    
    // creates an empty playlist collection.
    public PlaylistCollection() {
        playlists = new ArrayList<>();
    }
    
    // Adds a new playlist to the collection.
    public void addPlaylist(Playlist newPlaylist) {
        if (newPlaylist != null) {
            playlists.add(newPlaylist);
        }
    }
    
    // Removes a playlist from the collection using a zero-based index.
    public void removePlaylist(int index) {
        if (index >= 0 && index < playlists.size()) {
            playlists.remove(index);
        }
    }
    
    // Returns the playlist at the specfic index.
    public Playlist getPlaylist(int index) {
        return playlists.get(index);
    }
    
    /* Returns a string representation of the playlist collection,
    listing the names of all playlists.
    */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
    
    /*
    Returns a string that represents the playlist collection,
    listing the names of all playlists.
    */
    @Override
    public String toString() {
        String output = "";
        for (Playlist p : playlists) {
            output += p.getName() + "\n";
        }
        return output;
    }
}
