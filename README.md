# JavaTasksUltimate

JavaTasksUltimate es una pequeña aplicación de consola tipo lista de tareas (To-Do).  
Permite crear tareas, listarlas, marcarlas como completadas y eliminarlas.  
Todas las tareas se guardan en un archivo de texto simple, así que se mantienen entre ejecuciones.

---

## Funcionalidades

- Agregar nuevas tareas con una descripción corta.
- Listar todas las tareas con índice y estado.
- Marcar una tarea como completada.
- Eliminar una tarea por su índice.
- Persistencia en `storage/tasks.txt` usando un formato de texto muy sencillo.

---

## Tecnologías

- Java (probado con Java 17, debería funcionar desde 11+).
- Proyecto desarrollado principalmente en IntelliJ IDEA, pero se puede ejecutar desde cualquier IDE o terminal.

---

## Arquitectura de 3 capas

El código sigue una estructura básica de 3 capas:

1. **Capa de Presentación**  
   Maneja la interacción con el usuario por consola:
    - Muestra el menú principal.
    - Lee las opciones ingresadas.
    - Lanza comandos para ejecutar acciones.

2. **Capa de Lógica / Servicio**  
   Contiene las reglas para trabajar con las tareas:
    - Crear nuevas tareas.
    - Listar, completar y eliminar tareas.
    - Se comunica con la capa de datos mediante interfaces.

3. **Capa de Acceso a Datos**  
   Encapsula todo el acceso al archivo de texto:
    - Carga la lista de tareas.
    - Guarda el estado actual de las tareas.
    - Oculta los detalles de archivos al resto de la aplicación.

---

## Patrones de diseño

- **Factory Method**  
  Implementado en `Task.create(String title)`.  
  Ese método estático es el único punto para crear tareas nuevas y validar el título.

- **DAO (Data Access Object)**
    - `TaskDAO` define las operaciones para cargar y guardar tareas.
    - `FileTaskDAO` implementa `TaskDAO` usando el archivo `storage/tasks.txt`.  
      El resto de la app depende solo de la interfaz, no de la forma concreta de almacenamiento.

- **Command**
    - `Command` es una interfaz pequeña con el método `execute()`.
    - `AddTaskCommand`, `ListTasksCommand`, `CompleteTaskCommand`, `DeleteTaskCommand`  
      representan cada opción del menú.  
      `ConsoleUI` solo dispara comandos sin saber cómo se realiza cada operación por dentro.

---

## Estructura del proyecto

```text
JavaTasksUltimate/
├─ storage/
│  └─ tasks.txt        # Archivo de texto donde se guardan las tareas (se crea si no existe)
└─ src/
   └─ main/
      └─ java/
         └─ com/javatasksultimate/
            ├─ access_data/
            │  ├─ TaskDAO.java
            │  ├─ TaskFileStorage.java
            │  └─ FileTaskDAO.java
            ├─ logic_service/
            │  ├─ Task.java
            │  ├─ TaskService.java
            │  └─ TaskServiceImpl.java
            └─ presentation/
               ├─ ConsoleUI.java
               ├─ Main.java
               └─ commands/
                  ├─ Command.java
                  ├─ AddTaskCommand.java
                  ├─ ListTasksCommand.java
                  ├─ CompleteTaskCommand.java
                  └─ DeleteTaskCommand.java
```
## Cómo ejecutar

Desde un IDE (IntelliJ, Eclipse, etc.):

1. Importar el proyecto como proyecto Java.
2. Asegurarse de que src esté marcado como Sources Root.
3. Ejecutar la clase com.javatasksultimate.presentation.Main.

Desde terminal (ejemplo usando javac y java):
```
# Desde la raíz del proyecto
javac -d out $(find src -name "*.java")
java -cp out com.javatasksultimate.presentation.Main
```

La aplicación creará automáticamente el archivo storage/tasks.txt si no existe.

***
## Uso (consola)

Menú principal:
1. Agregar tarea – se escribe la descripción y se almacena.
2. Listar tareas – muestra todas las tareas con índice y estado [ ] o [X].
3. Completar tarea – se ingresa el índice de la tarea a marcar como completada.
4. Eliminar tarea – se ingresa el índice de la tarea a borrar.
5. Salir – termina el programa.

***

## Posibles mejoras
Algunas ideas para versiones futuras:
- Editar una tarea existente.
- Filtrar solo tareas completadas o pendientes.
- Cambiar el archivo de texto por JSON o una base de datos real.
- Agregar pruebas automáticas para las capas de servicio y DAO.

***
Este software es de libre uso y está permitido para prácticas simples o métodos de enseñanza.