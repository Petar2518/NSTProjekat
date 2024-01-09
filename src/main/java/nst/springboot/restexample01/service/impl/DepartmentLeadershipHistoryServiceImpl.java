/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.DepartmentLeadershipHistoryConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.DepartmentLeadershipHistory;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.dto.DepartmentLeadershipHistoryDto;
import nst.springboot.restexample01.repository.DepartmentLeadershipHistoryRepository;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.repository.MemberRepository;
import nst.springboot.restexample01.service.DepartmentLeadershipHistoryService;
import org.springframework.stereotype.Service;

/**
 *
 * @author gg
 */
@Service
public class DepartmentLeadershipHistoryServiceImpl implements DepartmentLeadershipHistoryService {

    private DepartmentLeadershipHistoryConverter dlhConverter;
    private DepartmentLeadershipHistoryRepository dlhRepository;
    private DepartmentConverter departmentConverter;
    private DepartmentRepository departmentRepository;
    private MemberConverter memberConverter;
    private MemberRepository memberRepository;

    public DepartmentLeadershipHistoryServiceImpl(DepartmentLeadershipHistoryConverter dlhConverter, DepartmentLeadershipHistoryRepository dlhRepository, DepartmentConverter departmentConverter, DepartmentRepository departmentRepository, MemberConverter memberConverter, MemberRepository memberRepository) {
        this.dlhConverter = dlhConverter;
        this.dlhRepository = dlhRepository;
        this.departmentConverter = departmentConverter;
        this.departmentRepository = departmentRepository;
        this.memberConverter = memberConverter;
        this.memberRepository = memberRepository;
    }

    @Override
    public DepartmentLeadershipHistoryDto save(DepartmentLeadershipHistoryDto dlhDto) throws Exception {
        DepartmentLeadershipHistory dlh = dlhConverter.toEntity(dlhDto);
        if(dlhRepository.findByDepartmentIdAndStartDate(dlh.getDepartment().getId(), dlh.getStartDate()).isPresent()){
            throw new Exception("Main people for that department were already decided for that period");
        }
        if (dlh.getDepartment().getId() == null) {
            departmentRepository.save(dlh.getDepartment());
        } else {
            Optional<Department> department = departmentRepository.findById(dlh.getDepartment().getId());
            if (department.isEmpty()) {
                departmentRepository.save(dlh.getDepartment());
            }else{
                if (dlh.getEndDate()==null || dlh.getEndDate().after(new Date())){
                    Department departmentToSave = department.get();
                    departmentToSave.setRukovodilac(dlh.getRukovodilac());
                    departmentToSave.setSekretar(dlh.getSekretar());
                    departmentRepository.save(departmentToSave);
                }
            }
        }
        dlhRepository.save(dlh);
        return dlhDto;

    }

    @Override
    public List<DepartmentLeadershipHistoryDto> getAll() {
        return dlhRepository.findAll().stream().map(entity -> dlhConverter.toDto(entity)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<DepartmentLeadershipHistory> dlh = dlhRepository.findById(id);
        if (dlh.isPresent()) {
            DepartmentLeadershipHistory dlhistory = dlh.get();
            dlhRepository.delete(dlhistory);
        } else {
            throw new Exception("Department leadership history does not exist!");
        }
    }

    @Override
    public void update(DepartmentLeadershipHistoryDto dlhDto) throws Exception {
        DepartmentLeadershipHistory dlh = dlhConverter.toEntity(dlhDto);
        Long id = dlh.getId();
        Optional<DepartmentLeadershipHistory> dlhistory = dlhRepository.findById(id);
        if (dlhistory.isPresent()) {
            //postoji
            dlhRepository.save(dlh);
        } else {
            throw new Exception("Department leadership history does not exist!");
        }
    }

    @Override
    public DepartmentLeadershipHistoryDto findById(Long id) throws Exception {
        Optional<DepartmentLeadershipHistory> dlh = dlhRepository.findById(id);
        if (dlh.isPresent()) {
            //postoji
            DepartmentLeadershipHistory athistory = dlh.get();
            return dlhConverter.toDto(athistory);
        } else {
            throw new Exception("Department leadership history does not exist!");
        }
    }


}
