package com.maciej.imiela.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Course;
import com.maciej.imiela.entity.User;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    public List<Course> findByParticipantsUserId(int id);

    public List<Course> findByParticipantsUserIdAndParticipantsAccepted(int id,
            boolean accepted);

    public List<Course> findByStartDateAfter(Date date);

    public List<Course> findByTeacherUser(User user);

}
