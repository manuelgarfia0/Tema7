import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploConexionBD {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String contraseña = "ManuelGC2006";

		try (Connection con = DriverManager.getConnection(url, usuario, contraseña)) {

			String sql = "SELECT * " + "FROM calificaciones " + "WHERE id_curso = ? AND nota > ?";

//			Statement st = con.createStatement();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, 2);
			pst.setDouble(2, 8);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt(2) + " ");
				System.out.print(rs.getInt(3) + " ");
				System.out.println(rs.getDouble(6));
			}

//			ResultSet rs = st.executeQuery("select * from estudiantes");
//
//			while (rs.next()) {
//				System.out.println(rs.getString(1) + " " + rs.getString(2));
//			}

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
