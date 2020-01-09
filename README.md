# proj_bpi

## No Docker

### Server (springboot)

```mvn spring-boot:run```

### Client (angular - nodejs)

#### Running 

```ng server -open```

## Docker

In the Docker dir just run 

```docker-compose up```

This works with 2 images that had uploaded:

 - [spring-boot](https://hub.docker.com/repository/docker/fhofman/bpi-springboot)
 - [angular](https://hub.docker.com/repository/docker/fhofman/bpi-angular)

Temas que quedaron pendientes:
- Al levantar docker-compose debería predefinir los ip asi se pueden ver las maquinas. Que esten en la misma red y se linkeen. 
- No se han hecho pruebas de carga en el REST. 
- Tampoco hay tests

Dificultades que tuve: 
- No había trabajado con springboot anteriormente, eso me hizo bloquearme varias veces.

