/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import java.io.Serializable;
import nst.springboot.restexample01.domain.AcademicTitleEnum;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.EducationTitleEnum;
import nst.springboot.restexample01.domain.ScientificFieldEnum;

/**
 *
 * @author gg
 */
public class MemberDto implements Serializable{
    
    private Long id;
    private String firstName;
    private String lastName;
    private AcademicTitleEnum academic_title;
    private ScientificFieldEnum scientific_field;
    private EducationTitleEnum education_field;
    private Department department;

    
    public MemberDto() {
    }


    public MemberDto(Long id, String firstName, String lastName, String academic_title, String scientific_field, String education_field, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.academic_title = AcademicTitleEnum.valueOf(academic_title);
        this.scientific_field = ScientificFieldEnum.valueOf(scientific_field);
        this.education_field = EducationTitleEnum.valueOf(education_field);
        this.department = department;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAcademic_title(){
        return academic_title.name();
    }

    public void setAcademic_title(String academic_title) {
        this.academic_title = AcademicTitleEnum.valueOf(academic_title);
    }

     public String getScientific_field(){
        return scientific_field.name();
    }

    public void setScientific_field(String scientific_field) {
        this.scientific_field = ScientificFieldEnum.valueOf(scientific_field);
    }

    public String getEducation_field() {
        return education_field.name();
    }

    public void setEducation_field(String education_field) {
        this.education_field = EducationTitleEnum.valueOf(education_field);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
