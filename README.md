# Directv Mobile Automation Framework.
![N|Solid](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-Ckfyk55DtL1a9EApX84jIzIduzXb2qYbtAlVUtUDWhvnbyYX)

### Prerrequisitos
Configurarión entorno de trabajo:
* `Instalar Java 8`.
* `Instalar maven version 3.6.2`.
* `Intellij`.


### Ejecución de Pruebas
Para ejecutar la automatización en Android considerar lo siguiente:

*Para pruebas sin paralelismo:*
* Ejecutar desde terminal el comando: `mvn clean verify -P device -DtestPlatform=android "-Dcucumber.options=--tags @Complete"`.

*Para pruebas con paralelismo:*
* Ejecutar desde terminal el comando: `mvn clean verify -P multiDevice -DtestPlatform=browserstack-android "-Dcucumber.options=--tags @Complete"`.

Para ejecutar la automatización en ios considerar lo siguiente:

*Para pruebas sin paralelismo:*
* Ejecutar desde terminal el comando: `mvn clean verify -P device -DtestPlatform=ios "-Dcucumber.options=--tags @Complete"`.

*Para pruebas con paralelismo:*
* Ejecutar desde terminal el comando: `mvn clean verify -P multiDevice -DtestPlatform=browserstack-ios "-Dcucumber.options=--tags @Complete"`.


### Reporte
Para visualizar el reporte navegar a la siguiente ruta y abrir el arrchivo con navegador.
* `target/site/serenity/index.html`.

### Consideraciones
En caso de querer ver visualización de ejecución en dispositivos móbiles:
* Contar con acceso a browserStack.
* Cambiar el valor de `User Name` y `Access Key` en archivos `.properties`.

