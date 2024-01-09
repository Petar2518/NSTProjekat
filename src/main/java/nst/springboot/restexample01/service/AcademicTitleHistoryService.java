/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;

/**
 *
 * @author gg
 */
public interface AcademicTitleHistoryService {
    AcademicTitleHistoryDto save(AcademicTitleHistoryDto athDto) throws Exception;
    List<AcademicTitleHistoryDto> getAll();
    void delete(Long id) throws Exception;
    void update(AcademicTitleHistoryDto athDto) throws Exception;
    AcademicTitleHistoryDto findById(Long id) throws Exception;
}
