package controller;

import model.AdministratorModel;
import model.AuthorModel;
import model.BookModel;
import model.UserModel;
import repository.AdministradorRepository;

public class AdmnistratorController {
    AdministradorRepository adminRepository = new AdministradorRepository();
    AdministratorModel adminModel = new AdministratorModel();
    BookModel bookModel  = new BookModel();
    AuthorModel authorModel = new AuthorModel();
    UserModel userModel = new UserModel();

    public boolean logIn(int tokenAdmin) {
        adminModel.setTokenAdmin(tokenAdmin);
        return adminRepository.logIn(adminModel.getTokenAdmin());
    }

    public boolean registerAuthor(String name, String cpf, String email){
        authorModel.setName(name);
        authorModel.setCpf(cpf);
        authorModel.setEmail(email);
        return adminRepository.registerAuthor(authorModel.getName(), authorModel.getCpf(), authorModel.getEmail());
    }
    public boolean registerBook(String title, String synthesys, String genrer) {
        bookModel.setTitle(title);
        bookModel.setSynthesis(synthesys);
        bookModel.setGenrer(genrer);
        return adminRepository.registerBook(bookModel.getTitle(),bookModel.getSynthesis(),bookModel.getGenrer());
    }

    public boolean deleteBook(int idBook){
        bookModel.setId_book(idBook);
        return adminRepository.deleteBook(bookModel.getId_book());
    }

    public boolean deleteAuthor(int idAuthor){
        authorModel.setIdAuthor(idAuthor);
        return adminRepository.deleteAuthor(authorModel.getIdAuthor());
    }

    public boolean deleteUser(int idUser){
        userModel.setId_user(idUser);
        return adminRepository.deleteUser(userModel.getId_user());
    }

    public boolean associateAuthorId(int idAuthor, int idBook) {
        bookModel.setId_autor(idAuthor);
        bookModel.setId_book(idBook);
        return adminRepository.associateAuthorId(bookModel.getId_autor(), bookModel.getId_book());
    }

    public boolean associateBookId(int idBook, int idAuthor){
        authorModel.setId_livro(idBook);
        authorModel.setIdAuthor(idAuthor);
        return adminRepository.associateBookId(authorModel.getId_livro(),authorModel.getIdAuthor());
    }
}
