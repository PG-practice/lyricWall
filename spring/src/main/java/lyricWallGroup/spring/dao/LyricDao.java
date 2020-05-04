package lyricWallGroup.spring.dao;

import java.util.List;

import lyricWallGroup.spring.entity.Lyric;

public interface LyricDao {
    void insertSongs(List<Lyric> list);

    List<Lyric> getSongs(String artistName);
}