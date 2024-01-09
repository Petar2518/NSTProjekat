/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import nst.springboot.restexample01.domain.DepartmentLeadershipHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gg
 */
public interface DepartmentLeadershipHistoryRepository extends JpaRepository<DepartmentLeadershipHistory, Long>{
     Optional<DepartmentLeadershipHistory> findByDepartmentIdAndStartDate(Long member, Date startDate);
}
