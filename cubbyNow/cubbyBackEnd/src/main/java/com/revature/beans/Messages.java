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
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="writer_id")
	private User writer;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="receiver_id")
	private User receiver;
	@Column(name="message_date")
	private LocalDateTime message_date;
	@Override
	public String toString() {
		return "Messages [id=" + id + ", content=" + content + ", writer=" + writer + ", receiver=" + receiver
				+ ", message_date=" + message_date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message_date == null) ? 0 : message_date.hashCode());
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
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
	public User getWriter() {
		return writer;
	}
	public void setWriter(User writer) {
		this.writer = writer;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
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
		receiver = new User();
		writer = new User();
		content = "";
	}
}
