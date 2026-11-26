# Análisis de complejidad temporal — SIGAC-UTA

## Objetivo

Analizar la eficiencia de las principales operaciones implementadas en las estructuras de datos del sistema.

## Complejidad de las operaciones

| Estructura | Operación | Complejidad | Justificación |
|---|---|---|---|
| Vector | Búsqueda secuencial | O(n) | Puede recorrer todos los elementos. |
| Vector | Eliminación | O(n) | Requiere buscar y desplazar elementos. |
| Lista enlazada | Búsqueda | O(n) | Recorre los nodos secuencialmente. |
| Lista enlazada | Eliminación | O(n) | Requiere localizar el nodo. |
| Cola | Encolar | O(1) | Utiliza una referencia al último nodo. |
| Cola | Desencolar | O(1) | Retira directamente el primer nodo. |
| Pila | Apilar | O(1) | Inserta directamente en la cima. |
| Pila | Desapilar | O(1) | Retira directamente el nodo superior. |
| ABB | Búsqueda | O(h) | Recorre una rama según las comparaciones. |
| ABB | Inserción | O(h) | Localiza la posición mediante comparaciones. |
| ABB | Eliminación | O(h) | Localiza el nodo y reorganiza sus referencias. |
| ABB | Recorrido inorden | O(n) | Visita todos los nodos. |
| Árbol general | Búsqueda | O(n) | Puede visitar todos los nodos. |
| Grafo | BFS | O(V + E) | Recorre vértices y adyacencias. |
| Grafo | DFS | O(V + E) | Explora los vértices mediante recursividad. |
| Recomendaciones | Ordenamiento por inserción | O(k²) | Compara y desplaza candidatos. |

## Variables utilizadas

- n: número de elementos.
- h: altura del árbol binario.
- V: número de vértices.
- E: número de aristas.
- k: número de candidatos recomendados.

## Comparación entre búsqueda secuencial y ABB

La búsqueda secuencial presenta una complejidad O(n).

La búsqueda mediante ABB presenta una complejidad O(h), que puede aproximarse a O(log n) cuando el árbol se encuentra equilibrado. En el peor caso, un árbol desbalanceado presenta una complejidad O(n).

El sistema permite comparar la cantidad de elementos o nodos examinados durante ambas búsquedas.

## Observaciones

Las complejidades corresponden a las operaciones individuales de las estructuras. Las operaciones de los servicios integrados pueden requerir búsquedas y validaciones adicionales.

## Conclusión

La selección de estructuras de datos permite optimizar diferentes operaciones. Las pilas y colas facilitan el procesamiento de solicitudes, mientras que los árboles y grafos permiten organizar información y analizar relaciones.