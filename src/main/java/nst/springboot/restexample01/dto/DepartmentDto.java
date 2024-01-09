/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import nst.springboot.restexample01.domain.Member;

/**
 *
 * @author student2
 */
public class DepartmentDto implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 2, max = 10, message = "Broj znakova [2-10]")
    private String name;

    private String shortName;

    private Member rukovodilac;
    private Member sekretar;

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    
    
    public DepartmentDto(Long id, String name, String shortName, Member rukovodilac, Member sekretar) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.rukovodilac = rukovodilac;
        this.sekretar = sekretar;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
