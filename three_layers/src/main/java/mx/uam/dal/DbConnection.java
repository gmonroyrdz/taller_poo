package mx.uam.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    // Cadena de conexión jdbc:mysql://localhost:3306/clientes , user, passwd
    private String dialect;
    private String host;
    private String port;
    private String dbname;
    private String user;
    private String password;

    private Connection connection;

    DbConnection(){
    }

    DbConnection(String host, String port, String dbname, String user, String password){
        this.dialect = "jdbc:mysql://";
        this.host = host;
        this.port = port;
        this.dbname = dbname;
        this.user = user;
        this.password = password;
    }

    public void connect(){
        try {
            String cadenaDeConeccion = dialect + this.host+ ":" +this.port+ "/" +this.dbname;
            this.connection = DriverManager.getConnection(cadenaDeConeccion, this.user, this.password);    
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }        
    }

    public void disconnect(){
        if(this.connection != null)
            try {
                this.connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    




}
