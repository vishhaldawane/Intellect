import java.util.*;

class Song
{
	private String title;
	private String artist;
	private String album;
	private int year;
	
	public Song(String title, String artist, String album, int year) {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", album=" + album + ", year=" + year + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}

public class ArrayListTest {
	public static void main(String[] args) {
		//play list in the media player - vlc / windows / iphone
		//content
		//Song mysongs [] = new Song[100];
		
		System.out.println("Preparing content.....");
		Song s1 = new Song("My Heart Will Go On","Celine D","Titanic",1996);
		Song s2 = new Song("Lungi Dance","Honey Singh","Chennai Express",2014);
		Song s3 = new Song("Kolavari","Dhanush","Private",2018);
		Song s4 = new Song("Zhingat","AjayAtul","Sairat",2015);
		Song s5 = new Song("Ae dil hai Mushkil","Arijit Singh","Ae dil hai Mushkil",2016);
		System.out.println("Content is ready........");
		
		System.out.println("Making the Container....");
		ArrayList myJukeBox = new ArrayList();
		System.out.println("Container....is ready...");
		
		System.out.println("Adding the Content in the Container....");
		myJukeBox.add(s1);
		myJukeBox.add(s2);
		myJukeBox.add(s3);
		myJukeBox.add(s4);
		myJukeBox.add(s5);
		System.out.println("Added all the Content in the Container....");
		
		System.out.println("Retriving the Iterator from the Container....");
		Iterator myIterator = myJukeBox.iterator();
		System.out.println("Iterating through the Container....");
		while(myIterator.hasNext())
		{
			Object o = myIterator.next(); // windows button and + <---zoom in
							//windows button and - <---zoom out
			Song x = (Song) o; // casting of Object to Song
			System.out.println("Song : "+x);
		}
		
		System.out.println("End of main....");
	}
}











