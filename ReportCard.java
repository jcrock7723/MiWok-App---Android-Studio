package com.example.android.miwok;

public class ReportCard {

    private String studentName;
    private double chemGrade;
    private double mathGrade;
    private double engGrade;
    private double compGrade;
    private double bioGrade;

    public ReportCard(String studentName, double chemGrade, double mathGrade, double engGrade, double compGrade, double bioGrade) {
        this.studentName = studentName;
        this.chemGrade = chemGrade;
        this.mathGrade = mathGrade;
        this.engGrade = engGrade;
        this.compGrade = compGrade;
        this.bioGrade = bioGrade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getChemGrade() {
        return chemGrade;
    }

    public void setChemGrade(double chemGrade) {
        this.chemGrade = chemGrade;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public double getEngGrade() {
        return engGrade;
    }

    public void setEngGrade(double engGrade) {
        this.engGrade = engGrade;
    }

    public double getCompGrade() {
        return compGrade;
    }

    public void setCompGrade(double compGrade) {
        this.compGrade = compGrade;
    }

    public double getBioGrade() {
        return bioGrade;
    }

    public void setBioGrade(double bioGrade) {
        this.bioGrade = bioGrade;
    }

    @Override
    public String toString() {
        return "ReportCard for " +
                "Student: " + studentName + '\n' +
                "Chemistry Grade: " + chemGrade +
                "\nMath Grade: " + mathGrade +
                "\nEnglish Grade: " + engGrade +
                "\nComputer Science Grade: " + compGrade +
                "\nBiology Grade: " + bioGrade;
    }
}
