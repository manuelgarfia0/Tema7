package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			int res;
			String consulta = "delete from estudiantes where id_estudiante = ?";
			int id_estudiante;

			PreparedStatement pst = con.prepareStatement(consulta);

			System.out.println("Introduce el id del alumno");
			id_estudiante = scanner.nextInt();

			pst.setInt(1, id_estudiante);

			res = pst.executeUpdate();
			System.out.println("Filas eliminadas: " + res);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
