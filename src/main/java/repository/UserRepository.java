package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static connection.ConnectionDB.connect;

public class UserRepository {
    private Connection conn = connect();
    private PreparedStatement preparedStatement;
    public UserRepository(){}
    public UserRepository(Connection connection){
        this.conn = connection;
    }
    public boolean registerUser(String name, String cpf, String email, String password){
        try {
            String SQL = "INSERT INTO leitor(nome,cpf,email,senha) VALUES(?,?,?,?)";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,cpf);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,password);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
    public Boolean logIn(String email,String password){
        try {
            String SQL = "SELECT * FROM leitor WHERE email=? AND senha=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if ((resultSet.getString("email").equals(email)) && (resultSet.getString("senha").equals(password))) {
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }


}
