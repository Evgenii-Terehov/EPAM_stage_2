package model;

import enums.Subjects;
import exception.PointBelowHigherNormalException;

public class Subject {
    private Subjects subjects;
    private int pointAverage;

    public Subject (Subjects subjects, int pointAverage) {
        this.subjects = subjects;
        this.pointAverage = pointAverage;

        if (pointAverage > 10 || pointAverage <= 0) {
            throw new PointBelowHigherNormalException("Point is below 0 or upper than 10");
        }
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public int getPointAverage() {
        return pointAverage;
    }
}
