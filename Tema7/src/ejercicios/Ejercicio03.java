package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Ejercicio03 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			int[] res;
			String consulta = "delete from cursos where nombre = ?";

			PreparedStatement pst = con.prepareStatement(consulta);

			pst.setString(1, "Historia 1º");
			pst.addBatch();

			pst.setString(1, "Biología 1º");
			pst.addBatch();

			pst.setString(1, "Educación Física 1º");
			pst.addBatch();

			pst.setString(1, "Música 1º");
			pst.addBatch();

			pst.setString(1, "Tecnología 1º");
			pst.addBatch();

			res = pst.executeBatch();
			System.out.println("Filas modificadas: " + Arrays.toString(res));

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}
}
