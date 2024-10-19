package kz.example.skills1mprove_bot.repository;

import kz.example.skills1mprove_bot.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
}
