package impl;

import enums.Subjects;

public interface IUniversity {

    double getPointAverageOfOneStudentByAllSubjects(int idStudent, String faculty, String group);

    double getPointAverageOfAllStudentsByOneSubjectInOneGroup(String faculty, String group, Subjects subject);

    double getPointAverageOfAllStudentsByOneSubjectInFaculty(String faculty, Subjects subject);

    double getPointAverageOfAllStudentsByOneSubjectInUniversity(Subjects subject);
}
