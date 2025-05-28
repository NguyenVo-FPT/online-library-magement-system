/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author nguye
 */
public class Fine {
    private int id;
    private int borrowId;
    private double fineAmout;
    private String paidStatus;

    public Fine(int id, int borrowId, double fineAmout, String paidStatus) {
        this.id = id;
        this.borrowId = borrowId;
        this.fineAmout = fineAmout;
        this.paidStatus = paidStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public double getFineAmout() {
        return fineAmout;
    }

    public void setFineAmout(double fineAmout) {
        this.fineAmout = fineAmout;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

}
