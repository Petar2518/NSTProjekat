/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.dto.MemberDto;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.repository.MemberRepository;
import nst.springboot.restexample01.service.MemberService;
import org.springframework.stereotype.Service;

/**
 *
 * @author gg
 */
@Service
public class MemberServiceImpl implements MemberService {

    private MemberConverter memberConverter;
    private MemberRepository memberRepository;
    private DepartmentConverter departmentConverter;
    private DepartmentRepository departmentRepository;

    public MemberServiceImpl(MemberConverter memberConverter, MemberRepository memberRepository, DepartmentConverter departmentConverter, DepartmentRepository departmentRepository) {
        this.memberConverter = memberConverter;
        this.memberRepository = memberRepository;
        this.departmentConverter = departmentConverter;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public MemberDto save(MemberDto memberDto) throws Exception {
        Member member = memberConverter.toEntity(memberDto);
        if (member.getDepartment().getId() == null) {
            departmentRepository.save(member.getDepartment());
        } else {
            Optional<Department> dep = departmentRepository.findById(member.getDepartment().getId());
            if (dep.isEmpty()) {
                departmentRepository.save(member.getDepartment());
            }
        }
        memberRepository.save(member);
        return memberDto;
    }

    @Override
    public List<MemberDto> getAll() {
        return memberRepository
                .findAll()
                .stream().map(entity -> memberConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            Member memb = member.get();
            memberRepository.delete(memb);
        } else {
            throw new Exception("Member does not exist!");
        }
    }

    @Override
    public void update(MemberDto memberDto) throws Exception {
        Member member= memberConverter.toEntity(memberDto);
        Long id = member.getId();
        Optional<Member> memb = memberRepository.findById(id);
        if (memb.isPresent()) {
            //postoji
            memberRepository.save(member);
        } else {
            throw new Exception("Member does not exist!");
        }
    }

    @Override
    public MemberDto findById(Long id) throws Exception {
            Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            //postoji
            Member memb = member.get();
            return memberConverter.toDto(memb);
        } else {
            throw new Exception("Member does not exist!");
        }
    }

}
