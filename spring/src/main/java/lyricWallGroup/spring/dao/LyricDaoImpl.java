package lyricWallGroup.spring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lyricWallGroup.spring.entity.Lyric;

@Repository
public class LyricDaoImpl implements LyricDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LyricDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Lyric> getSongs(String artistName) {
        // SQLインジェクション対策でpreparedStatementに書き換えること
        String sql = "SELECT * FROM lyricTable WHERE artist='" + artistName + "';";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

        List<Lyric> list = new ArrayList<Lyric>();
        for(Map<String, Object> result:resultList){
            Lyric lyric = new Lyric();
            lyric.setArtist((String)result.get("artist"));
            lyric.setTitle((String)result.get("title"));
            lyric.setWords_writer((String)result.get("words_writer"));
            lyric.setMusic_composer((String)result.get("music_composer"));
            lyric.setLyric((String)result.get("lyric"));
            lyric.setUrl((String)result.get("url"));
            list.add(lyric);
        }
        return list;
    }

    @Override
    public void insertSongs(List<Lyric> list) {
        String sql = "INSERT INTO lyricTable VALUES (?,?,?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter(){
        
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Lyric lyric = list.get(i);
                ps.setString(1, lyric.getArtist());
                ps.setString(2, lyric.getTitle());
                ps.setString(3, lyric.getWords_writer());
                ps.setString(4, lyric.getMusic_composer());
                ps.setString(5, lyric.getLyric());
                ps.setString(6, lyric.getUrl());
            }
        
            @Override
            public int getBatchSize() {
                return list.size();
            }
        });

    }

    
}