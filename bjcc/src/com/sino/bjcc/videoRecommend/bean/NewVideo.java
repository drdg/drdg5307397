package com.sino.bjcc.videoRecommend.bean;

import java.util.Date;

public class NewVideo {

	private Long id;
	private Long programId;
	private String name;				//视频名称
	private String sign1;
	private String sign2;
	private String orgCode;
	private String channel;				//视频所属栏目 sino_channel
	private String provider;
	private String duration;
	private String type;
	private String format;
	private Long length;
	private Long rate;
	private Long episodeNumber;
	private Long indexLen;
	private String httpUrl;
	private String playUrl;				//视频流地址
	private String downloadUrl;
	private String filePath;
	private Long status;
	private Date createDate;
	private Date updateDate;
	private Long addUserid;
	private Long updateUserid;
	private Long state;					//是否审核标识，0表示未审核，10表示已审核通过
	private String memo;
	private Long playCount;
	private Double score;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSign1() {
		return sign1;
	}
	public void setSign1(String sign1) {
		this.sign1 = sign1;
	}
	public String getSign2() {
		return sign2;
	}
	public void setSign2(String sign2) {
		this.sign2 = sign2;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	public Long getRate() {
		return rate;
	}
	public void setRate(Long rate) {
		this.rate = rate;
	}
	public Long getEpisodeNumber() {
		return episodeNumber;
	}
	public void setEpisodeNumber(Long episodeNumber) {
		this.episodeNumber = episodeNumber;
	}
	public Long getIndexLen() {
		return indexLen;
	}
	public void setIndexLen(Long indexLen) {
		this.indexLen = indexLen;
	}
	public String getHttpUrl() {
		return httpUrl;
	}
	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}
	public String getPlayUrl() {
		return playUrl;
	}
	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Long getAddUserid() {
		return addUserid;
	}
	public void setAddUserid(Long addUserid) {
		this.addUserid = addUserid;
	}
	public Long getUpdateUserid() {
		return updateUserid;
	}
	public void setUpdateUserid(Long updateUserid) {
		this.updateUserid = updateUserid;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Long getPlayCount() {
		return playCount;
	}
	public void setPlayCount(Long playCount) {
		this.playCount = playCount;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
}
