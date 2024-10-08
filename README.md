# SOAP Pokémon API Service

Este proyecto es un servicio SOAP desarrollado con **Spring Boot** y **Java 17** que consume la [API REST de PokeAPI](https://pokeapi.co/) y expone los datos de un Pokémon específico a través de un servicio web SOAP. El servicio permite obtener la siguiente información de un Pokémon:

- **abilities**: Habilidades del Pokémon.
- **base_experience**: Experiencia base del Pokémon.
- **held_items**: Objetos que el Pokémon puede sostener.
- **id**: Identificador único del Pokémon.
- **name**: Nombre del Pokémon.
- **location_area_encounters**: Información sobre dónde se puede encontrar al Pokémon.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

- **Java 17** o superior
- **Maven** para la gestión de dependencias
- **Spring Boot 3.x**

## Instalación

1. Clona este repositorio en tu máquina local:
    
    ```bash

    git clone https://github.com/tu-usuario/soap-pokemon-api.git
    cd soap-pokemon-api
    
    ```
    
2. Compila el proyecto utilizando **Maven**:
    
    ```bash
    mvn clean install
    
    ```
    
3. Ejecuta la aplicación de **Spring Boot**:
    
    ```bash
    mvn spring-boot:run
    
    ```
    
4. El servicio SOAP estará disponible en: `http://localhost:8080/ws/pokemon.wsdl`

## Uso del Servicio

### Consumiendo el Servicio SOAP

Puedes consumir el servicio SOAP utilizando herramientas como **Postman**, **SoapUI**, o cualquier otro cliente SOAP. A continuación se muestra un ejemplo de una solicitud SOAP que puedes enviar al servicio para obtener la información de un Pokémon.

### Solicitud SOAP (Ejemplo)

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pok="http://example.com/soap/pokemon">
   <soapenv:Header/>
   <soapenv:Body>
      <pok:PokemonRequest>
         <name>pikachu</name>
      </pok:PokemonRequest>
   </soapenv:Body>
</soapenv:Envelope>

```

### Respuesta SOAP (Ejemplo)

Si envías la solicitud anterior para el Pokémon `pikachu`, obtendrás una respuesta similar a la siguiente:

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <PokemonResponse xmlns="http://example.com/soap/pokemon">
         <name>pikachu</name>
         <id>25</id>
         <baseExperience>112</baseExperience>
         <abilities>
            <abilities>static</abilities>
            <abilities>lightning-rod</abilities>
         </abilities>
         <heldItems>
            <heldItems>oran-berry</heldItems>
         </heldItems>
         <locationAreaEncounters>https://pokeapi.co/api/v2/pokemon/25/encounters</locationAreaEncounters>
      </PokemonResponse>
   </soapenv:Body>
</soapenv:Envelope>

```
5. El servicio Swagger estará disponible en: `http://localhost:8080/swagger-ui/index.html`
6. Si el servicio Swagger no responde usar: `http://localhost:8080/swagger-ui.html`

![image](https://github.com/user-attachments/assets/1ada3732-4e0a-402f-9922-61a85731e66d)



## Estructura del Proyecto

- **PokeApiService**: Servicio que consume la API REST de PokeAPI.
- **PokemonEndpoint**: Endpoint SOAP que expone los métodos SOAP.
- **PokemonRequest** y **PokemonResponse**: Clases JAXB para el manejo de las solicitudes y respuestas SOAP.
- **WebServiceConfig**: Configuración del servidor SOAP y definición del WSDL.
- **pokemon.xsd**: Archivo XSD que define la estructura de la solicitud y respuesta SOAP.

## Descripción de los Métodos SOAP

El servicio SOAP expone los siguientes métodos para obtener información de un Pokémon:

1. **name**: Devuelve el nombre del Pokémon.
2. **id**: Devuelve el identificador único del Pokémon.
3. **base_experience**: Devuelve la experiencia base del Pokémon.
4. **abilities**: Lista las habilidades del Pokémon.
5. **held_items**: Lista los objetos que el Pokémon puede sostener.
6. **location_area_encounters**: Proporciona un enlace para obtener información sobre los lugares donde se puede encontrar al Pokémon.

## Especificación del WSDL

Puedes obtener el archivo WSDL del servicio en la siguiente URL:

```bash

http://localhost:8080/ws/pokemon.wsdl

```

## Configuración

Si necesitas cambiar la configuración del puerto o de otros aspectos del servicio, puedes hacerlo modificando el archivo `application.properties`.

Por defecto, el servicio corre en el puerto `8080`.

## Dependencias Principales

- **Spring Boot**: Framework principal utilizado para crear la aplicación.
- **Spring Web Services**: Proporciona soporte para construir servicios SOAP.
- **RestTemplate**: Utilizado para consumir la API REST de PokeAPI.
- **Doc Api**: Utilizado generar documentacion Swagger.


## Contacto

Si tienes alguna pregunta o sugerencia, puedes contactar a:

- **Autor**: Erik Ivan Angeles Resendiz
- **Correo**: ivantdp.it@gmail.com
