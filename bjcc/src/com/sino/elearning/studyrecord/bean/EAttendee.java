package com.sino.elearning.studyrecord.bean;

import java.math.BigDecimal;

/**
 * AbstractEAttendee entity provides the base persistence definition of the
 * EAttendee entity. @author MyEclipse Persistence Tools
 */

public class EAttendee implements java.io.Serializable {

	// Fields

	private Long attendeeId;
	private Long trainId;
	private Long userid;
	private String attendee;
	private ETrainMessage trainMessage;
	// Constructors

	/** default constructor */
	public EAttendee() {
		super();
		// TODO Auto-generated constructor stub
	}
	/** full constructor */
	public EAttendee(Long attendeeId,ETrainMessage trainMessage,
			Long trainId, Long userid, String attendee) {
		this.attendeeId = attendeeId;
		this.trainId = trainId;
		this.userid = userid;
		this.attendee = attendee;
		this.trainMessage = trainMessage;
	}

	// Property accessors

	public Long getAttendeeId() {
		return this.attendeeId;
	}

	public void setAttendeeId(Long attendeeId) {
		this.attendeeId = attendeeId;
	}

	public Long getTrainId() {
		return trainId;
	}
	
	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}
	
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getAttendee() {
		return this.attendee;
	}

	public void setAttendee(String attendee) {
		this.attendee = attendee;
	}
	public ETrainMessage getTrainMessage() {
		return trainMessage;
	}
	public void setTrainMessage(ETrainMessage trainMessage) {
		this.trainMessage = trainMessage;
	}
	
}