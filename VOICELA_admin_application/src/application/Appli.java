package application;

import ihm.FenetreApplication;
import accesAuxDonnees.DaoEvenement;
import accesAuxDonnees.DaoFilm;
import accesAuxDonnees.DaoVip;
import accesAuxDonnees.SourceMySql;
import ihm.FenetreIdentification;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Appli {

    private static DataSource laSourceDeDonnees;
    private static Connection laConnexion;
    private static DaoVip daoVip;
    private static DaoEvenement daoEvenement;
    private static DaoFilm daoFilm;

    public static void main(String[] args) {

        // Look and Feel windows
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.print(e.getMessage());
        }

        // Etablissement de la connexion à la base MySql avec affichage de la fenetre d'identification 
        boolean etat = false;
        do {
            FenetreIdentification fi = new FenetreIdentification(null);
            PasswordAuthentication login = fi.identifier();
            try {
                laSourceDeDonnees = SourceMySql.getSource(login);
                laConnexion = laSourceDeDonnees.getConnection();
                etat = true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "login incorrect : " + ex.getMessage(), "Avertissement", JOptionPane.WARNING_MESSAGE);
            }
        } while (etat == false);

        // Instanciation des objets nécessaires à l'application
        try {
            // les DAO nécessaires
            daoVip = new DaoVip(laConnexion);
            daoEvenement = new DaoEvenement(laConnexion);
            daoFilm = new DaoFilm(laConnexion);
            
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FenetreApplication(daoVip, daoEvenement, daoFilm, laConnexion).setVisible(true);
                }
            });
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problème dans la création des objets nécessaires" + ex.getMessage(), "avertissement", JOptionPane.WARNING_MESSAGE);
        }
    }
}
