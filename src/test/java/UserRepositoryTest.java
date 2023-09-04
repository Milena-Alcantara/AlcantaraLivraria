import repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserRepository;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserRepositoryTest {
        private UserRepository userRepository;
        private Connection connect = mock(Connection.class);
        private PreparedStatement statement = mock(PreparedStatement.class);
        private ResultSet result = mock(ResultSet.class);
        private ByteArrayOutputStream capturaASaidaDoConsole = new ByteArrayOutputStream();

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(capturaASaidaDoConsole));

            try {
                when(connect.prepareStatement(anyString())).thenReturn(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            userRepository = new UserRepository(connect);
        }

        @Test
        void testCadastro()throws SQLException{
            boolean resultado = userRepository.registerUser("Luna", "123456789", "luna@gmail", "0000");

            verify(statement).executeUpdate();

            verify(statement).setString(1, "Luna");
            verify(statement).setString(2, "123456789");
            verify(statement).setString(3, "luna@gmail");
            verify(statement).setString(4, "0000");

            Assertions.assertTrue(resultado);
        }

        @Test
        void testLoginValido()throws SQLException{
            when(statement.executeQuery()).thenReturn(result);

            when(result.next()).thenReturn(true);
            when(result.getString("email")).thenReturn("paulo@gmail.com");
            when(result.getString("senha")).thenReturn("1234");

            boolean resultado = userRepository.logIn("paulo@gmail.com", "1234");

            Assertions.assertTrue(resultado);
        }

        @Test
        void testLoginInvalido()throws SQLException{
            when(statement.executeQuery()).thenReturn(result);

            when(result.next()).thenReturn(false);

            boolean resultado = userRepository.logIn("paulo@gmail.com", "1234");

            Assertions.assertFalse(resultado);
        }
    }


