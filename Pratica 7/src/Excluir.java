import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Excluir {
    private final String url = "jdbc:postgresql://localhost/criacaoBDlivrariaUniversitaria";
    private final String user = "postgres";
    private final String password = "123456";
    private static final String DELETE_USERS_SQL = "delete from livro where id_isbn = ?";

    public Excluir(String cod_excluir) throws SQLException {
        System.out.println(DELETE_USERS_SQL);

        try (Connection connection = DriverManager.getConnection(url, user, password);

        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);){
            preparedStatement.setString(1,cod_excluir);

            int result = preparedStatement.executeUpdate();
            System.out.println("Number of records affected:: " +result);
        } catch (SQLException e){

        }
    }
}
