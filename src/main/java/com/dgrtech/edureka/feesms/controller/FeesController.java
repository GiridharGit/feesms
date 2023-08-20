package com.dgrtech.edureka.feesms.controller;


import com.dgrtech.edureka.feesms.model.Fees;
import com.dgrtech.edureka.feesms.service.FeesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class FeesController {

    FeesService feesService;

    public FeesController(FeesService feesService){
        this.feesService = feesService;
    }

    @GetMapping("fees/student/{studentId}")
    public ResponseEntity<List<Fees>> getStudentFees(@PathVariable("studentId") Long studentId){
        List<Fees> studentFees = feesService.getStudentFees(studentId);
        return new ResponseEntity<>(studentFees, HttpStatus.OK);
    }


    @PostMapping("fees/pay/{id}")
    public ResponseEntity<Fees> payFees(@PathVariable("id") Long id){
        Optional<Fees> _fees = feesService.getFeesById(id);
        if (_fees.isPresent()){
            Fees fees = _fees.get();
            fees.setPaid(true);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            fees.setPaymentDate(dateFormat.format(new Date()));
            Fees savedFees = feesService.addPayment(fees);
            return new ResponseEntity<>(savedFees,HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("fees")
    public ResponseEntity<Fees> createFees(@RequestBody Fees fees){
        Fees savedFees = feesService.addPayment(fees);
        return new ResponseEntity<>(savedFees,HttpStatus.CREATED);
    }

}
