/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import java.util.Date;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.Member;

/**
 *
 * @author gg
 */
public class DepartmentLeadershipHistoryDto {
    private Long id;
    private Department department;
    private Date startDate;
    private Date endDate;
    private Member rukovodilac;
    private Member sekretar;

    public DepartmentLeadershipHistoryDto() {
    }

    public DepartmentLeadershipHistoryDto(Long id, Department department, Date startDate, Date endDate, Member rukovodilac, Member sekretar) {
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
