package controller;

import model.BookModel;
import model.LoanModel;
import model.UserModel;
import repository.LoanRepository;
public class LoanController {
    LoanRepository loanRepo = new LoanRepository();
    LoanModel loanModel = new LoanModel();
    BookModel bookModel = new BookModel();
    UserModel userModel = new UserModel();

    public boolean makeLoan(int id_book,int id_user){
        bookModel.setId_book(id_book);
        userModel.setId_user(id_user);
        loanModel.setId_book(bookModel.getId_book());
        loanModel.setId_user(userModel.getId_user());
        return loanRepo.makeLoan(loanModel.getId_book(), loanModel.getId_user());
    }

    public boolean associateUserId(int idUser, int id_loan){
        userModel.setId_user(idUser);
        loanModel.setId_loan(id_loan);
        return loanRepo.associateUserId(userModel.getId_user(),loanModel.getId_loan());
    }

    public  boolean  updateStatusBook(int id_book){
        bookModel.setId_book(id_book);
        return loanRepo.updateStatusBook(bookModel.getId_book());
    }
}
