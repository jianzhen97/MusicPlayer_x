package com.lenovo.vo;

public class SongInfo {
	String song;
	String singer;
	

	String url;

	public SongInfo(String song, String singer,String url) {
		this.song = song;
		this.singer = singer;
		this.url=url;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
