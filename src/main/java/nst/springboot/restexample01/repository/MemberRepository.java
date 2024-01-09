/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gg
 */
public interface MemberRepository extends JpaRepository<Member, Long>{
    
}
