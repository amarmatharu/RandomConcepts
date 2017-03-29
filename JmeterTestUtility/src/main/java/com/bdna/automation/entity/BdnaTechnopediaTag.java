package com.bdna.automation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 */
@Entity
@Table(name = "BDNA_TECHNOPEDIA_TAG")
public class BdnaTechnopediaTag {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BDNA_TECHNOPEDIA_TAG_ID", length = 35)
	private long bdnaTechTag;

	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;

	@Column(name = "LAST_MODIFIED_DATE", nullable = false)
	private Date lastMdfDate;

	@Column(name = "CAT_TAG_ID", nullable = false)
	private int catTagID;

	@Column(name = "CAT_TAG_SHORTNAME", nullable = false, length = 35)
	private String catTagShortName;

	@Column(name = "IS_SUBSCRIBED", nullable = false, length = 100)
	private String isSubscribed;

	@Column(name = "BDNA_SUBSCRIPTION_ID", nullable = false, length = 35)
	private int bdnaSubscriptionId;

	public long getBdnaTechTag() {
		return bdnaTechTag;
	}

	public void setBdnaTechTag(long bdnaTechTag) {
		this.bdnaTechTag = bdnaTechTag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastMdfDate() {
		return lastMdfDate;
	}

	public void setLastMdfDate(Date lastMdfDate) {
		this.lastMdfDate = lastMdfDate;
	}

	public int getCatTagID() {
		return catTagID;
	}

	public void setCatTagID(int catTagID) {
		this.catTagID = catTagID;
	}

	public String getCatTagShortName() {
		return catTagShortName;
	}

	public void setCatTagShortName(String catTagShortName) {
		this.catTagShortName = catTagShortName;
	}

	public String getIsSubscribed() {
		return isSubscribed;
	}

	public void setIsSubscribed(String isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	public int getBdnaSubscriptionId() {
		return bdnaSubscriptionId;
	}

	public void setBdnaSubscriptionId(int bdnaSubscriptionId) {
		this.bdnaSubscriptionId = bdnaSubscriptionId;
	}

	@Override
	public String toString() {
		return "BdnaTechnopediaTag [bdnaTechTag=" + bdnaTechTag + ", createDate=" + createDate + ", lastMdfDate="
				+ lastMdfDate + ", catTagID=" + catTagID + ", catTagShortName=" + catTagShortName + ", isSubscribed="
				+ isSubscribed + ", bdnaSubscriptionId=" + bdnaSubscriptionId + "]";
	}

}
