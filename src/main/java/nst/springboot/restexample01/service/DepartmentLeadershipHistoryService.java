/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.service;

import java.util.Date;
import java.util.List;
import nst.springboot.restexample01.dto.DepartmentLeadershipHistoryDto;

/**
 *
 * @author gg
 */
public interface DepartmentLeadershipHistoryService {
    DepartmentLeadershipHistoryDto save(DepartmentLeadershipHistoryDto dlhDto) throws Exception;
    List<DepartmentLeadershipHistoryDto> getAll();
    void delete(Long id) throws Exception;
    void update(DepartmentLeadershipHistoryDto dlhDto) throws Exception;
    DepartmentLeadershipHistoryDto findById(Long id) throws Exception;
}
