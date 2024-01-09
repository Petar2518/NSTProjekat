/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.util.List;
import nst.springboot.restexample01.dto.MemberDto;
import nst.springboot.restexample01.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gg
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberDto> save(@Valid @RequestBody MemberDto member) throws Exception {
        MemberDto memberDto = memberService.save(member);
        return new ResponseEntity<>(memberDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAll() {
        List<MemberDto> members = memberService.getAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public MemberDto findById(@PathVariable("id") Long id) throws Exception {
        return memberService.findById(id);
    }

    @GetMapping("/query")
    public MemberDto queryById(@RequestParam("id") Long id) throws Exception {
        return memberService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {

        memberService.delete(id);
        return new ResponseEntity<>("Member removed!", HttpStatus.OK);

    }

}
