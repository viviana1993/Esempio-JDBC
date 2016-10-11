package dao;


import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.net.aso.e;
import model.Utente;

public class UtenteDao {
	
	
	//il DAO non ha attributi ma ha SOLO metodi
	public Utente leggiUtenteConId(int id){
		Utente u=null;
		/*si può mettere un DataSource per ogni istanza ma per ogni Dao devo mettere la riga:
		 con=DataSource.getInstance().getConnection();
		*/
		Connection con;
		

		String sql="select * from UTENTE where ID_UTENTE=?";

		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=DataSource.getInstance().getConnection();
			pst=con.prepareStatement(sql);

			pst.setInt(1, id);

			rs=pst.executeQuery();

			if(rs.next()){
				int id_utente=rs.getInt(1);//colonna 1 contiene id
				String nome=rs.getString(2);
				String cognome=rs.getString(3);
				String password=rs.getString(4);

				u=new Utente(id_utente,nome,cognome,password);
			}
		}catch(SQLException |IOException|PropertyVetoException e){
			e.printStackTrace();
		
		}finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			
		}

		return u;
	}

	//metodo

	public boolean inserisciUtente(String nome,String cognome,String password){
		boolean res=false;

		Connection con=DBConnection.getConnection();

		String sql="insert into UTENTE(nome,cognome,password)"+"VALUES(?,?,?)";

		PreparedStatement pst=null;

		int rs;
		try{
			pst=con.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3,password);

			rs=pst.executeUpdate();//mi restituisce il numero di righe aggiornate
			System.out.println(rs);
			res=true;
		}catch (SQLException e){
			e.printStackTrace();
			}


		return res;

	}
}
