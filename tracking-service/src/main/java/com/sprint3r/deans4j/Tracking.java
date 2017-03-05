package com.sprint3r.deans4j;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tracking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String tackingNumber;
	
	private Date sentDate;
	
	private Long orderId;
	
    protected Tracking() {
    }

    public Tracking(String tackingNumber, Date sentDate, Long orderId) {
        this(null, tackingNumber, sentDate, orderId);
    }

    Tracking(Long id, String tackingNumber, Date sentDate, Long orderId) {
        this.id = id;
        this.tackingNumber = tackingNumber;
        this.sentDate = sentDate;
        this.orderId = orderId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTackingNumber() {
		return tackingNumber;
	}

	public void setTackingNumber(String tackingNumber) {
		this.tackingNumber = tackingNumber;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
