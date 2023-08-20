package com.dgrtech.edureka.feesms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FEES")
public class Fees {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "PAYMENT_DATE")
    private String paymentDate;

    @Column(name = "ISPAID")
    private boolean isPaid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
