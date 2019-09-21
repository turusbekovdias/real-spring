package com.example.demo.services;

import com.example.demo.domeins.Branch;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 18.09.19.
 */
@Service
public interface BranchService {

    String addNewToBranch(Branch branch) throws Exception;
    Branch getBranchById(Integer id) throws Exception;
}
