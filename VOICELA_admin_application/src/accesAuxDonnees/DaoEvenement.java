/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Drédré
 */
public class DaoEvenement {

    private final Connection connexion;

    public DaoEvenement(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }
}
