package com.example.demo.serviceImp;

import com.example.demo.domeins.Branch;
import com.example.demo.repositories.BranchRepository;
import com.example.demo.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 18.09.2019.
 */
@Service
public class BranchServiceImp implements BranchService {

    @Autowired
    BranchRepository branchRepository;

    @Override
    public String addNewToBranch(Branch branch) throws Exception{
        String s;
        try {
            branchRepository.save(branch);
            return "Новый филиал сохранен!";
        } catch (Exception ex) {
             s = ex.getMessage();
             return s;
        }
    }

    @Override
    public Branch getBranchById(Integer id) throws Exception {
        try {
         Branch branch = branchRepository.findById(id).get();
         return branch;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
