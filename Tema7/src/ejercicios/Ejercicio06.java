package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio06 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			int res;
			String consulta = "update calificaciones set nota = ? where id_calificacion = ?";

			PreparedStatement pst = con.prepareStatement(consulta);

			pst.setDouble(1, 9.7);
			pst.setInt(2, 1);

			res = pst.executeUpdate();
			System.out.println("Filas modificadas: " + res);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
