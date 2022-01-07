package model;

import exception.NoSubjectsException;

import java.util.List;

public class Student {

    private final int id;
    private List<Subject> subjectList;

    public Student(int id, List<Subject> subjectList) {

        this.id = id;
        this.subjectList = subjectList;

        if (subjectList.isEmpty()) {
            throw new NoSubjectsException("List of students is empty");
        }
    }

    public int getId() {
        return id;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
}
