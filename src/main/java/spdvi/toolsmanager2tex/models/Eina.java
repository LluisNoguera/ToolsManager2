package spdvi.toolsmanager2tex.models;

public class Eina {
    private int id;
    private String nom;
    private String foto;
    private String tipomimefoto;

    public Eina(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    

    public Eina(int id, String nom, String foto, String tipomimefoto) {
        this.id = id;
        this.nom = nom;
        this.foto = foto;
        this.tipomimefoto = tipomimefoto;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipomimefoto() {
        return tipomimefoto;
    }

    public void setTipomimefoto(String tipomimefoto) {
        this.tipomimefoto = tipomimefoto;
    }

    @Override
    public String toString() {
        return "Eina{" + "id=" + id + ", nom=" + nom + ", foto=" + foto + ", tipomimefoto=" + tipomimefoto + '}';
    }
}
