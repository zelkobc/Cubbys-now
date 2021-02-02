package com.revature.beans;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="messages")
public class Messages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="mcontent")
	private String content;
	@Column(name="writer_id")
	private Integer writerid;
	@Column(name="receiver_id")
	private Integer receiverid;
	@Column(name="message_date")
	private LocalDateTime message_date;
	@Override
	public String toString() {
		return "Messages [id=" + id + ", content=" + content + ", writerid=" + writerid + ", receiverid=" + receiverid
				+ ", message_date=" + message_date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message_date == null) ? 0 : message_date.hashCode());
		result = prime * result + ((receiverid == null) ? 0 : receiverid.hashCode());
		result = prime * result + ((writerid == null) ? 0 : writerid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Messages other = (Messages) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message_date == null) {
			if (other.message_date != null)
				return false;
		} else if (!message_date.equals(other.message_date))
			return false;
		if (receiverid == null) {
			if (other.receiverid != null)
				return false;
		} else if (!receiverid.equals(other.receiverid))
			return false;
		if (writerid == null) {
			if (other.writerid != null)
				return false;
		} else if (!writerid.equals(other.writerid))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getWriterid() {
		return writerid;
	}
	public void setWriterid(Integer writerid) {
		this.writerid = writerid;
	}
	public Integer getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(Integer receiverid) {
		this.receiverid = receiverid;
	}
	public LocalDateTime getMessage_date() {
		return message_date;
	}
	public void setMessage_date(LocalDateTime message_date) {
		this.message_date = message_date;
	}
	@Autowired
	public Messages() {
		id = 0;
		message_date = LocalDateTime.now();
		receiverid = -1;
		writerid = -1;
		content = "";
	}
}
