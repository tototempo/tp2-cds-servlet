package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Trabajo Práctico - Punto 10 (Servlet)
 * Servlet mínimo que recibe datos enviados desde el formulario HTML y
 * muestra un mensaje de bienvenida con el nombre ingresado.
*/
@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // Establecemos el tipo de contenido de la respuesta como HTML
        response.setContentType("text/html; charset=UTF-8");

        // Obtenemos el parámetro "nombre" enviado por el formulario
        String nombre = request.getParameter("nombre");

        // Si por alguna razón no viene el nombre, mostramos un texto genérico "visitante"
        if (nombre == null || nombre.isBlank()) {
            nombre = "visitante";
        }

        // Respuesta HTML simple
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"es\">");
            out.println("<head>");
            out.println("  <meta charset=\"UTF-8\">");
            out.println("  <title>Bienvenida</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("  <h1>¡Bienvenido/a, " + escapeHtml(nombre) + "!</h1>");
            out.println("  <p>Tu formulario fue procesado correctamente.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Implementación mínima de seguridad para caracteres especiales y evitar un caso de HTML
    private String escapeHtml(String input) {
        return input
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
