/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.domain.AcademicTitleHistory;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author gg
 */
@Component
public class AcademicTitleHistoryConverter implements DtoEntityConverter<AcademicTitleHistoryDto, AcademicTitleHistory> {

    @Override
    public AcademicTitleHistoryDto toDto(AcademicTitleHistory e) {
        return new AcademicTitleHistoryDto(e.getId(), e.getStartDate(), e.getEndDate(), e.getAcademicTitle(), e.getScientificField(), e.getMember());
    }
    
    @Override
    public AcademicTitleHistory toEntity(AcademicTitleHistoryDto t) {
        return new AcademicTitleHistory(t.getId(), t.getStartDate(), t.getEndDate(), t.getAcademicTitle(), t.getScientificField(), t.getMember());
    }

}
