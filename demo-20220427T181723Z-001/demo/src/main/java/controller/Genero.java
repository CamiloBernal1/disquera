package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeneroDao;
import model.GeneroVo;

public class Genero extends HttpServlet {

    GeneroDao gdao = new GeneroDao(); 
    GeneroVo gvo = new GeneroVo(); 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Entro al DoGet");
        String accion = req.getParameter("accion"); 

        switch(accion){

            case "abrirForm": 
            abrirForm(req, resp); 
            break; 

            case "listar":

            listar(req, resp); 
            break; 

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Entro al DoPost");
        String accion = req.getParameter("accion"); 

        switch(accion){

            case "addGenero": 

            addGenero(req, resp); 

            break; 
        }

    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/genero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }

    }

    private void addGenero(HttpServletRequest req, HttpServletResponse resp) {
        
        GeneroDao gdao=new GeneroDao();
        GeneroVo gVo=new GeneroVo();

        if(req.getParameter("nombreGenero")!=null){
            gVo.setNombreGenero(req.getParameter("nombreGenero"));
        }

        if(req.getParameter("estadoGenero")!=null){
            gVo.setEstadoGenero(true);
        }
        else{
            gVo.setEstadoGenero(false);
        }

        try {

           gdao.registrar(gVo); 

            resp.sendRedirect("genero?accion=listar");

            System.out.println("Registro insertado correctamente");
        
        } catch (Exception e) {

            req.setAttribute("msje","no se pudo registrar el Rol"+e.getMessage());
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());

        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {

        GeneroDao gdao=new GeneroDao();
        GeneroVo gVo=new GeneroVo();

        try {

            List <GeneroVo> genero = gdao.listar(); 

            req.setAttribute("generos", genero);

            req.getRequestDispatcher("views/listgenero.jsp").forward(req, resp);

            System.out.println("Datos listados correctamente");

        } catch (Exception e) {

            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }}