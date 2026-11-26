# Matriz de pruebas — SIGAC-UTA

## Resultados de la ejecución local

| Código | Caso de prueba | Resultado esperado | Estado |
|---|---|---|---|
| P01 | Registrar siete estudiantes | 7 estudiantes registrados | OK |
| P02 | Búsqueda secuencial | Estudiante encontrado | OK |
| P03 | Matrícula duplicada | Registro rechazado | OK |
| P04 | Estudiante nulo | Registro rechazado | OK |
| P05 | Matrícula inexistente | Retorna null | OK |
| P06 | Modificar estudiante | Datos actualizados | OK |
| P07 | Sincronización con ABB | Datos actualizados | OK |
| P08 | Eliminar matrícula inexistente | Operación rechazada | OK |
| P09 | Vector lleno | Registro rechazado | OK |
| P10 | Registrar tres solicitudes | 3 pendientes | OK |
| P11 | Solicitud duplicada | Registro rechazado | OK |
| P12 | Estudiante inexistente | Solicitud rechazada | OK |
| P13 | Primera atención FIFO | Solicitud 1 | OK |
| P14 | Segunda atención FIFO | Solicitud 2 | OK |
| P15 | Tercera atención FIFO | Solicitud 3 | OK |
| P16 | Atender cola vacía | Retorna null | OK |
| P17 | Primera recuperación LIFO | Solicitud 3 | OK |
| P18 | Segunda recuperación LIFO | Solicitud 2 | OK |
| P19 | Solicitudes recuperadas | 2 pendientes | OK |
| P20 | Estudiante con solicitudes | Asociación detectada | OK |
| P21 | Búsqueda en ABB | Estudiante encontrado | OK |
| P22 | Validar ABB inicial | Verdadero | OK |
| P23 | Eliminar nodo 30 con dos hijos | Eliminación exitosa | OK |
| P24 | Buscar nodo eliminado en ABB | Retorna null | OK |
| P25 | Buscar nodo eliminado en vector | Retorna null | OK |
| P26 | Validar ABB después de eliminar | Verdadero | OK |
| P27 | Registrar equipos | 6 equipos | OK |
| P28 | Recorrido BFS | PC1 SW1 PC3 SRV1 PC2 | OK |
| P29 | Recorrido DFS | PC1 SW1 SRV1 PC2 PC3 | OK |
| P30 | Detectar equipo aislado | PC4 | OK |
| P31 | Arista duplicada | Operación rechazada | OK |
| P32 | Equipo inexistente | Operación rechazada | OK |
| P33 | Eliminar arista | Eliminación exitosa | OK |
| P34 | Actualizar conectividad | SRV1 PC2 PC4 no alcanzables | OK |
| P35 | Recomendar a Diego | 2 amigos en común | OK |
| P36 | Recomendar a Elena | 1 amigo en común | OK |
| P37 | Ordenar recomendaciones | Diego antes de Elena | OK |
| P38 | Excluir usuario y amigos directos | Exclusión correcta | OK |
| P39 | Amistad duplicada | Operación rechazada | OK |
| P40 | Usuario inexistente | Mensaje de validación | OK |

## Resumen de resultados

- Fecha de ejecución: 26 de noviembre de 2026.
- Pruebas ejecutadas: 40.
- Pruebas correctas: 40.
- Pruebas fallidas: 0.
- Porcentaje de éxito de la suite: 100 %.

Las pruebas fueron ejecutadas localmente mediante la clase pruebas.PruebasSIGAC. Los resultados corresponden a los casos incluidos en la suite automatizada.

## Conclusión

La ejecución permitió verificar las operaciones principales de los módulos M1 a M5, incluyendo las validaciones, los recorridos de árboles y grafos, la atención FIFO, la recuperación LIFO y las recomendaciones de contactos.

La suite no constituye una cobertura exhaustiva de todas las funcionalidades del sistema.