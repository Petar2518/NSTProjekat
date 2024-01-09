/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.service;

import java.util.List;
import nst.springboot.restexample01.dto.MemberDto;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author gg
 */
public interface MemberService {
    MemberDto save(MemberDto memberDto) throws Exception;
    List<MemberDto> getAll();
    void delete(Long id) throws Exception;
    void update(MemberDto department) throws Exception;
    MemberDto findById(Long id) throws Exception;
}
