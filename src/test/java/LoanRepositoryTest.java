import repository.LoanRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class LoanRepositoryTest {

    private LoanRepository loanRepository;
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

        loanRepository = new LoanRepository(connect);
    }

    @Test
    void testEfetuarEmprestimo() throws SQLException {
        boolean resultado = loanRepository.makeLoan(3, 1);
        Assertions.assertTrue(resultado);
    }

    @Test
    void testAssociarIdLeitorAoEmprestimo()throws SQLException{
        boolean resultado = loanRepository.associateUserId(1, 1);
        verify(statement).executeUpdate();
        Assertions.assertTrue(resultado);
    }

    @Test
    void testAtualizarStatusDoLivro()throws SQLException{
        boolean resultado = loanRepository.updateStatusBook(2);
        verify(statement).executeUpdate();
        Assertions.assertTrue(resultado);
    }

}
