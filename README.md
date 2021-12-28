# Operación Fuego de Quasar
Han Solo ha sido recientemente nombrado General de l a Alianza Rebelde y busca
dar un gran golpe contra el Imperio Galáctico para reavivar la llama de la
resistencia.

El servicio de inteligencia rebelde ha detectado un llamado de auxilio de una nave
portacarga imperial a la deriva en un campo de asteroides. El manifiesto de la nave
es ultra clasificado, pero se rumorea que transporta raciones y armamento para una
legión entera.

# Instalación:
       git clone https://github.com/jssnoriega1282/fuegoquasar.git

## Descripción
**Este proyecto fue creado con las siguientes tecnologías:**
- **Java 11**
- **Maven**
- **Srping Boot(ApiRest)**
- **Swagger**
- **App Engine (Google Cloud)**

Este proyecto contiene los servicios necesarios para llevar a cabo la operación quasar.  Los servicios son RestFull y se puede encontar la documentación en la ApiRest implemetada con Swagger:
- **URL Documentación Swagger:** https://testcarga-3146c.uc.r.appspot.com/swagger-ui.html#
- **URL Base de los servicios**: https://testcarga-3146c.uc.r.appspot.com/api

### Servicios Disponibles:
- **topsecret(Post)**: Se encarga de obtener la posición de la nave imperial trinagulando las coordenadas y la distacia de los satelites rebeldes. A continuación un json de ejemplo de consumo del servicio:
URL: https://testcarga-3146c.uc.r.appspot.com/api/topsecret
````json
{
    "satellites":[
        {
            "name": "kenobi",
            "distance": 100.0,
            "message": ["este","","","mensaje",""]
        },
        {
            "name": "skywalker",
            "distance": 115.5,
            "message": ["","es","","","secreto"]
        },
        {
            "name": "sato",
            "distance": 142.7,
            "message": ["este","","un","",""]
        }         
    ]
}
````
La respuesta del servicio es código **200** si es exitosa la triangulación de la nave imperial o código **404** en caso de no poder obtener dicha posición. A continuación el JSON de respuesta:
```json
{
    "position": {
        "x": 53.02806374563455,
        "y": -33.10069590083003
    },
    "message": "este es un mensaje secreto "
}
```
- **topsecret_split(Post)**: Obtiene la posción de un satelite pasando como filtro la distancia con la nave imperial y el mensaje interceptado. A continuación el JSON de ejemplo para hacer la solicitud:
URL: https://testcarga-3146c.uc.r.appspot.com/api/topsecret_split
```json
{    
    "distance": 100.0,
    "message": ["este","","","mensaje",""]
}
```
La respuesta si los datos de busqueda son correctos es la posición del satelite tal y como se muestra en el JSON:
```json
{
    "position": {
        "x": -500.0,
        "y": -200.0
    },
    "message": ""
}
```
Si no hay coincidencia con los datos de búsqueda se retorna código **404** y se muestra la siguiente respuesta:
```json
No hay suficiente información
```

- **topsecret_split/{satellite_name}(Get)**: Obtiene la posición de un satelite rebelde de acuerdo al nombre ingresado en la variable "***satellite_name***". Si el nombre del satelite consultado existe en el servicio entonces se retorna código **200** con el siguiente JSON:
URL: https://testcarga-3146c.uc.r.appspot.com/api/topsecret_split/sato
```json
{
    "position": {
        "x": 500.0,
        "y": 100.0
    },
    "message": ""
}
```
Si el nombre ingresado no existe en el servicio entonces se retorna código **404** con la siguiente respuesta:
```json
No hay suficiente información
```

**¡Espero sea de tu agrado esta API REST para juego de Quasar!**

