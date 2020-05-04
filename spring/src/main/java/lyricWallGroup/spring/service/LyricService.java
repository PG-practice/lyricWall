package lyricWallGroup.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lyricWallGroup.spring.entity.Lyric;

public interface LyricService {
    void insertSongs(List<Lyric> list);

    List<Lyric> getSongs(String artistName);
}