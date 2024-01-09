/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

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
import jakarta.persistence.Table;
import java.util.Date;
import nst.springboot.restexample01.domain.AcademicTitleEnum;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.domain.ScientificFieldEnum;

/**
 *
 * @author gg
 */
public class AcademicTitleHistoryDto {

    private Long id;
    private Date startDate;
    private Date endDate;
    private AcademicTitleEnum academicTitle;
    private ScientificFieldEnum scientificField;
    private Member member;

    public AcademicTitleHistoryDto() {
    }

    public AcademicTitleHistoryDto(Long id, Date startDate, Date endDate, String academicTitle, String scientificField, Member member) {
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

    public String getAcademicTitle() {
        return academicTitle.name();
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = AcademicTitleEnum.valueOf(academicTitle);
    }

    public String getScientificField() {
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
