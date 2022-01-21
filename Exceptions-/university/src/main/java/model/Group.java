package model;

import enums.Subjects;
import exception.NoStudentsInGroupException;

import java.util.Arrays;
import java.util.List;

public class Group {

    private String group;
    private List<Student> studentsList;

    public Group(String group, List<Student> studentList) {

        this.group = group;
        this.studentsList = studentList;
        if (studentList.isEmpty()){
            throw new NoStudentsInGroupException("Group has no students");
        }
    }

    public String getGroup() {
        return group;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }
}
