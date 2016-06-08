package accesAuxDonnees;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPSClient;

public class DaoFTP {

    private FTPSClient ftp;

    public DaoFTP() {
        ftp = new FTPSClient();
        try {
            FileInputStream fichier;
            fichier = new FileInputStream("src/connexionFTP.properties");
            Properties props = new Properties();
            props.load(fichier);

            ftp.connect("iutdoua-samba.univ-lyon1.fr", 990);
            if (!ftp.login(props.getProperty("username"), props.getProperty("password"))) {
                throw new Exception("Problème de login au serveur");
            }
            boolean testConnexion = ftp.sendNoOp();
            if (testConnexion == false) {
                throw new Exception("Echec de la connexion au serveur");
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
        } catch (Exception e) {

        }
    }

}
