package lyricWallGroup.spring.app.form;

import javax.validation.constraints.NotNull;

public class InsertForm {
    @NotNull(message="登録には歌手名の入力は必須です")
    private String artistName;

    @NotNull(message = "登録には曲名の入力は必須です")
    private String title;

    private String wordsWriter;
    private String musicComposer;
    private String lyric;
    private String url;

    public InsertForm() {
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWordsWriter() {
        return wordsWriter;
    }

    public void setWordsWriter(String wordsWriter) {
        this.wordsWriter = wordsWriter;
    }

    public String getMusicComposer() {
        return musicComposer;
    }

    public void setMusicComposer(String musicComposer) {
        this.musicComposer = musicComposer;
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

    public InsertForm(@NotNull(message = "登録には歌手名の入力は必須です") String artistName,
            @NotNull(message = "登録には曲名の入力は必須です") String title, String wordsWriter, String musicComposer, String lyric,
            String url) {
        this.artistName = artistName;
        this.title = title;
        this.wordsWriter = wordsWriter;
        this.musicComposer = musicComposer;
        this.lyric = lyric;
        this.url = url;
    }
}