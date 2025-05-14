package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio09 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			String sql = "Select nombre, fecha_nacimiento From estudiantes";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getString(1) + " ");
				System.out.println(rs.getString(2) + " ");
			}
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
