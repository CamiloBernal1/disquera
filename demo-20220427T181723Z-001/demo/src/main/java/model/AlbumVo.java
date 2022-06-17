package model;

public class AlbumVo {

    private int idAlbum; 
    private String nombreAlbum; 
    private int anioPublicacion; 
    private int idArtista; 
    private int idGenero; 
    private boolean estadoAlbum; 
    

public AlbumVo(){

}

public AlbumVo(int idAlbum, String nombreAlbum, int anioPublicacion, int idArtista, int idGenero, boolean estadoAlbum){

    this.idAlbum = idAlbum; 
    this.nombreAlbum = nombreAlbum; 
    this.anioPublicacion = anioPublicacion; 
    this.idArtista = idArtista; 
    this.idGenero = idGenero; 
    this.estadoAlbum = estadoAlbum; 

}

public int getIdAlbum(){

    return idAlbum; 

}

public void setIdAlbum(int idAlbum){

    this.idAlbum = idAlbum; 
}

public String getNombreAlbum(){

    return nombreAlbum; 
}

public void setNombreAlbum(String nombreAlbum){

    this.nombreAlbum = nombreAlbum; 
}

public int getAnioPublicacion(){

    return anioPublicacion; 
}

public void setAnioPublicacion(int anioPublicacion){

    this.anioPublicacion = anioPublicacion; 

}

public int getIdArtista(){

    return idArtista; 

}

public void setIdArtista(int idArtista){

    this.idArtista = idArtista; 

}

public int getIdGenero(){

    return idGenero; 

}

public void setIdGenero(int idGenero){

    this.idGenero = idGenero; 
}

public boolean getEstadoAlbum(){

    return estadoAlbum; 

}

public void setEstadoAlbum(boolean estadoAlbum){

    this.estadoAlbum = estadoAlbum; 
}

}
