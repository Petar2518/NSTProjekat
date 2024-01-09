/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.dto.MemberDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author gg
 */
@Component
public class MemberConverter implements DtoEntityConverter<MemberDto, Member>{

    @Override
    public MemberDto toDto(Member e) {
        return new MemberDto(e.getId(),e.getFirstName(),e.getLastName(),e.getAcademic_title(),e.getScientific_field(),e.getEducation_field(),e.getDepartment());
    }

    @Override
    public Member toEntity(MemberDto t) {
        return new Member(t.getId(),t.getFirstName(),t.getLastName(),t.getAcademic_title(),t.getScientific_field(),t.getEducation_field(), t.getDepartment());
    }
    
}
