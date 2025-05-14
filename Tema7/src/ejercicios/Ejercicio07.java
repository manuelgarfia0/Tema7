package ejercicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio07 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {

			String sql = "insert into estudiantes (nombre, apellido, fecha_nacimiento, email, telefono)"
					+ " values (?, ?, ?, ?, ?)";
			String nombre;
			String apellido;
			String fechaNacimiento;
			String email;
			String telefono;

			PreparedStatement pst = con.prepareStatement(sql);

			System.out.println("Introduce el nombre del alumno nuevo: ");
			nombre = scanner.next();

			System.out.println("Introduce el apellido del alumno nuevo: ");
			apellido = scanner.next();

			System.out.println("Introduce la fecha de nacimientos del alumno nuevo: ");
			fechaNacimiento = scanner.next();

			System.out.println("Introduce el email del alumno nuevo: ");
			email = scanner.next();

			System.out.println("Introduce el teléfono del alumno nuevo: ");
			telefono = scanner.next();

			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setString(3, fechaNacimiento);
			pst.setString(4, email);
			pst.setString(5, telefono);

			int rs = pst.executeUpdate();

			System.out.println("Filas añadidas: " + rs);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
