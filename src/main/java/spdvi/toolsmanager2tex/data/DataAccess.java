package spdvi.toolsmanager2tex.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import spdvi.toolsmanager2tex.models.Eina;
import spdvi.toolsmanager2tex.models.Usuari;

/**
 *
 * @author Miguel
 */
public class DataAccess {

    //private String connectionString2 = "jdbc:sqlserver://localhost:1433;databaseName=toolsmanagerdb;integratedSecurity=true;user=Miguel";
    //private String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=toolsmanagerdb;user=sa;password=Pwd1234.;encrypt=true;trustServerCertificate=true;";
    //private String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=toolsmanagerdb;user=sa;password=Pwd1234.;encrypt=true;trustServerCertificate=true;";
    
    private Connection getConnection() throws SQLException {
        Connection connection = null;
        Properties properties = new Properties();
        try
        {
            
            
            //connection = DriverManager.getConnection(connectionString);
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
            
            
        } catch (IOException ex)
        {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public ArrayList<Usuari> getUsuaris() throws SQLException {
        ArrayList<Usuari> usuaris = new ArrayList<>();

        String sql = "SELECT * FROM dbo.usuaris";
        Connection connection = getConnection();
        PreparedStatement selectStatement = connection.prepareStatement(sql);
        ResultSet resultSet = selectStatement.executeQuery();
        while (resultSet.next()) {
            Usuari user = new Usuari();
            user.setId(resultSet.getInt("id"));
            user.setNom(resultSet.getString("nom").trim());
            user.setLlinatge(resultSet.getString("llinatge").trim());
            user.setUsername(resultSet.getString("username").trim());
            user.setEmail(resultSet.getString("email").trim());
            user.setPassword(resultSet.getString("password").trim());
            user.setFoto(resultSet.getString("foto").trim());
            user.setFotoMimeType(resultSet.getString("fotoMimeType").trim());

            usuaris.add(user);
        }

        connection.close();
        selectStatement.close();

        return usuaris;
    }

    public void setUsuari(Usuari usuari) throws SQLException{
        int result = 0;
        String sql = "INSERT INTO dbo.usuaris(nom,llinatge,username,email,password,foto,fotoMimeType) VALUES(" +"'"+usuari.getNom()+"'" + "," + "'"+usuari.getLlinatge()+"'" + "," + "'"+usuari.getUsername()+"'" + "," +
                "'"+usuari.getEmail()+"'" + "," +"'"+ usuari.getPassword()+"'"+","+"'"+usuari.getFoto()+"'"+ ","+"'"+"image/png"+"'"+")";
        try (Connection connection = getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(sql);) {
            result = insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*Connection connection = getConnection();
        PreparedStatement insertStatement = connection.prepareStatement(sql);
        insertStatement.executeUpdate();
        connection.close();
        insertStatement.close();*/
        System.out.println("res: "+ result);
    }

    public ArrayList<Eina> getTools(int usuariId) {
        ArrayList<Eina> tools = new ArrayList<>();
        try ( Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "SELECT * FROM dbo.Inventari JOIN dbo.[tools]"
                            + " ON Inventari.id_eina=tools.id"
                            + " WHERE Inventari.id_usuari=?"
            );
            selectStatement.setInt(1, usuariId);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Eina tool = new Eina(
                        resultSet.getInt("id"),
                        resultSet.getString("nom").trim(),
                        resultSet.getString("foto").trim(),
                        resultSet.getString("tipomimefoto").trim()
                );
                tools.add(tool);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return tools;
    }
    
}
