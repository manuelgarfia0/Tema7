package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Ejercicio04 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			int[] res;
			String consulta = "insert into cursos (nombre, descripcion, año_escolar)" + " values (?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(consulta);

			pst.setString(1, "Historia 1º");
			pst.setString(2, "Historia de España para primer año");
			pst.setInt(3, 2025);
			pst.addBatch();

			pst.setString(1, "Biología 1º");
			pst.setString(2, "Biología para primer año");
			pst.setInt(3, 2025);
			pst.addBatch();

			pst.setString(1, "Educación Física 1º");
			pst.setString(2, "Educación Física para primer año");
			pst.setInt(3, 2025);
			pst.addBatch();

			pst.setString(1, "Música 1º");
			pst.setString(2, "Música para primer año");
			pst.setInt(3, 2025);
			pst.addBatch();

			pst.setString(1, "Tecnología 1º");
			pst.setString(2, "Tecnología para primer año");
			pst.setInt(3, 2025);
			pst.addBatch();

			res = pst.executeBatch();

			System.out.println("Filas añadidas: " + Arrays.toString(res));

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
