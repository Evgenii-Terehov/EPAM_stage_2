import enums.Subjects;
import exception.NoFacultiesInUniversity;
import exception.NoGroupsInFacultyException;
import exception.NoStudentsInGroupException;
import impl.IUniversity;
import model.Student;
import model.Subject;
import model.University;

import java.util.List;
import java.util.Map;

public class ReadyUniversity implements IUniversity {

    private final University doneUniversity = new University();

    @Override
    public double getPointAverageOfOneStudentByAllSubjects(int idStudent, String faculty, String group) {
        int pointAverage = 0;
        if (doneUniversity.addingGroupsInFaculties().isEmpty()) {
            throw new NoFacultiesInUniversity("University has no faculties");
        }
        if (faculty == null || faculty.isEmpty()) {
            throw new NoGroupsInFacultyException("Faculty has no groups");
        }
        if (doneUniversity.getGroupBuildingOne().isEmpty() || doneUniversity.getGroupBuildingTwo().isEmpty()
                || doneUniversity.getGroupEconomicOne().isEmpty()) {
            throw new NoStudentsInGroupException("Group has no students");
        }
        for (Map.Entry<String, List<Student>> stringListEntry : doneUniversity.addingGroupsInFaculties().entrySet()) {
            if (stringListEntry.getKey().contains(faculty) && stringListEntry.getKey().contains(group)) {
                for (Student student : stringListEntry.getValue()) {
                    if (student.getId() == idStudent) {
                        pointAverage += student.getSubjectList().stream()
                                .mapToDouble(Subject::getPointAverage)
                                .sum();
                        pointAverage /= student.getSubjectList().size();
                    }
                }
            }
        }
        return pointAverage;
    }

    @Override
    public double getPointAverageOfAllStudentsByOneSubjectInOneGroup(String faculty, String group, Subjects subject) {
        double pointAverage = 0;
        int point = 0;
        if (doneUniversity.addingGroupsInFaculties().isEmpty()) {
            throw new NoFacultiesInUniversity("University has no faculties");
        }
        if (faculty == null || faculty.isEmpty()) {
            throw new NoGroupsInFacultyException("Faculty has no groups");
        }
        if (doneUniversity.getGroupBuildingOne().isEmpty() || doneUniversity.getGroupBuildingTwo().isEmpty()
                || doneUniversity.getGroupEconomicOne().isEmpty()) {
            throw new NoStudentsInGroupException("Group has no students");
        }
        for (Map.Entry<String, List<Student>> stringListEntry : doneUniversity.addingGroupsInFaculties().entrySet()) {
            if (stringListEntry.getKey().contains(faculty) && stringListEntry.getKey().contains(group)) {
                for (Student student : stringListEntry.getValue()) {
                    pointAverage += student.getSubjectList().stream()
                            .filter(o -> o.getSubjects().equals(subject))
                            .mapToDouble(Subject::getPointAverage)
                            .sum();
                    point++;
                }
            }
        }
        return pointAverage / point;
    }

    @Override
    public double getPointAverageOfAllStudentsByOneSubjectInFaculty(String faculty, Subjects subject) {
        double pointAverage = 0;
        int point = 0;
        if (doneUniversity.addingGroupsInFaculties().isEmpty()) {
            throw new NoFacultiesInUniversity("University has no faculties");
        }
        if (faculty == null || faculty.isEmpty()) {
            throw new NoGroupsInFacultyException("Faculty has no groups");
        }
        if (doneUniversity.getGroupBuildingOne().isEmpty() || doneUniversity.getGroupBuildingTwo().isEmpty()
                || doneUniversity.getGroupEconomicOne().isEmpty()) {
            throw new NoStudentsInGroupException("Group has no students");
        }
        for (Map.Entry<String, List<Student>> stringListEntry : doneUniversity.addingGroupsInFaculties().entrySet()) {
            if (stringListEntry.getKey().contains(faculty)) {
                for (Student student : stringListEntry.getValue()) {
                    pointAverage += student.getSubjectList().stream()
                            .filter(o -> o.getSubjects().equals(subject))
                            .mapToDouble(Subject::getPointAverage)
                            .sum();
                    point++;
                }
            }
        }
        return pointAverage / point;
    }

    @Override
    public double getPointAverageOfAllStudentsByOneSubjectInUniversity(Subjects subject) {
        double pointAverage = 0;
        int point = 0;
        if (doneUniversity.addingGroupsInFaculties().isEmpty()) {
            throw new NoFacultiesInUniversity("University has no faculties");
        }
        if (doneUniversity.getGroupBuildingOne().isEmpty() || doneUniversity.getGroupBuildingTwo().isEmpty()
                || doneUniversity.getGroupEconomicOne().isEmpty()) {
            throw new NoStudentsInGroupException("Group has no students");
        }
        for (Map.Entry<String, List<Student>> stringListEntry : doneUniversity.addingGroupsInFaculties().entrySet()) {
            for (Student student : stringListEntry.getValue()) {
                pointAverage += student.getSubjectList().stream()
                        .filter(o -> o.getSubjects().equals(subject))
                        .mapToDouble(Subject::getPointAverage)
                        .sum();
                point++;
            }
        }
        return pointAverage / point;
    }
}
