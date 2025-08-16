# Trabajo Práctico – HTML + Servlet (Java)

Este repositorio contiene:
- `index.html` (para subir a Drive en el punto 9).
- Un proyecto Maven `servlet-demo` con un Servlet mínimo que procesa el formulario (punto 10).

## Cómo ejecutar **sin instalar nada** (100% en el navegador)

### Opción A) Gitpod (recomendado)
1. Crea un repositorio nuevo en GitHub y sube la carpeta `servlet-demo` (tal cual).
2. Abre `https://gitpod.io/#` seguido de la URL de tu repo (ej.: `https://gitpod.io/#https://github.com/tu-usuario/tu-repo`).
3. En la terminal de Gitpod, ejecuta:
   ```bash
   cd servlet-demo
   mvn -q clean package jetty:run
   ```
4. Gitpod abrirá el puerto 8080. Ingresa a la vista previa y verás `index.html`.
5. Completá el formulario y envíalo: deberías ver el saludo del Servlet en `/hello`.

### Opción B) GitHub Codespaces
1. Sube la carpeta `servlet-demo` a un repo de GitHub.
2. Abre el repo en Codespaces (todo en el navegador).
3. Ejecuta:
   ```bash
   cd servlet-demo
   mvn -q clean package jetty:run
   ```
4. Expón el puerto 8080 y abre la URL de vista previa.

> Nota: En ambos casos no instalás nada localmente. El contenedor corre en la nube.

## Entregables para la cátedra
- Punto 9: Subí **`index.html`** a tu Drive y pega el enlace en el documento de entrega.
- Punto 10: Subí **`HelloServlet.java`** (y opcionalmente `web.xml`) a tu Drive y pega los enlaces.
  - Los archivos se encuentran en: `servlet-demo/src/main/java/com/example/HelloServlet.java` y `servlet-demo/src/main/webapp/WEB-INF/web.xml`.

## Estructura
```
servlet-assignment/
├─ index.html
└─ servlet-demo/
   ├─ pom.xml
   └─ src/main/
      ├─ java/com/example/HelloServlet.java
      └─ webapp/
         ├─ index.html
         └─ WEB-INF/web.xml
```

## Aclaración sobre ciclo de vida del Servlet
- `init()`: el contenedor (Jetty/Tomcat) inicializa el Servlet una sola vez.
- `service()`: atiende cada request y redirige a `doGet()`/`doPost()` según el método HTTP.
- `destroy()`: se invoca cuando el contenedor va a descargar la instancia del Servlet.

¡Listo! Solo resta que subas los archivos a Drive y pegues los enlaces.