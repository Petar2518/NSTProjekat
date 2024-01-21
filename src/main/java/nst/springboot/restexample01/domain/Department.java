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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 *
 * @author student2
 */
@Entity
@Table(name = "tbl_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ime je obavezno polje")
    @Size(min = 2, max = 10, message = "Broj znakova je od 2 do 20")
    @Column(name = "name")
    private String name;

    @Size(min = 2, max = 10, message = "Broj znakova je od 2 do 10")
    @Column(name = "short_name")
    private String shortName;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "rukovodilac", referencedColumnName = "id")
    private Member rukovodilac;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sekretar", referencedColumnName = "id")
    private Member sekretar;

    public Department() {
    }

    public Department(Long id, String name, String shortName, Member rukovodilac, Member sekretar) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.rukovodilac = rukovodilac;
        this.sekretar = sekretar;
    }

//    public Department(Long id, String name, String shortName) {
//        this.id = id;
//        this.name = name;
//        this.shortName = shortName;
//    }
    

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
