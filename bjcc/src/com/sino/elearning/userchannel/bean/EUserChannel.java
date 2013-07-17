package com.sino.elearning.userchannel.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户专题
 * EUserChannel entity. @author MyEclipse Persistence Tools
 */

public class EUserChannel implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private Long channelId;

	// Constructors

	/** default constructor */
	public EUserChannel() {
	}

	/** full constructor */
	public EUserChannel(Long id, Long userId, Long channelId) {
		this.id = id;
		this.userId = userId;
		this.channelId = channelId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
}