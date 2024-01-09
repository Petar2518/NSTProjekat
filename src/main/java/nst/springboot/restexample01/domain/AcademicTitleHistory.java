/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author gg
 */
@Entity
@Table(name = "tbl_ath")
public class AcademicTitleHistory {
    
    /* moguce odraditi i preko slozenog kljuca koriscenjem anotacije @EmbeddedId
        gde bi nova klasa bila anotirana sa @Embeddable i klasa athId definisala bi se kao klasa koja se sastoji od atributa member_id i start_date 
        (pretpostavka je da jedan clan katedre ne moze da dobije istog datuma dve razlicite titule)*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "academic_title")
    @Enumerated(EnumType.STRING)
    private AcademicTitleEnum academicTitle;

    @Column(name = "scientific_field")
    @Enumerated(EnumType.STRING)
    private ScientificFieldEnum scientificField;

    @ManyToOne()
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    public AcademicTitleHistory() {
    }

    public AcademicTitleHistory(Long id, Date startDate, Date endDate, String academicTitle, String scientificField, Member member) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.academicTitle = AcademicTitleEnum.valueOf(academicTitle);
        this.scientificField = ScientificFieldEnum.valueOf(scientificField);
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAcademicTitle(){
        return academicTitle.name();
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = AcademicTitleEnum.valueOf(academicTitle);
    }

     public String getScientificField(){
        return scientificField.name();
    }

    public void setScientificField(String scientificField) {
        this.scientificField = ScientificFieldEnum.valueOf(scientificField);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
