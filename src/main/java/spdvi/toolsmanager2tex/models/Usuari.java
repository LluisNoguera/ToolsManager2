/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.toolsmanager2tex.models;

import java.sql.SQLException;
import java.util.ArrayList;
import spdvi.toolsmanager2tex.data.DataAccess;

/**
 *
 * @author Miguel
 */
public class Usuari {

    private int id;
    private String nom;
    private String llinatge;
    private String username;
    private String email;
    private String password;
    private String foto;
    private String fotoMimeType;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuari{");
        sb.append("id=").append(id);
        sb.append(", nom=").append(nom);
        sb.append(", llinatge=").append(llinatge);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", foto=").append(foto);
        sb.append(", fotoMimeType=").append(fotoMimeType);
        sb.append('}');
        return sb.toString();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatge() {
        return llinatge;
    }

    public void setLlinatge(String llinatge) {
        this.llinatge = llinatge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFotoMimeType() {
        return fotoMimeType;
    }

    public void setFotoMimeType(String fotoMimeType) {
        this.fotoMimeType = fotoMimeType;
    }

    public static int createNewID() throws SQLException{
        DataAccess da = new DataAccess();
        ArrayList<Usuari> users = new ArrayList<>();
        users = da.getUsuaris();
        int res = 0;
        for(Usuari user : users){      
            res = user.getId();
        }
        res = res + 1;
        return res;
    }
    
}
