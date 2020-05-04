CREATE TABLE IF NOT EXISTS lyricTable (
    artist VARCHAR(32),
    title VARCHAR(32),
    words_writer VARCHAR(16),
    music_composer VARCHAR(16),
    lyric VARCHAR(1024),
    url VARCHAR(256),
    PRIMARY KEY (artist,title)
);