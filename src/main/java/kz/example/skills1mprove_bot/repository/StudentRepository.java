package kz.example.skills1mprove_bot.repository;

import kz.example.skills1mprove_bot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
