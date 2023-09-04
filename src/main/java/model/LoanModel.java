package model;

import java.time.LocalDate;

public class LoanModel {
    private int id_loan;
    private LocalDate withdrawalDate;
    private LocalDate returnDate;
    private Boolean status;
    private int id_user;
    private int id_book;

    public int getId_loan() {
        return id_loan;
    }

    public void setId_loan(int id_loan) {
        this.id_loan = id_loan;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }
}
