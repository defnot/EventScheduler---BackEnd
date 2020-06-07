package net.scheduler.springboot.springbootcrudrestfulwebservices.repository;

import org.springframework.stereotype.Repository;

import net.scheduler.springboot.springbootcrudrestfulwebservices.model.Meeting;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
	
}
