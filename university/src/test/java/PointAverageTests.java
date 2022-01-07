
import enums.Subjects;
import model.University;
import org.junit.Test;

import static enums.Subjects.PHILOSOPHY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointAverageTests {

    private final ReadyUniversity group = new ReadyUniversity();

    @Test
    public void shouldGetPointAverageOfOneStudentByAllSubjects() {
        assertEquals(3, group.getPointAverageOfOneStudentByAllSubjects(1, "Building", "model.Group Two"));
    }

    @Test
    public void shouldGetPointAverageOfAllStudentsByOneSubjectInOneGroup() {
        assertEquals(6, group.getPointAverageOfAllStudentsByOneSubjectInOneGroup("Building", "model.Group One", Subjects.PHYSICS));
    }

    @Test
    public void shouldGetPointAverageOfAllStudentsByOneSubjectInFaculty() {
        assertEquals(3.6, group.getPointAverageOfAllStudentsByOneSubjectInFaculty("Building", PHILOSOPHY));
    }

    @Test
    public void shouldGetPointAverageOfAllStudentsByOneSubjectInUniversity() {
        assertEquals(2.5, group.getPointAverageOfAllStudentsByOneSubjectInUniversity(Subjects.MATHEMATICS));
    }
}
