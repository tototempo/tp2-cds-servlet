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
 *
 * Ciclo de vida (resumen):
 * - init(): se ejecuta una vez cuando el contenedor crea la instancia del Servlet.
 * - service(): atiende cada solicitud entrante (delegando en doGet/doPost según método HTTP).
 * - destroy(): se ejecuta una vez, antes de que el contenedor descarte la instancia.
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

        // Si por alguna razón no viene el nombre, evitamos NPE y mostramos un texto genérico
        if (nombre == null || nombre.isBlank()) {
            nombre = "visitante";
        }

        // Escribimos una respuesta HTML simple
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

    // Implementación mínima para escapar caracteres especiales y evitar HTML injection
    private String escapeHtml(String input) {
        return input
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}