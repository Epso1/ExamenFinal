Documentación de la Aplicación ExamenFinal

Descripción
ExamenFinal es una aplicación Android que permite a los usuarios explorar una lista de movimientos y elementos de Pokémon. Los usuarios pueden ver detalles específicos de cada movimiento y elemento, incluyendo su nombre, costo, categoría, efecto e imagen.

Características
Lista de movimientos de Pokémon.
Lista de elementos de Pokémon.
Detalles de cada movimiento y elemento.
Navegación a través de un menú desplegable.

Requisitos
Android Studio 4.0 o superior.
Java 8 o superior.
Gradle 4.0.1 o superior.

Instalación
Clona el repositorio de GitHub en tu máquina local.
Abre Android Studio.
Selecciona File > Open y navega hasta el directorio del proyecto clonado.
Haz clic en OK para abrir el proyecto en Android Studio.
Una vez que el proyecto se haya cargado, selecciona Run > Run 'app' para iniciar la aplicación en tu dispositivo o emulador.

Uso
Al iniciar la aplicación, se muestra un menú desplegable con las opciones "Listado de movimientos", "Listado de items" y "Item aleatorio". Al seleccionar "Listado de movimientos", se muestra la MainActivity con una lista de movimientos de Pokémon. Al seleccionar "Listado de items", se abre la ItemActivity con una lista de elementos de Pokémon. Al seleccionar "Item aleatorio", se abre la ItemDetailsActivity con los detalles de un elemento aleatorio.

Estructura del Proyecto
El proyecto sigue la estructura estándar de un proyecto Android:
src/main/java: Contiene el código fuente de la aplicación, incluyendo las actividades, modelos y repositorios.
src/main/res: Contiene los recursos de la aplicación, como los archivos de layout, imágenes y strings.
build.gradle: Contiene la configuración de compilación de la aplicación.

Código Importante
MainActivity.java: Esta es la actividad principal de la aplicación. Maneja la navegación del menú desplegable y la creación de las demás actividades.
ItemRepository.java: Este es el repositorio que maneja la carga de los elementos de Pokémon desde la API.
Pruebas
Actualmente, el proyecto no incluye pruebas automatizadas.

Contribución
Las contribuciones son bienvenidas. Por favor, abre un issue para discutir la contribución antes de hacer un pull request.

Licencia
El proyecto está licenciado bajo la licencia MIT.