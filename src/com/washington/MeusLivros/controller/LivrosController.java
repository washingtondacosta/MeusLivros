package com.washington.MeusLivros.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.washington.MeusLivros.dao.DaoLivros;
import com.washington.MeusLivros.model.Livros;

public class LivrosController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private DaoLivros livrosDao = DaoLivros.getInstance();
	private static final Logger LOGGER = Logger.getLogger(LivrosController.class.getName());
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String action = req.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(req, resp);
				break;
			case "/insert":
				insertLivros(req, resp);
			break;
			case "/delete":
				deleteLivros(req,resp);
			break;
			case "/edit":
				showEditForm(req,resp);
			break;
			case "/update":
				updateLivros(req,resp);
			break;
			default:
				listLivros(req,resp);
				break;
			}			
		} catch (SQLException e) {
			// For simplicity just Log  the Exceptions
			LOGGER.log(Level.SEVERE, "SQL Error", e);
		}

		
	}

	private void updateLivros(HttpServletRequest req, HttpServletResponse resp) 
	throws SQLException,IOException, ServletException{
		int id = Integer.parseInt(req.getParameter("id"));
		String titulo = req.getParameter("titulo");
		String autor = req.getParameter("autor");
		String anoLancamento = req.getParameter("anolancamento");
		String resumo = req.getParameter("resumo");
		
		Livros livros = new Livros(id, titulo, autor, anoLancamento, resumo);
		livrosDao.update(livros);
		resp.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse resp) 
	throws SQLException, IOException, ServletException{
		int id = Integer.parseInt(req.getParameter("id"));
		Optional<Livros> existingLivros = livrosDao.find(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/LivrosForm.jsp");
		existingLivros.ifPresent(s->req.setAttribute("livros", s));
		dispatcher.forward(req, resp);
	}

	private void deleteLivros(HttpServletRequest req, HttpServletResponse resp) 
	throws SQLException, IOException, ServletException{
		int id = Integer.parseInt(req.getParameter("id"));
		
		Livros livros = new Livros(id);
		livrosDao.delete(livros);
		resp.sendRedirect("list");
	}

	private void insertLivros(HttpServletRequest req, HttpServletResponse resp) 
	throws SQLException, IOException, ServletException{
		String titulo = req.getParameter("titulo");
		String autor = req.getParameter("autor");
		String anoLancamento = req.getParameter("anolancamento");
		String resumo = req.getParameter("resumo");
		
		Livros newLivros = new Livros(titulo, autor, anoLancamento, resumo);
		livrosDao.save(newLivros);
		resp.sendRedirect("list");		
	}

	private void showNewForm(HttpServletRequest req, HttpServletResponse resp) 
	throws SQLException, IOException, ServletException{
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/LivrosForm.jsp");
		dispatcher.forward(req, resp);
	}

	private void listLivros(HttpServletRequest req, HttpServletResponse resp) 
	throws SQLException, IOException, ServletException{
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/LivrosList.jsp");
		
		List<Livros> listLivros = livrosDao.findAll();
		req.setAttribute("listLivros", listLivros);
		
		dispatcher.forward(req, resp);
	}
}
