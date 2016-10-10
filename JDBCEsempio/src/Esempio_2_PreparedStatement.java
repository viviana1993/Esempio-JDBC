

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConnection;



public class Esempio_2_PreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException{
		try{
			//passo 1 load the driver class 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//passo2 creare connection object 
			Connection con= DBConnection.getConnection();
			int id=4;
		
			//pcreate the statement object 
			String sql="select *from UTENTE where ID_UTENTE=? and NOME=?";
			String sql1="insert into UTENTE(NOME,COGNOME,PASSWORD)"+"VALUES(?,?,?)";
			
			PreparedStatement st=con.prepareStatement(sql);
			PreparedStatement st1=con.prepareStatement(sql1);
			
			st.setInt(1, id);//al posto del primo'?' metto id=3
			st.setString(2, "AAggg");//al posto del secondo'?' metto nome="AAggg"
			
			st1.setString(1, "ffff");
			st1.setString(2, "jhhh");
			st1.setString(3, "33333");
			
			int res1=st1.executeUpdate();//mi restituisce il numero di righe aggiornate
			System.out.println(res1);//(res1=1)
			
			ResultSet res=st.executeQuery();
			
			
			while(res.next()){
				int id_Utente=res.getInt(1);
				
				String nome=res.getString(2);
				String cognome=res.getString(3);
				String pass=res.getString(4);
				System.out.println(id_Utente+" "+nome+" "+cognome+" "+pass);
			}
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			}
		}

	}


