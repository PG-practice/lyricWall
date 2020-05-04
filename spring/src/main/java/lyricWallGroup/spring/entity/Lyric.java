package lyricWallGroup.spring.entity;

public class Lyric {
    private String artist;
    private String title;
    private String words_writer;
    private String music_composer;
    private String lyric;
    private String url;

    public Lyric() {
    }
    
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWords_writer() {
        return words_writer;
    }

    public void setWords_writer(String words_writer) {
        this.words_writer = words_writer;
    }

    public String getMusic_composer() {
        return music_composer;
    }

    public void setMusic_composer(String music_composer) {
        this.music_composer = music_composer;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}