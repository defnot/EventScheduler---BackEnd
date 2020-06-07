package net.scheduler.springboot.springbootcrudrestfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.antkorwin.xsync.XSync;

import net.scheduler.springboot.springbootcrudrestfulwebservices.exception.ResourceNotFoundException;
import net.scheduler.springboot.springbootcrudrestfulwebservices.model.Meeting;
import net.scheduler.springboot.springbootcrudrestfulwebservices.repository.MeetingRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MeetingController {
	@Autowired
	private MeetingRepository meetingRepository;
	
	//create get all meetings api
	@GetMapping("/meetings")
	@CrossOrigin(origins = "localhost:4200")
	public List<Meeting> getAllMeetings() {
		return meetingRepository.findAll();
	}
	
	//create meeting
	@PostMapping("/meetings")
	@CrossOrigin(origins = "localhost:4200")
	public Meeting createMeeting(@RequestBody Meeting meeting) {
		return meetingRepository.save(meeting);
	}
	
	@GetMapping("meetings/{id}")
	@CrossOrigin(origins = "localhost:4200")
	public ResponseEntity<Meeting> getMeetingById(@PathVariable(value = "id") long meetingId) throws ResourceNotFoundException {
		Meeting meeting = meetingRepository.findById(meetingId).orElseThrow(() -> new ResourceNotFoundException("Meeting not found by id: " + meetingId));
		
		return ResponseEntity.ok().body(meeting);
	}
	
	@Autowired
	private XSync<String> xSync;
	
	@PutMapping("/meetings/{id}")
	@CrossOrigin(origins = "localhost:4200")
	public ResponseEntity<Meeting> updateMeeting(@PathVariable(value = "id") long meetingId, @RequestBody Meeting meetingDetails) throws ResourceNotFoundException {
		Meeting meeting = meetingRepository.findById(meetingId).orElseThrow(() -> new ResourceNotFoundException("Meeting not found by id: " + meetingId));
		
		meeting.setName(meetingDetails.getName());
		meeting.setStart(meetingDetails.getStart());
		meeting.setEnd(meetingDetails.getEnd());
		meeting.setRoomId(meetingDetails.getRoomId());
		
		xSync.execute(new String("key"), () -> meetingRepository.save(meeting));
		
		
		
		return ResponseEntity.ok().body(meeting);
	}
	
	@DeleteMapping("meetings/{id}")
	@CrossOrigin(origins = "localhost:4200")
	public ResponseEntity<Meeting> deleteMeeting(@PathVariable(value = "id") long meetingId) throws ResourceNotFoundException {
		meetingRepository.findById(meetingId).orElseThrow(() -> new ResourceNotFoundException("Meeting not found by id: " + meetingId));
		
		meetingRepository.deleteById(meetingId);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	//getMeetingById
	//update meeting by id
	//delete meeting by id
	
	
	

}
