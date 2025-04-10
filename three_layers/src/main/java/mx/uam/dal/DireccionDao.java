package mx.uam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import mx.uam.dal.entities.Direccion;

public class DireccionDao implements EntityDao<Direccion>{

    private Connection connection;

    public DireccionDao(){
        DbConnection db = new DbConnection("localhost","3306","clientes","cliente_usr","p455w0rD!");
            db.connect();
            this.connection = db.getConnection();
    }

    @Override
    public List<Direccion> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Direccion getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public void save(Direccion entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void modify(Direccion entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Direccion WHERE id=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
