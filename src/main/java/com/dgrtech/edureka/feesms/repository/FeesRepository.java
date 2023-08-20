package com.dgrtech.edureka.feesms.repository;

import com.dgrtech.edureka.feesms.model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Long> {

    List<Fees> findByStudentId(Long studentId);
}
