package com.sino.elearning.userstore.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ESinoProgram {

	private Long id;
	private String name;
	private String englishName;
	private String orgCode;
	private String channel;
	private String provider;
	private String length;
	private String director;
	private String cast;
	private String role;
	private String releaseDate;
	private Long episodes;
	private Date createDate;
	private Date updateDate;
	private String summary;
	private String other;
	private String memo;
	private String middleImage;
	private String smallImage;
	private String largerImage;
	private String tags;
	private String type;
	private Long allowDown;
	private Long providerOrgId;
	private Long audienceGroupId;
	private Long mediaTypeId;
	private Long collectSourceId;
	private Long countryId;

	private Set abs = new HashSet(0);

	public ESinoProgram() {
		super();
	}
	
	public ESinoProgram(Long id, String name, String englishName,
			String orgCode, String channel, String provider, String length,
			String director, String cast, String role, String releaseDate,
			Long episodes, Date createDate, Date updateDate, String summary,
			String other, String memo, String middleImage, String smallImage,
			String largerImage, String tags, String type, Long allowDown,
			Long providerOrgId, Long audienceGroupId, Long mediaTypeId,
			Long collectSourceId, Long countryId, Set abs) {
		super();
		this.id = id;
		this.name = name;
		this.englishName = englishName;
		this.orgCode = orgCode;
		this.channel = channel;
		this.provider = provider;
		this.length = length;
		this.director = director;
		this.cast = cast;
		this.role = role;
		this.releaseDate = releaseDate;
		this.episodes = episodes;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.summary = summary;
		this.other = other;
		this.memo = memo;
		this.middleImage = middleImage;
		this.smallImage = smallImage;
		this.largerImage = largerImage;
		this.tags = tags;
		this.type = type;
		this.allowDown = allowDown;
		this.providerOrgId = providerOrgId;
		this.audienceGroupId = audienceGroupId;
		this.mediaTypeId = mediaTypeId;
		this.collectSourceId = collectSourceId;
		this.countryId = countryId;
		this.abs = abs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
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

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Long episodes) {
		this.episodes = episodes;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMiddleImage() {
		return middleImage;
	}

	public void setMiddleImage(String middleImage) {
		this.middleImage = middleImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getLargerImage() {
		return largerImage;
	}

	public void setLargerImage(String largerImage) {
		this.largerImage = largerImage;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAllowDown() {
		return allowDown;
	}

	public void setAllowDown(Long allowDown) {
		this.allowDown = allowDown;
	}

	public Long getProviderOrgId() {
		return providerOrgId;
	}

	public void setProviderOrgId(Long providerOrgId) {
		this.providerOrgId = providerOrgId;
	}

	public Long getAudienceGroupId() {
		return audienceGroupId;
	}

	public void setAudienceGroupId(Long audienceGroupId) {
		this.audienceGroupId = audienceGroupId;
	}

	public Long getMediaTypeId() {
		return mediaTypeId;
	}

	public void setMediaTypeId(Long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	public Long getCollectSourceId() {
		return collectSourceId;
	}

	public void setCollectSourceId(Long collectSourceId) {
		this.collectSourceId = collectSourceId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Set getAbs() {
		return abs;
	}

	public void setAbs(Set abs) {
		this.abs = abs;
	}

	
}
