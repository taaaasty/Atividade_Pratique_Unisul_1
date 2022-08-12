import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static Connection DBConnection = null;
    public static boolean CreateConnection () {
        if (DBConnection == null) {
            System.out.println("------------------------");
            System.out.println("[+] Carregando o banco de dados");
            try {
                DBConnection = DriverManager.getConnection("jdbc:sqlite:banco.db");
                System.out.println("[+] Banco de dados carregado com sucesso");
                Statement stmt = DBConnection.createStatement();
                String[] SQL = {
                        "CREATE TABLE IF NOT EXISTS events (ID integer PRIMARY KEY, NAME text, DESCRIPTION text, CATEGORY text, DATE text, TIME text, PARTICIPANTS)",
                        "CREATE TABLE IF NOT EXISTS users (ID integer PRIMARY KEY, USER text, PASS text, CITY text,  CEP text, IDADE int)"
                };
                for (String s : SQL) {
                    stmt.execute(s);
                }
                return true;
            } catch (SQLException e) {
                System.out.println("[+] Falha no banco de dados");
                System.exit(157);
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
    public static boolean DestroyConnection () {
        if (DBConnection != null) {
            try {
                DBConnection.close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static void CreateEvent() {
        /*
        Categoria de eventos disponíveis:
        Festas, Evento Esportivo, Shows.

        Eventos devem possuír: Nome do evento, Endereço, Categoria, Data, Horário e descrição
         */

    }

    public static void FetchEvent() {

    }

    public static void DeleteEvent() {

    }

    public static void ParticipateEvent() {

    }

    public static void CreateUser() {

    }

    public static void Login(String user, String pass) {
        try {
            boolean connected = CreateConnection();
            if (connected) {

            }
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
