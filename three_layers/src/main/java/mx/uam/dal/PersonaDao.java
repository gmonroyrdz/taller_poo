package mx.uam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uam.dal.entities.Persona;

/**
 * DAO para persona (Data Access Object)
 */
public class PersonaDao implements EntityDao<Persona> {

        private Connection connection;

        public PersonaDao(){
            DbConnection db = new DbConnection("localhost","3306","clientes","cliente_usr","p455w0rD!");
            db.connect();
            this.connection = db.getConnection();
        }

        public List<Persona> getAll(){
            List<Persona> personas = new ArrayList<>();

            String sql = "SELECT * FROM Persona";
            try {
                Statement stmt = this.connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Persona persona = new Persona();
                    persona.setId(rs.getInt(1));
                    persona.setNombre(rs.getString(2));
                    persona.setApellidoPaterno(rs.getString(3));
                    persona.setApellidoMaterno(rs.getString(4));
                    persona.setEdad(rs.getString(5));
                    persona.setGenero(rs.getString(6));
                    personas.add(persona);
                }
                return personas;

            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }    
        }

        @Override
        public Persona getById(int id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getById'");
        }

        public void save(Persona persona){
            String sql = "INSERT INTO Persona VALUES(0,?,?,?,?,?)";
            try {
                PreparedStatement stmt = this.connection.prepareStatement(sql);
                stmt.setString(1, persona.getNombre());
                stmt.setString(2, persona.getApellidoPaterno());
                stmt.setString(3, persona.getApellidoMaterno());
                stmt.setString(4, persona.getEdad());
                stmt.setString(5, persona.getGenero());                
                stmt.execute(sql);
                
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }    
        }



        public void modify(Persona persona){
            String sql = "UPDATE FROM Persona SET nombre=',apellido_paterno=?, apellido_materno=?,edad=?,genero=? WHERE id=?";
            try {
                PreparedStatement stmt = this.connection.prepareStatement(sql);
                stmt.setString(1, persona.getNombre());
                stmt.setString(2, persona.getApellidoPaterno());
                stmt.setString(3, persona.getApellidoMaterno());
                stmt.setString(4, persona.getEdad());
                stmt.setString(5, persona.getGenero());
                stmt.setInt(6, persona.getId());
                stmt.execute(sql);
                
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }    
        }


        public void delete(int id){
            String query = "DELETE from Persona WHERE id=?";
            try {
                PreparedStatement stmt = this.connection.prepareStatement(query);
                stmt.setInt(1, id);
                stmt.execute();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        
}
