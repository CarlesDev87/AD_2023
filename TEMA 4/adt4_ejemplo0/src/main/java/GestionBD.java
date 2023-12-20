import java.sql.Connection;
import java.sql.DriverManager;

public class GestionBD {

    private static final String BD = "adt3_ejemplo1";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/" + BD;

    private static GestionBD db = null;  //la clase singleton tiene que tener un metodo de la clase, por defecto, a null

    private  Connection conexion = null;

    private GestionBD() {
        try {
            conexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Conectado a la base de dadots MySQL [" + BD + "]");
        } catch (Exception e) {
            System.err.println("Error conexion");
        }


    }

    public static Connection getConexion() {  //hay que comprobar que el objeto de la clase sea null
        if (db == null) {
            db = new GestionBD();
        }

        return db.conexion;
    }

    public static void desconexion () {

        try {
            db.conexion.close();
            System.out.println("Desconectado de la base de datos MySQL [" + BD + "]");
        } catch (Exception e) {
            System.err.println("Error conexion" + e.getMessage()) ;
        }

    }

}
