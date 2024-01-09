/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.domain.DepartmentLeadershipHistory;
import nst.springboot.restexample01.dto.DepartmentLeadershipHistoryDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author gg
 */
@Component
public class DepartmentLeadershipHistoryConverter implements DtoEntityConverter<DepartmentLeadershipHistoryDto,DepartmentLeadershipHistory>{

    @Override
    public DepartmentLeadershipHistoryDto toDto(DepartmentLeadershipHistory e) {
        return new DepartmentLeadershipHistoryDto(e.getId(),e.getDepartment(), e.getStartDate(), e.getEndDate(), e.getRukovodilac(), e.getSekretar());
    }

    @Override
    public DepartmentLeadershipHistory toEntity(DepartmentLeadershipHistoryDto t) {
        return new DepartmentLeadershipHistory(t.getId(), t.getDepartment(), t.getStartDate(), t.getEndDate(), t.getRukovodilac(), t.getSekretar());
    }
    
}
