# TravelAgency

## Trabajo realizado por
### Carlos Jhoan Aguilar 
### Daniel Andres Tobon


### Para usar el software se debe inciar sesion con las siguientes credenciales
### usuario: admin123 - contrasela: admin123

## Tecnologías usadas

- **Archivo JSON**: Se utiliza un archivo JSON para asignar dinámicamente funcionalidades a cada rol disponible. Este archivo contiene entidades y listas con códigos que facilitan esta asignación.

- **Properties**: Contamos con un archivo de configuración (`properties`) que se actualiza con los parámetros deseados para la base de datos. Este archivo es leído por la clase `ConfigDB` para generar la conexión a la base de datos.

- **DBConfig**: Implementamos el patrón de diseño Singleton para crear la conexión a la base de datos. De esta manera, la conexión se instancia una sola vez y puede ser accedida globalmente.

- **Controlador**: Utilizando el patrón de diseño Singleton y la clase abstracta `Funcionalidad` (que contiene un enunciado, código y método ejecutable), se crean las funcionalidades de cada rol en el archivo `CasesListController`. Estas funcionalidades se asignan a listas específicas, que son leídas por las vistas dinámicas de cada rol. Esto permite asignar una funcionalidad existente a un rol mediante la modificación del archivo JSON (agregando un código en la lista de la entidad del rol deseado). Si la funcionalidad no existe, solo es necesario crear la clase derivada de `Funcionalidad` sin modificar el código existente.

- **Bases de datos relacional MySQL**: A través del archivo `tablas` se encuentra la creación de las tablas de la base de datos junto con las inserciones de prueba y procedimientos almacenados.

- **Procedimientos almacenados**: Mediante procedimientos almacenados se realizan todas las acciones relacionadas con la búsqueda, actualización, relaciones y eliminaciones de todos los casos de uso desarrollados para el proyecto.

- **Sistema gestor de bases de datos Workbench**: Utilizamos Workbench como sistema gestor de bases de datos para manejar y administrar nuestras bases de datos MySQL.

## Principios SOLID

- **Principio de Abierto/Cerrado**: Este principio se cumple mediante el uso de vistas dinámicas y clases abstractas de `Funcionalidad` y sus derivadas. Esto permite extender el comportamiento del sistema sin modificar el código existente.

- **Principio de Segregación de Interfaces**: Cada caso de uso creado tiene su propia interfaz o clase abstracta, asegurando que las clases dependan solo de las interfaces que realmente utilizan.

- **Principio de Responsabilidad Única y Principio de Inversión de Dependencias**: La mayoría de las clases creadas poseen una única responsabilidad. Cuando se requiere realizar alguna otra acción que dependa de otra clase, se utiliza una clase abstracta que hereda de una clase principal, asegurando en la gran mayoria de acciones  la inversión de dependencias.

## Arquitectura

Se ha utilizado la arquitectura hexagonal con vertical slicing y screaming, asegurando que cada entidad posea su propia infraestructura, aplicación y dominio.
