package kz.example.skills1mprove_bot.model;
import jakarta.persistence.Entity;
@Entity
public class Teacher extends User {
    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
