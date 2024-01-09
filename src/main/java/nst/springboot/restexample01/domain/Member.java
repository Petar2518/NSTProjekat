/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gg
 */
@Entity
@Table(name="tbl_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "Ime je obavezno polje")
    @Column(name = "first_name")
    private String firstName;
    
    @NotEmpty(message = "Prezime je obavezno polje")
    @Column(name = "last_name")
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    @Column
    private AcademicTitleEnum academic_title;
    @Enumerated(EnumType.STRING)
    @Column
    private ScientificFieldEnum scientific_field;
    @Enumerated(EnumType.STRING)
    @Column
    private EducationTitleEnum education_field;
    
    
    @ManyToOne()
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department_id;

    
    public Member() {
    }

    public Member(Long id, String firstName, String lastName, String academic_title, String scientific_field, String education_field, Department department_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.academic_title = AcademicTitleEnum.valueOf(academic_title);
        this.scientific_field = ScientificFieldEnum.valueOf(scientific_field);
        this.education_field = EducationTitleEnum.valueOf(education_field);
        this.department_id = department_id;
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
        return department_id;
    }

    public void setDepartment(Department department) {
        this.department_id = department;
    }


    
}
