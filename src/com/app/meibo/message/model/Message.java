package com.app.meibo.message.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.app.permission.model.User;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-27 下午11:46:51
 */
@Entity
@Table(name = "message")
public class Message {

	private Integer id;
	private List<User> users;
	private Integer sendUserId;
	private String title;
	private String content;
	private Date createDate;
	private int messageType;
	private int isDelete = 0;// 是否放入回收站 0：否，1：是
	private int isRead = 0;// 是否已读 0：未读，1：已读

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	/**
	 * 用户集合
	 * 
	 * @return
	 */
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_message", joinColumns = { @JoinColumn(name = "message_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSendUserId() {
		return sendUserId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setSendUserId(Integer sendUserId) {
		this.sendUserId = sendUserId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 是否放入回收站 0：否，1：是
	 * 
	 * @return
	 */
	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
}
