package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumDao;
import model.AlbumVo;

public class Album extends HttpServlet {

    AlbumDao albumdao = new AlbumDao(); 
    AlbumVo albumvo = new AlbumVo(); 

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        System.out.println("Entro al doGet");

        String accion1 = req.getParameter("accion1"); 

        switch(accion1){

            case "AbrirForm2": 
            abrirForm2 (req, resp); 
            break; 

            case "listar2":

            listar2 (req, resp); 
            break; 

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Entro al DoPost");
        String accion1 = req.getParameter("accion1"); 

        switch(accion1){

            case "addAlbum": 

            addAlbum(req, resp); 

            break; 
        }

    }

    private void abrirForm2(HttpServletRequest req, HttpServletResponse resp) {

        try{

            req.getRequestDispatcher("views/album.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");

        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }

    }

    private void addAlbum(HttpServletRequest req, HttpServletResponse resp) {

    AlbumDao albumdao = new AlbumDao(); 
    AlbumVo albumvo = new AlbumVo(); 

    
        if(req.getParameter("nombreAlbum")!=null){
            albumvo.setNombreAlbum(req.getParameter("nombreAlbum"));
        }

        if(req.getParameter("anioPublicacion")!=null){
            albumvo.setAnioPublicacion(0);
        }

        if(req.getParameter("idartista")!=null){
           albumvo.setIdArtista(0);
        }

        if(req.getParameter("idgenero")!=null){
            albumvo.setIdGenero(0);
        }

        if(req.getParameter("estadoAlbum")!=null){
            albumvo.setEstadoAlbum(true);
        }
        else{
            albumvo.setEstadoAlbum(false);
        }

        try {

           albumdao.registrar(albumvo);

            resp.sendRedirect("album?accion1=listar2");

            System.out.println("Registro insertado correctamente");
        
        } catch (Exception e) {

            req.setAttribute("msje","No se pudo registrar el album"+e.getMessage());
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());

        }
    }

    private void listar2(HttpServletRequest req, HttpServletResponse resp) {

    AlbumDao albumdao = new AlbumDao(); 
    AlbumVo albumvo = new AlbumVo(); 

        try {

            List <AlbumVo> album = albumdao.listar(); 

            req.setAttribute("albums", album);

            req.getRequestDispatcher("views/listalbum.jsp").forward(req, resp);

            System.out.println("Datos listados correctamente");

        } catch (Exception e) {

            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }}


    

