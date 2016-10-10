import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Esempio_1_jdbc {

	public static void main(String[] args) {

		try{
			//passo 1 load the driver class 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//passo2 creare connection object 
			Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","corso","corso");
			int id=3;
			//pcreate the statement object 
			
			Statement st=con.createStatement();
			
			String sql="select *from UTENTE where ID_UTENTE=\'"+id+"'";
			ResultSet res=st.executeQuery(sql);
			while(res.next()){
				int id_Utente=res.getInt(1);
				
				String nome=res.getString(2);
				String cognome=res.getString(3);
				String pass=res.getString(4);
				System.out.println(id_Utente+" "+nome+" "+cognome+" "+pass);
			}
			
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
			}
		}

	}
