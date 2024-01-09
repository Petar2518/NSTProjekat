/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.util.List;
import nst.springboot.restexample01.dto.DepartmentLeadershipHistoryDto;
import nst.springboot.restexample01.service.DepartmentLeadershipHistoryService;
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
@RequestMapping("/dlh")
public class DepartmentLeadershipHistoryController {

    
    private final DepartmentLeadershipHistoryService dlhService;

    public DepartmentLeadershipHistoryController(DepartmentLeadershipHistoryService dlhService) {
        this.dlhService = dlhService;
    }

    @PostMapping
    public ResponseEntity<DepartmentLeadershipHistoryDto> save(@Valid @RequestBody DepartmentLeadershipHistoryDto ath) throws Exception {
        DepartmentLeadershipHistoryDto athDto = dlhService.save(ath);
        return new ResponseEntity<>(athDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentLeadershipHistoryDto>> getAll() {
        List<DepartmentLeadershipHistoryDto> members = dlhService.getAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DepartmentLeadershipHistoryDto findById(@PathVariable("id") Long id) throws Exception {
        return dlhService.findById(id);
    }

    @GetMapping("/query")
    public DepartmentLeadershipHistoryDto queryById(@RequestParam("id") Long id) throws Exception {
        return dlhService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {

        dlhService.delete(id);
        return new ResponseEntity<>("Leadership history removed!", HttpStatus.OK);

    }

}
