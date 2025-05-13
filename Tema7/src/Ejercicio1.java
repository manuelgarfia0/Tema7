import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			String consulta = "insert into estudiantes (nombre, apellido, fecha_nacimiento, email, telefono)"
					+ " values ('Roberto', 'Morano', '2005-05-10', 'robertomorano@gmail.com', '333222111')";

			Statement st = con.createStatement();

			int res = st.executeUpdate(consulta);

			System.out.println("Filas añadidas: " + res);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
