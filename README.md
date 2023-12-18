# Prueba Técnica Java - Sistema de Gestión de Biblioteca.

En este repositorio se comparte la solución de una prueba técnica sobre el desarrollo de una aplicación de gestión de una Biblioteca.
Se pretende realizar que gestione la información sobre los libros vinculados a la misma y la información de las personas que se 
pueden clasificar en 2 tipos: usuarios y empleados.

## Detalles del Sistema
Se detalla la información que debe tener el sistema y las funcionalidades.

## Información

### **Persona**
  - Nombre
  - Apellido
  - Número de identificación
  - Estado Civil

### **Empleados**
  - Año de incorporación a la biblioteca
  - Sector de trabajo

### **Usuarios**
  - Número de Cliente
  - Libros prestados
  - Total de libros prestados
  
### **Libros**
  - Titulo
  - Género
  - Autor
  - Año de publivcación
  - Estado (Disponible o Prestado)

  ## Funcionalidades

  ### - Alta de Libro

  ### - Alta de Empleado

  ### - Alta de Usuario
  
  ### - Prestamo de Libro
  
  ### - Devolución de Libro

  ### - Listado de todos los libros prestados
  
  ### - Listado de usuarios con libros prestados
  
  ### - Listado de todos los libros según el género específico.

  <br><br>

## Diagramas

Se muestran los diagramas de clases y diagramas de base de datos.

### Diagrama de Clases.

![Clases](https://github.com/EnzoCruzate/Entrevista_Tecnica_PWC/blob/main/Diagramas/Diagrama_de_Clases.jpg)

### Diagrama de Base de Datos.

![Clases](https://github.com/EnzoCruzate/Entrevista_Tecnica_PWC/blob/main/Diagramas/Diagrama_de_Base_de_Datos.jpg)

<br><br>

## Especifiaciones para la Base de Datos 

  - Nombre: "dblibrary$"
  - Usuario: "root"
  - Contraseña: 12345
  - IP: "localhost"
  - Puerto: 3306
  - Driver: "mysql-connector-j-8.1.0" (compartido dentro de la carpeta).

Se proporciona el archivo "dblibrary$.sql" donde se encuentra la base de datos, la cual debe ser importada dentro de su administrador
de base de datos.
Si la conexión no es aceptada revisar en "dbConnection" si son compatibles su "Usuario" y "Contraseña" con los de la base de datos.

<br>

## Especificaciones para la Aplicación

Se requiere utlizar el drive proporcionado y hacer la instalación del mismo.

Si se utiliza IntelliJ IDEA se puede realizar la instalación con los siguientes pasos:
  - Selecionar File/Project Structure/Modules/Dependencias
  - Una vez dentro seleccionar el botón "+" y la opción 1 "JARs or Directories"
  - Seleccionar el conector proporcionado, luego "Apply" y "OK"
  - Luego seleccionar views/tool Windows/DataBase
  - Dentro seleccionar el botón "+" y "Driver" dentro buscar en "Complete Support" la sección de "MySQL"
  - Luego seleccionar el botón "+" y "Customs JARs", buscar el conector Driver proporcionado y seleccionarlo, "Apply" y "OK"

En este momento ya estaría conectado con la MySQL.
 <br><br>

Para realizar la ejecución se requiere correr el archivo "mainLibrary" dentro de "testLibrary".
