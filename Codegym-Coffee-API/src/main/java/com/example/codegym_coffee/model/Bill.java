package com.example.codegym_coffee.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill",nullable = false)
    private Integer idBill;


    @Column(name = "day_of_bill",columnDefinition = "date")
    private LocalDate dayOfBill;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_table")
    private TableCoffee tableCoffee;


    @OneToOne(optional = true)
    @JoinColumn(name = "id_feedback")
    private Feedback feedback;


    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillDetail> billDetails;


    public Bill() {
    }

    public Bill(Integer idBill,  LocalDate dayOfBill, Integer paymentStatus, Employee employee,
                TableCoffee tableCoffee, Feedback feedback, List<BillDetail> billDetails) {
        this.idBill = idBill;
        this.dayOfBill = dayOfBill;
        this.paymentStatus = paymentStatus;
        this.employee = employee;
        this.tableCoffee = tableCoffee;
        this.feedback = feedback;
        this.billDetails = billDetails;
    }

    public Bill(LocalDate dayOfBill, Integer paymentStatus, Employee employee, TableCoffee tableCoffee, Feedback feedback) {
        this.dayOfBill = dayOfBill;
        this.paymentStatus = paymentStatus;
        this.employee = employee;
        this.tableCoffee = tableCoffee;
        this.feedback = feedback;
    }
    public Integer getIdBill() {
        return idBill;
    }

    public void setIdBill(Integer idBill) {
        this.idBill = idBill;
    }


    public LocalDate getDayOfBill() {
        return dayOfBill;
    }

    public void setDayOfBill(LocalDate dayOfBill) {
        this.dayOfBill = dayOfBill;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TableCoffee getTableCoffee() {
        return tableCoffee;
    }

    public void setTableCoffee(TableCoffee tableCoffee) {
        this.tableCoffee = tableCoffee;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }
}