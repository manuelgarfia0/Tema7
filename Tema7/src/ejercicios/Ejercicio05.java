package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Ejercicio05 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			int[] res;
			String consulta = "insert into calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, "
					+ "nota, fecha_evaluacion) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(consulta);

			pst.setInt(1, 1);
			pst.setInt(2, 2);
			pst.setInt(3, 1);
			pst.setString(4, "Subida Matemáticas");
			pst.setDouble(5, 7);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 2);
			pst.setInt(2, 2);
			pst.setInt(3, 1);
			pst.setString(4, "Subida Matemáticas");
			pst.setDouble(5, 9.2);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 3);
			pst.setInt(2, 2);
			pst.setInt(3, 1);
			pst.setString(4, "Subida Matemáticas");
			pst.setDouble(5, 5.6);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 4);
			pst.setInt(2, 2);
			pst.setInt(3, 1);
			pst.setString(4, "Subida Matemáticas");
			pst.setDouble(5, 8.9);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 5);
			pst.setInt(2, 2);
			pst.setInt(3, 1);
			pst.setString(4, "Subida Matemáticas");
			pst.setDouble(5, 7.3);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 1);
			pst.setInt(2, 1);
			pst.setInt(3, 2);
			pst.setString(4, "Subida Lengua");
			pst.setDouble(5, 7);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 2);
			pst.setInt(2, 1);
			pst.setInt(3, 2);
			pst.setString(4, "Subida Lengua");
			pst.setDouble(5, 9.2);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 3);
			pst.setInt(2, 1);
			pst.setInt(3, 2);
			pst.setString(4, "Subida Lengua");
			pst.setDouble(5, 5.6);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 4);
			pst.setInt(2, 1);
			pst.setInt(3, 2);
			pst.setString(4, "Subida Lengua");
			pst.setDouble(5, 8.9);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			pst.setInt(1, 5);
			pst.setInt(2, 1);
			pst.setInt(3, 2);
			pst.setString(4, "Subida Lengua");
			pst.setDouble(5, 7.3);
			pst.setString(6, "2025-04-10");
			pst.addBatch();

			res = pst.executeBatch();
			System.out.println("Filas modificadas: " + Arrays.toString(res));

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}
}
