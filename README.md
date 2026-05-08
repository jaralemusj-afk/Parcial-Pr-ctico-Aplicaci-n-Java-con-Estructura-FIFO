Nombre: Juan camilo jara lemus

Descripcion proyecto: El proyecto se basa en un sistema en Java que gestiona la lista de clientes de un banco utilizando una estructura de cola FIFO (First In, First Out), donde los que llegan primero son atendidos primero.
El programa funciona por consola y permite agregar clientes, atender al siguiente en la lista, verificar quién está próximo, mostrar toda la cola, conocer cuántos clientes están en espera, limpiar la cola y cerrar el sistema.
Cada cliente guarda información como nombre, identificación, tipo de transacción, hora de llegada y si tiene prioridad.
El sistema fue creado con dos clases principales:
Cliente: se encarga de almacenar y verificar la información de cada cliente.
MenuPrincipal: alberga el menú y todas las funciones relacionadas con la cola.
También incluye manejo de errores para evitar fallos cuando se ingresan datos incorrectos y guarda la información en un archivo para no perder la cola al cerrar el programa.

Captura de pantalla del menu

Uso de FIFO: En el proyecto, FIFO (First In, First Out) se utiliza para manejar la fila de clientes del banco. Esto significa que el primer cliente en llegar es el primero en ser atendido.
Cuando un cliente entra al sistema, se agrega al final de la cola. Luego, cuando el cajero atiende a un cliente, el sistema toma y elimina al que está al inicio de la fila.
Por ejemplo, si llegan camilo, mariana y daniel en ese orden, primero será atendido camilo, después mariana y finalmente daniel. De esta manera, el sistema respeta el orden de llegada de los clientes, tal como ocurre en una fila real de un banco.

Diagrama de UML: https://lucid.app/lucidchart/e5d50073-6f24-4974-a9b8-9a064f61e576/edit?viewport_loc=-644%2C618%2C1920%2C773%2C0_0&invitationId=inv_248b05c8-c6b5-4e66-80a3-91ca752422d2  "me quede sin flechitas :("

