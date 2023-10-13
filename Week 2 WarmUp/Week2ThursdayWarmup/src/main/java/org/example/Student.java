package org.example;

public class Student {
    private String firstName;
    private String lastName;
    private String studentID;
    private int yearsInCollege;
    private boolean international;
    private String address;


    public Student(String firstName, String lastName, String studentID, int yearsInCollege, boolean international, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.yearsInCollege = yearsInCollege;
        this.international = international;
        this.address = address;
    }

    public Student(String firstName, String lastName, String studentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public void greeting(){
        System.out.println("Hi, my name is " + this.firstName + " " + this.lastName);
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void  setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getStudentID(){
        return this.studentID;
    }

    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public int getYearsInCollege(){
        return this.yearsInCollege;
    }
    public void setYearsInCollege(int yearsInCollege){
        this.yearsInCollege = yearsInCollege;
    }

    public boolean getInternational(){
        return this.international;
    }
    public void setInternational(boolean international){
        this.international = international;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

}
