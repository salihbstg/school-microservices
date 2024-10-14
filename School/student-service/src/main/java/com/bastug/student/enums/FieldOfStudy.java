package com.bastug.student.enums;

public enum FieldOfStudy {
    COMPUTER_ENGINEERING("Computer Engineering"),
    ELECTRICAL_ENGINEERING("Electrical Engineering"),
    MECHANICAL_ENGINEERING("Mechanical Engineering"),
    CIVIL_ENGINEERING("Civil Engineering"),
    MATHEMATICS("Mathematics");

    private final String fieldOfStudy;

    FieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getFieldOfStudyResponse() {
        return fieldOfStudy;
    }
}
