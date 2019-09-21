package com.example.demo.controllers;

import com.example.demo.domeins.Branch;
import com.example.demo.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;

/**
 * Created by Admin on 17.09.2019.
 */

@RestController
@RequestMapping(path="/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @RequestMapping(path="/addBranch", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> newBranch(@RequestBody Branch branch) {
        String res;
        res = addNewBranch(branch);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    @RequestMapping(path="/getBranch", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getBranchId(@RequestParam Integer id) {
        String res;
        AbstractMap.SimpleImmutableEntry obj = getBraById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(obj.getValue());
    }

    ///////////////////////////////////////// Connection with Services

    public String addNewBranch (Branch branch) {
       String res;
        try {
            res = branchService.addNewToBranch(branch);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return res;
    }

    public AbstractMap.SimpleImmutableEntry<String, Branch> getBraById (Integer id) {
        Branch branch = new Branch();
        String res = new String();
        try {
            branch = branchService.getBranchById(id);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
            return new AbstractMap.SimpleImmutableEntry<String, Branch>(res, branch);
    }

}
