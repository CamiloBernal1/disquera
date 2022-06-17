package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {

    Connection con; //Objeto para la conexion
    PreparedStatement ps; //Objeto para las sentencias preparadas
    ResultSet rs; //Objeto para almacenar los resultados de las consultas 
    String sql = null; // Variable para almacenar las sentencias de sql 
    int r; 


    public int registrar(AlbumVo album) throws 
    SQLException{

        sql="INSERT INTO album(nombreAlbum, anioPublicacion, idartista, idgenero, estadoAlbum) values(?,?)";

        try{

            con=Conexion.conectar(); //abrir conexión

            ps=con.prepareStatement(sql); //preparar sentencia

            ps.setString(1, album.getNombreAlbum());

            ps.setInt( 2, album.getAnioPublicacion());

            ps.setInt( 3, album.getIdArtista());

            ps.setInt( 4, album.getIdGenero());

            ps.setBoolean( 5, album.getEstadoAlbum());

            System.out.println(ps);

            ps.executeUpdate(); //Ejecutar sentencia

            ps.close(); //cerrar sentencia

            System.out.println("Se registró el album correctamente");

        }catch(Exception e){

            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{

            con.close();//cerrando conexión

        }

        return r;
    
}

public List<AlbumVo> listar() throws Exception{

    List<AlbumVo> albums = new ArrayList<>(); 

    sql = "SELECT * FROM album"; 

    try {

        con = Conexion.conectar(); // Genera la conexion 
        ps = con.prepareStatement(sql); // Prepara la sentencia del select
        rs = ps.executeQuery(); // Ejecutamos la sentencia y guardamos los resultados

        while (rs.next()){

            AlbumVo r = new AlbumVo(); 

            r.setIdAlbum(rs.getInt( "idAlbum")); 
            r.setNombreAlbum(rs.getString( "nombreAlbum"));
            r.setAnioPublicacion(rs.getInt( "anioPublicacion"));
            r.setIdArtista(rs.getInt( "idArtista"));
            r.setIdGenero(rs.getInt( "idGenero"));
            r.setEstadoAlbum(rs.getBoolean( "estadoAlbum"));

            albums.add(r); 

        }

        ps.close();
        System.out.println("Consulta exitosa");

    } catch (Exception e){
        System.out.println("No hay albunes definidos" +e.getMessage());

    }finally{

        con.close(); // Cerrando la conexion 
    }

    return albums; 
}

}
