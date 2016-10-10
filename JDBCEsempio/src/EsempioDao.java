import model.Utente;
import dao.UtenteDao;


public class EsempioDao {

	public static void main(String[] args) {
		UtenteDao uDao=new UtenteDao();
		
		Utente u=uDao.leggiUtenteConId(11);
		System.out.println(u.getNome()+" "+u.getCognome()+" "+u.getPassword());
		
		//provo secondo metodo
		boolean r=uDao.inserisciUtente("Viviana", "Vacirca", "hggrrg");
		
		
	}

}
