package lyricWallGroup.spring.app.form;

import javax.validation.constraints.NotNull;

public class SearchForm {
    @NotNull(message="歌手名を入力してください")
    private String artistName;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    
    public SearchForm() {
    }

    public SearchForm(@NotNull(message = "歌手名を入力してください") String artistName) {
        this.artistName = artistName;
    }

}