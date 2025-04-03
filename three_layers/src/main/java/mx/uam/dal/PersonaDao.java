package mx.uam.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uam.dal.entities.Persona;

/**
 * DAO para persona (Data Access Object)
 */
public class PersonaDao {

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
}
