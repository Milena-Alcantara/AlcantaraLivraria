import repository.AdministradorRepository;

import repository.AdministradorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.Mockito.*;


public class AdministratorRepositoryTest {
    private AdministradorRepository administrador;
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

        administrador = new AdministradorRepository(connect);
    }

    @Test
    void testRegistrarAutor() {
        try {
            when(statement.executeUpdate()).thenReturn(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        administrador.registerAuthor("zz","111","l@gmail.com");

        String mensagemEsperada = "Connected to the PostgreSQL server successfully.";

        Assertions.assertEquals(mensagemEsperada.replaceAll("\\r?\\n", ""),capturaASaidaDoConsole.toString().trim().replaceAll("\\r?\\n", ""));
    }

    @Test
    void testloginValido() throws SQLException {
        when(statement.executeQuery()).thenReturn(result);
        when(result.next()).thenReturn(true);
        when(result.getInt("token_admin")).thenReturn(123);

        boolean resultado = administrador.logIn(123);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testloginInvalido() throws SQLException {
        when(statement.executeQuery()).thenReturn(result);
        when(result.next()).thenReturn(false);

        boolean resultado = administrador.logIn(1234);

        Assertions.assertFalse(resultado);
    }

    @Test
    void testRegistrarLivro()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = administrador.registerBook("Bolhas ao vento","descrição doida","Aventura");

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarLivro()throws SQLException {
        when(statement.executeUpdate()).thenReturn(2);

        boolean resultado = administrador.deleteBook(2);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarAutor()throws SQLException {
        when(statement.executeUpdate()).thenReturn(3);

        boolean resultado = administrador.deleteAuthor(3);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarLeitor()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = administrador.deleteUser(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testAssociarIdAutorAoLivro()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = administrador.associateAuthorId(5, 3);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testAssociarIdLivroAoAutor()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = administrador.associateBookId(3, 5);

        Assertions.assertTrue(resultado);
    }

}
