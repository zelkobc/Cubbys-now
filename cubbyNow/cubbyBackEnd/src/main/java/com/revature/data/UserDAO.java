package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	public User findUserByUsername(String username);
	
	
	@Query(value = "select teacher_student.student_id from teacher_student where teacher_student.teacher_id = ?1", nativeQuery = true)
	public List<Integer> getStudentIdsByTeacherId(Integer teacherId);
	
}
