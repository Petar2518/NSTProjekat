/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
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
@Table(name = "tbl_dlh")
public class DepartmentLeadershipHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rukovodilac", referencedColumnName = "id")
    private Member rukovodilac;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sekretar", referencedColumnName = "id")
    private Member sekretar;

    public DepartmentLeadershipHistory() {
    }

    public DepartmentLeadershipHistory(Long id, Department department, Date startDate, Date endDate, Member rukovodilac, Member sekretar) {
        this.id = id;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rukovodilac = rukovodilac;
        this.sekretar = sekretar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public Member getRukovodilac() {
        return rukovodilac;
    }

    public void setRukovodilac(Member rukovodilac) {
        this.rukovodilac = rukovodilac;
    }

    public Member getSekretar() {
        return sekretar;
    }

    public void setSekretar(Member sekretar) {
        this.sekretar = sekretar;
    }

}
