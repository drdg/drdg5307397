package com.sino.bjcc.media.bean;

public class Video {
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getPlay_url() {
		return play_url;
	}
	public void setPlay_url(String playUrl) {
		play_url = playUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private long id;
	private String name;
	private String state;
	private String channel;
	private String play_url;

	private long program_id;
	public long getProgram_id() {
		return program_id;
	}
	public void setProgram_id(long programId) {
		program_id = programId;
	}
/*	private Program program;
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		program = program;
	}*/
}
