package accesAuxDonnees;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.commons.net.ftp.FTPClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.sql.DataSource;

/**
 *
 * @author Drédré
 */
public class FTPSource {
/*
    public static FTPClient getSource(PasswordAuthentication login) throws Exception {
        FTPSource clientFTP = new FTPSource();
        FileInputStream f_stream = null;// récupération des informations d'authentification
        //String user = login.getUserName();
        //String pwd = new String(login.getPassword());
        // création d'un objet Properties à parir du fichier 
        Properties props = new Properties();
        FileInputStream fichier = new FileInputStream("src/connexionFTP.properties");
        props.load(fichier);
        return 1;
    }*/
}
