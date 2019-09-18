package com.example.demo.controllers;

import com.example.demo.domeins.Branch;
import com.example.demo.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Admin on 17.09.2019.
 */

@RestController
@RequestMapping(path="/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @RequestMapping(path="/addbranch", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> newBranch() {
        String res = "";
        Branch branch = new Branch();
        res = addNewBranch(branch);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }


    public String addNewBranch (Branch branch) {
       String res;
        try {
            res = branchService.addNewToBranch(branch);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return res;
    }

}
