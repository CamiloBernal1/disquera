package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {

    Connection con; //Objeto para la conexion
    PreparedStatement ps; //Objeto para las sentencias preparadas
    ResultSet rs; //Objeto para almacenar los resultados de las consultas 
    String sql = null; // Variable para almacenar las sentencias de sql 
    int r; 


    public int registrar(GeneroVo genero) throws 
    SQLException{

        sql="INSERT INTO genero(nombreGenero, estadoGenero) values(?,?)";

        try{

            con=Conexion.conectar(); //abrir conexión

            ps=con.prepareStatement(sql); //preparar sentencia

            ps.setString(1, genero.getNombreGenero());

            ps.setBoolean(2, genero.getEstadoGenero());

            System.out.println(ps);

            ps.executeUpdate(); //Ejecutar sentencia

            ps.close(); //cerrar sentencia

            System.out.println("Se registró el genero correctamente");

        }catch(Exception e){

            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{

            con.close();//cerrando conexión

        }

        return r;

}
    public List<GeneroVo> listar() throws Exception{

        List<GeneroVo> generos = new ArrayList<>(); 

        sql = "SELECT * FROM genero"; 

        try {

            con = Conexion.conectar(); // Genera la conexion 
            ps = con.prepareStatement(sql); // Prepara la sentencia del select
            rs = ps.executeQuery(); // Ejecutamos la sentencia y guardamos los resultados

            while (rs.next()){

                GeneroVo r = new GeneroVo(); 

                r.setIdGenero(rs.getInt("idGenero")); 
                r.setEstadoGenero(rs.getBoolean("estadoGenero"));
                r.setNombreGenero(rs.getString("nombreGenero")); 
                generos.add(r);   

            }

            ps.close();
            System.out.println("Consulta exitosa");

        } catch (Exception e){
            System.out.println("No hay roles definidos" +e.getMessage());

        }finally{
            con.close(); // Cerrando la conexion 
        }

        return generos; 
    }

}
