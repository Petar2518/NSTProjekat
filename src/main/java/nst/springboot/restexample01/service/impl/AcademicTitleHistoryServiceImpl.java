/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nst.springboot.restexample01.converter.impl.AcademicTitleHistoryConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.domain.AcademicTitleHistory;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import nst.springboot.restexample01.repository.AcademicTitleHistoryRepository;
import nst.springboot.restexample01.repository.MemberRepository;
import nst.springboot.restexample01.service.AcademicTitleHistoryService;
import org.springframework.stereotype.Service;

/**
 *
 * @author gg
 */
@Service
public class AcademicTitleHistoryServiceImpl implements AcademicTitleHistoryService {

    private AcademicTitleHistoryConverter athConverter;
    private AcademicTitleHistoryRepository athRepository;
    private MemberConverter memberConverter;
    private MemberRepository memberRepository;

    public AcademicTitleHistoryServiceImpl(AcademicTitleHistoryConverter athConverter, AcademicTitleHistoryRepository athRepository, MemberConverter memberConverter, MemberRepository memberRepository) {
        this.athConverter = athConverter;
        this.athRepository = athRepository;
        this.memberConverter = memberConverter;
        this.memberRepository = memberRepository;
    }

    @Override
    public AcademicTitleHistoryDto save(AcademicTitleHistoryDto athDto) throws Exception {
        
        AcademicTitleHistory ath = athConverter.toEntity(athDto);
        if(athRepository.findByMemberIdAndStartDate(ath.getMember().getId(), ath.getStartDate()).isPresent()){
            throw new Exception("Member's academic title was already added for that period");
        }
        if (ath.getMember().getId() == null) {
            memberRepository.save(ath.getMember());
        } else {
            Optional<Member> member = memberRepository.findById(ath.getMember().getId());
            if (member.isEmpty()) {
                memberRepository.save(ath.getMember());
            }
            else{
                if (ath.getEndDate()==null || ath.getEndDate().after(new Date())){
                    Member memberToSave = member.get();
                    memberToSave.setAcademic_title(ath.getAcademicTitle());
                    memberRepository.save(memberToSave);
                }
            }
        }
        athRepository.save(ath);
        return athDto;
    }

    @Override
    public List<AcademicTitleHistoryDto> getAll() {
        return athRepository
                .findAll()
                .stream().map(entity -> athConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<AcademicTitleHistory> ath = athRepository.findById(id);
        if (ath.isPresent()) {
            AcademicTitleHistory athistory = ath.get();
            athRepository.delete(athistory);
        } else {
            throw new Exception("Academic title history does not exist!");
        }
    }

    @Override
    public void update(AcademicTitleHistoryDto athDto) throws Exception {
        AcademicTitleHistory ath = athConverter.toEntity(athDto);
        Long id = ath.getId();
        Optional<AcademicTitleHistory> athistory = athRepository.findById(id);
        if (athistory.isPresent()) {
            //postoji
            athRepository.save(ath);
        } else {
            throw new Exception("Academic title history does not exist!");
        }
    }

    @Override
    public AcademicTitleHistoryDto findById(Long id) throws Exception {
        Optional<AcademicTitleHistory> ath = athRepository.findById(id);
        if (ath.isPresent()) {
            //postoji
            AcademicTitleHistory athistory = ath.get();
            return athConverter.toDto(athistory);
        } else {
            throw new Exception("Academic title history does not exist!");
        }
    }

}
