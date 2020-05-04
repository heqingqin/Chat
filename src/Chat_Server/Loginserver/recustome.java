package Chat_Server.Loginserver;

import java.io.IOException;

public class recustome {
	public recustome(){
		
	}
	public boolean Recustome(String acctext, String nametext, String pwdtext, String whotext) throws ClassNotFoundException, IOException {
		boolean isok = new Datadeal().Dataregin(acctext,nametext,pwdtext,whotext);
		return isok;
	}
}
