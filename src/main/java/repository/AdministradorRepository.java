package repository;

import model.AuthorModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static connection.ConnectionDB.connect;
public class AdministradorRepository {
    private Connection conn = connect();
    private PreparedStatement preparedStatement;

    public AdministradorRepository(){}
    public AdministradorRepository(Connection connection) {
        this.conn = connection;
    }

    public Boolean logIn(int tokenAdmin) {
        try {
            String SQL = "SELECT * FROM administrador WHERE token_admin=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1, tokenAdmin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("token_admin") == tokenAdmin) {
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean registerAuthor(String name, String cpf, String email) {
        try {
            String SQL = "INSERT INTO autor(nome,cpf,email) VALUES(?,?,?)";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
    public boolean registerBook(String title, String synthesis, String genrer) {
        try {
            String SQL = "INSERT INTO livro(titulo,sintese,genero) VALUES(?,?,?)";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, synthesis);
            preparedStatement.setString(3, genrer);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
    public boolean deleteBook(int idBook) {
        String SQL = "DELETE FROM livros WHERE id_livro = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, idBook);
            pstmt.executeUpdate();
            System.out.println("Livro deletado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;}

    public boolean deleteAuthor(int idAuthor) {
        String SQL = "DELETE FROM autor WHERE id_autor = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, idAuthor);
            pstmt.executeUpdate();
            System.out.println("Autor deletado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteUser(int idUser) {
        String SQL = "DELETE FROM leitor WHERE id_leitor = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, idUser);
            pstmt.executeUpdate();
            System.out.println("Leitor deletado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean associateAuthorId(int idAuthor, int idBook){
        try {
            String SQL = "UPDATE livro SET id_autor=? WHERE id_livro=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1,idAuthor);
            preparedStatement.setInt(2,idBook);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean associateBookId(int idBook, int idAuthor){
        try {
            String SQL = "UPDATE autor SET id_livro=? WHERE id_autor=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1,idBook);
            preparedStatement.setInt(2,idAuthor);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}



