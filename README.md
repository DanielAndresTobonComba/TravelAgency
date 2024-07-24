# TravelAgency

## Trabajo realizado por
### Carlos Jhoan Aguilar 
### Daniel Andres Tobon

## Tecnologías usadas

- **Archivo JSON**: Se utiliza un archivo JSON para asignar dinámicamente funcionalidades a cada rol disponible. Este archivo contiene entidades y listas con códigos que facilitan esta asignación.

- **Properties**: Contamos con un archivo de configuración (`properties`) que se actualiza con los parámetros deseados para la base de datos. Este archivo es leído por la clase `ConfigDB` para generar la conexión a la base de datos.

- **DBConfig**: Implementamos el patrón de diseño Singleton para crear la conexión a la base de datos. De esta manera, la conexión se instancia una sola vez y puede ser accedida globalmente.

- **Controlador**: Utilizando el patrón de diseño Singleton y la clase abstracta `Funcionalidad` (que contiene un enunciado, código y método ejecutable), se crean las funcionalidades de cada rol en el archivo `CasesListController`. Estas funcionalidades se asignan a listas específicas, que son leídas por las vistas dinámicas de cada rol. Esto permite asignar una funcionalidad existente a un rol mediante la modificación del archivo JSON (agregando un código en la lista de la entidad del rol deseado). Si la funcionalidad no existe, solo es necesario crear la clase derivada de `Funcionalidad` sin modificar el código existente.

## Arquitectura

Se ha utilizado la arquitectura hexagonal con vertical slicing y screaming, asegurando que cada entidad posea su propia infraestructura, aplicación y dominio.



