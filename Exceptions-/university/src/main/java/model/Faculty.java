package model;

import exception.NoStudentsInGroupException;

import java.util.List;

public class Faculty {

    private Faculty faculty;
    private List<Group> groupsList;

    public Faculty(Faculty faculty, List<Group> groupList) {
        this.faculty = faculty;
        this.groupsList = groupList;

        if (groupList.isEmpty()) {
            throw new NoStudentsInGroupException("Group has no students");
        }
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<Group> getGroupsList() {
        return groupsList;
    }
}
