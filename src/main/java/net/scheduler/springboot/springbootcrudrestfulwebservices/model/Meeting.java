package net.scheduler.springboot.springbootcrudrestfulwebservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meetings")
public class Meeting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="start")
	private String start;
	
	@Column(name="end")
	private String end;
	
	@Column(name="room_id")
	private long roomId;
	
	@Column(name="name")
	private String name;
	
	public Meeting() {
		super();
	}

	public Meeting(long id, String start, String end, long roomId, String name) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.roomId = roomId;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
