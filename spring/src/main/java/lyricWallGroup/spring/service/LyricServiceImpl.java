package lyricWallGroup.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyricWallGroup.spring.dao.LyricDao;
import lyricWallGroup.spring.entity.Lyric;

@Service
public class LyricServiceImpl implements LyricService {
    
    private final LyricDao dao;

    @Autowired
    public LyricServiceImpl(LyricDao dao) {
        //実装クラスのインスタンスがDIされる
        this.dao = dao;
    }

    @Override
    public List<Lyric> getSongs(String artistName) {
        // TODO Auto-generated method stub
        return dao.getSongs(artistName);
    }

    @Override
    public void insertSongs(List<Lyric> list) {
        // TODO Auto-generated method stub
        dao.insertSongs(list);
    }


}