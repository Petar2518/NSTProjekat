/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.util.List;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import nst.springboot.restexample01.service.AcademicTitleHistoryService;
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
@RequestMapping("/ath")
public class AcademicTitleHistoryController {
    
    private final AcademicTitleHistoryService athService;

    public AcademicTitleHistoryController(AcademicTitleHistoryService athService) {
        this.athService = athService;
    }

    

    @PostMapping
    public ResponseEntity<AcademicTitleHistoryDto> save(@Valid @RequestBody AcademicTitleHistoryDto ath) throws Exception {
        AcademicTitleHistoryDto athDto = athService.save(ath);
        return new ResponseEntity<>(athDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AcademicTitleHistoryDto>> getAll() {
        List<AcademicTitleHistoryDto> members = athService.getAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AcademicTitleHistoryDto findById(@PathVariable("id") Long id) throws Exception {
        return athService.findById(id);
    }

    @GetMapping("/query")
    public AcademicTitleHistoryDto queryById(@RequestParam("id") Long id) throws Exception {
        return athService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {

        athService.delete(id);
        return new ResponseEntity<>("Member removed!", HttpStatus.OK);

    }

}
