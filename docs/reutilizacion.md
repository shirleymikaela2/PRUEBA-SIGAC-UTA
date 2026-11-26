# Reutilización de código — SIGAC-UTA

## Introducción

El proyecto aprovecha implementaciones desarrolladas durante el semestre en la asignatura de Estructura de Datos, adaptándolas al contexto de la gestión académica.

## Repositorios de origen

### M1. Vectores y estudiantes

Repositorio: [CRUD-Registro-Estudiantes](https://github.com/shirleymikaela2/CRUD-Registro-Estudiantes)

Archivos de origen:

- JAVA/Estudiante.java.
- JAVA/RegistroEstudiantes.java.

Adaptaciones:

- Sustitución del identificador por la matrícula.
- Reutilización de las operaciones CRUD.
- Validación de duplicados.
- Integración con otras estructuras.

### M1. Listas enlazadas

Repositorio: [Tarea-3_-Implementacion-de-listas](https://github.com/shirleymikaela2/Tarea-3_-Implementacion-de-listas)

Se reutilizaron los conceptos de nodos, referencias, inicio, fin, inserción y eliminación.

La implementación circular anterior se adaptó a una lista simplemente enlazada de estudiantes.

### M2. Pilas y colas

Repositorio: [T4.-Laboratorio-Gestor-de-impresiones](https://github.com/shirleymikaela2/T4.-Laboratorio-Gestor-de-impresiones)

Archivo de origen: GestorImpresiones.java.

Se conservó la lógica de atención FIFO y recuperación LIFO.

La implementación anterior utilizaba ArrayDeque. En SIGAC-UTA se sustituyó por estructuras enlazadas manuales para cumplir las restricciones del examen.

### M3. Árbol general y ABB

Repositorio: [Catálogo de la Biblioteca FISEI](https://github.com/shirleymikaela2/Cat-logo-de-la-Biblioteca-FISEI-con-rbol-general-y-ABB-en-Java.)

Archivos de referencia:

- src/negocio/CatalogoABB.java.
- src/negocio/ArbolBiblioteca.java.
- src/negocio/NodoLibro.java.
- src/negocio/NodoUnidad.java.

Se adaptaron los algoritmos de inserción, búsqueda, recorridos recursivos y eliminación mediante sucesor inorden.

El árbol general se adaptó a la jerarquía Universidad, Facultad, Carrera y Estudiantes.

### M4 y M5. Grafos y recomendaciones

Repositorio: [Implementación de grafos y sistemas de recomendación en Java](https://github.com/shirleymikaela2/T2.6_Implementacion_de_grafos_y_sistemas_de_recomendacion_en_Java)

Archivos de referencia:

- src/estructuras/Grafo.java.
- src/algoritmos/Recorridos.java.
- src/algoritmos/Recomendador.java.

Adaptaciones:

- Incorporación de aristas ponderadas.
- Compatibilidad con grafos dirigidos y no dirigidos.
- Recorridos BFS y DFS.
- Identificación de vértices no alcanzables.
- Eliminación de conexiones y vértices.
- Recomendaciones mediante amigos en común.
- Ordenamiento por inserción.

## Integración

Las estructuras fueron adaptadas mediante clases de servicio y un menú principal para consolidar sus funcionalidades en una sola aplicación.

Se utilizó asistencia de ChatGPT para revisar los repositorios anteriores, adaptar implementaciones, explicar el código y preparar pruebas.

Los repositorios originales no fueron modificados.