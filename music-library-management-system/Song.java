

/**
 *This class represents a simple song in the music application.
 * Stores basic information about the song like Title,
 * its Artist and the Run Time (duration of song). 
 */
public class Song {
    
    // The title of the song
    private String title;
    private String genre;
    
    // The Artist of the song
    private String artist;
    
    // Duration of the song in seconds
    private int runTimeSeconds;
    
    //Constructors of the new song given by the user
    public Song(String title, String artist, int runTimeSeconds, String genre) {
        this.title = title;
        this.artist = artist;
        this.runTimeSeconds = runTimeSeconds;
        this.genre = genre;
    }
    
    // Returns the title of the song
    public String getTitle() {
        return title;
    }
    
    // Returns the artist of the song
    public String getArtist() {
        return artist;
    }
    
    // Returns the Duration of the song
    public int getRunTime() {
        return runTimeSeconds;
    }
    
    // Returns the genre of the song
public String getGenre() {
    return genre;
}

    
    // Return a string consists of Title, artist and Run time
    @Override
    public String toString() {
        return title + "-" + artist + "(" + runTimeSeconds + "s. " + genre + ")";   
    }
}

