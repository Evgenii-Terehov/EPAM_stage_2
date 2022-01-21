package model;

import enums.Subjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {

    private final Map<String, List<Student>> university = new HashMap<>();

    public Map<String, List<Student>> addingGroupsInFaculties() {
        university.put("Building model.Faculty model.Group One", groupBuildingOne());
        university.put("Building model.Faculty model.Group Two", groupBuildingTwo());
        university.put("Economic model.Faculty model.Group One", groupEconomicOne());
        return university;
    }

    private final List<Student> groupBuildingOne = new ArrayList<>();
    private final List<Student> groupBuildingTwo = new ArrayList<>();
    private final List<Student> groupEconomicOne = new ArrayList<>();

    private List<Student> groupBuildingOne() {
        groupBuildingOne.add(new Student(1, Arrays.asList(
                new Subject(Subjects.BUILDING_MECHANICS, 1),
                new Subject(Subjects.MATHEMATICS, 6),
                new Subject(Subjects.PHILOSOPHY, 3),
                new Subject(Subjects.PHYSICS, 5)
        )));
        groupBuildingOne.add(new Student(2, Arrays.asList(
                new Subject(Subjects.BUILDING_MECHANICS, 1),
                new Subject(Subjects.MATHEMATICS, 2),
                new Subject(Subjects.PHILOSOPHY, 3),
                new Subject(Subjects.PHYSICAL_CULTURE, 4),
                new Subject(Subjects.PHYSICS, 6)
        )));
        groupBuildingOne.add(new Student(3, Arrays.asList(
                new Subject(Subjects.BUILDING_MECHANICS, 1),
                new Subject(Subjects.MATHEMATICS, 2),
                new Subject(Subjects.PHILOSOPHY, 3),
                new Subject(Subjects.PHYSICS, 7)
        )));
        return groupBuildingOne;
    }

    private List<Student> groupBuildingTwo() {
        groupBuildingTwo.add(new Student(1, Arrays.asList(
                new Subject(Subjects.BUILDING_MECHANICS, 1),
                new Subject(Subjects.MATHEMATICS, 2),
                new Subject(Subjects.PHILOSOPHY, 3),
                new Subject(Subjects.PHYSICAL_CULTURE, 4),
                new Subject(Subjects.PHYSICS, 5)
        )));
        groupBuildingTwo.add(new Student(2, Arrays.asList(
                new Subject(Subjects.BUILDING_MECHANICS, 1),
                new Subject(Subjects.MATHEMATICS, 2),
                new Subject(Subjects.PHILOSOPHY, 6),
                new Subject(Subjects.PHYSICAL_CULTURE, 4),
                new Subject(Subjects.PHYSICS, 5)
        )));
        return groupBuildingTwo;
    }

    List<Student> groupEconomicOne() {
        groupEconomicOne.add(new Student(1, Arrays.asList(
                new Subject(Subjects.INFORMATICS, 1),
                new Subject(Subjects.MATHEMATICS, 2),
                new Subject(Subjects.PHILOSOPHY, 3),
                new Subject(Subjects.PHYSICAL_CULTURE, 4)
        )));
        groupEconomicOne.add(new Student(2, Arrays.asList(
                new Subject(Subjects.INFORMATICS, 1),
                new Subject(Subjects.MATHEMATICS, 2),
                new Subject(Subjects.PHILOSOPHY, 3),
                new Subject(Subjects.PHYSICAL_CULTURE, 4)
        )));
        groupEconomicOne.add(new Student(3, Arrays.asList(
                new Subject(Subjects.INFORMATICS, 1),
                new Subject(Subjects.MATHEMATICS, 2),
                new Subject(Subjects.PHILOSOPHY, 3),
                new Subject(Subjects.PHYSICAL_CULTURE, 4)
        )));
        return groupEconomicOne;
    }

    public List<Student> getGroupBuildingOne() {
        return groupBuildingOne;
    }

    public List<Student> getGroupBuildingTwo() {
        return groupBuildingTwo;
    }

    public List<Student> getGroupEconomicOne() {
        return groupEconomicOne;
    }

    public Map<String, List<Student>> getUniversity() {
        return university;
    }
}
