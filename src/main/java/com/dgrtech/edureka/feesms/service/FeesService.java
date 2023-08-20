package com.dgrtech.edureka.feesms.service;

import com.dgrtech.edureka.feesms.model.Fees;
import com.dgrtech.edureka.feesms.repository.FeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeesService {

    FeesRepository feesRepository;

    public FeesService(FeesRepository feesRepository){
        this.feesRepository=feesRepository;
    }

    public Fees addPayment(Fees fees){
        return feesRepository.save(fees);
    }

    public Optional<Fees> getFeesById(Long id){
        return feesRepository.findById(id);
    }

    public List<Fees> getStudentFees(Long studentId){
        return feesRepository.findByStudentId(studentId);
    }
}
