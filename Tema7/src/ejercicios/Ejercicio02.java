package ejercicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Ejercicio02 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			int[] res;
			String consulta = "update calificaciones set nota = ? where id_calificacion = ?";

			PreparedStatement pst = con.prepareStatement(consulta);

			pst.setDouble(1, 8.7);
			pst.setInt(2, 1);
			pst.addBatch();

			pst.setDouble(1, 9.2);
			pst.setInt(2, 2);
			pst.addBatch();

			pst.setDouble(1, 6.9);
			pst.setInt(2, 3);
			pst.addBatch();

			res = pst.executeBatch();
			System.out.println("Filas modificadas: " + Arrays.toString(res));

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
