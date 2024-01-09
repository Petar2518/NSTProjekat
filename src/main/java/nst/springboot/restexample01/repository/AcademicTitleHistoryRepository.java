/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.repository;

import java.util.Date;
import java.util.Optional;
import nst.springboot.restexample01.domain.AcademicTitleHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author gg
 */
public interface AcademicTitleHistoryRepository extends JpaRepository<AcademicTitleHistory, Long> {

    Optional<AcademicTitleHistory> findByMemberIdAndStartDate(Long member, Date startDate);
}
