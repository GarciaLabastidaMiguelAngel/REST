
##		   GET


###*****************************************
###		entidades
###*****************************************

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/entidades

{"data":[{"idEntidad":0,"descEntidad":"Nacional"}]}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/entidades

<list>
  <entidad>
    <idEntidad>0</idEntidad>
    <descEntidad>Nacional</descEntidad>
  </entidad>
</list>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/entidades/0

{"idEntidad":0,"descEntidad":"Nacional"}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/entidades/0

<entidad>
  <idEntidad>0</idEntidad>
  <descEntidad>Nacional</descEntidad>
</entidad>
###******************************************
###		municipios
###******************************************
curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/municipios

{"data":[{"idMunicipio":0,"descMunicipio":"Nacional","idEntidad":0}]}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/municipios

<list>
  <municipio>
    <idMunicipio>0</idMunicipio>
    <descMunicipio>Nacional</descMunicipio>
    <idEntidad>0</idEntidad>
  </municipio>
</list>

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/municipios/0

<municipio>
  <idMunicipio>0</idMunicipio>
  <descMunicipio>Nacional</descMunicipio>
  <idEntidad>0</idEntidad>
</municipio>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/municipios/0

{"idMunicipio":0,"descMunicipio":"Nacional","idEntidad":0}

###******************************************
###		temas nivel 1,2,3
###******************************************

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel1

<list>
  <Temas-Nivel-1>
    <idTemasNivel1>0</idTemasNivel1>
    <descripcion>Sociedad y Gobierno</descripcion>
  </Temas-Nivel-1>
</list>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel1

{"data":[{"idTemasNivel1":0,"descripcion":"Sociedad y Gobierno"}]}

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel1/0

{"idTemasNivel1":0,"descripcion":"Sociedad y Gobierno"}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel1/0

<Tema-Nivel-1>
  <idTemasNivel1>0</idTemasNivel1>
  <descripcion>Sociedad y Gobierno</descripcion>
</Tema-Nivel-1>

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel2

<list>
  <tema-nivel-2>
    <idTemasNivel2>0</idTemasNivel2>
    <descripcion>Empleo y relaciones laborales</descripcion>
    <idTemasNivel1>0</idTemasNivel1>
  </tema-nivel-2>
</list>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel2

{"data":[{"idTemasNivel2":0,"descripcion":"Empleo y relaciones laborales","idTemasNivel1":0}]}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel2/0

<Tema-Nivel-2>
  <idTemasNivel2>0</idTemasNivel2>
  <descripcion>Empleo y relaciones laborales</descripcion>
  <idTemasNivel1>0</idTemasNivel1>
</Tema-Nivel-2>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel2/0

{"idTemasNivel2":0,"descripcion":"Empleo y relaciones laborales","idTemasNivel1":0}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel3

<list>
  <tema-nivel-3>
    <idTemasNivel3>0</idTemasNivel3>
    <descripcion>Caracteristicas del empleo de la poblacion</descripcion>
    <idTemasNivel2>0</idTemasNivel2>
  </tema-nivel-3>
</list>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel3

{"data":[{"idTemasNivel3":0,"descripcion":"Caracteristicas del empleo de la poblacion","idTemasNivel2":0}]}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel3/0

<Tema-Nivel-3>
  <idTemasNivel3>0</idTemasNivel3>
  <descripcion>Caracteristicas del empleo de la poblacion</descripcion>
  <idTemasNivel2>0</idTemasNivel2>
</Tema-Nivel-3>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel3/0

{"idTemasNivel3":0,"descripcion":"Caracteristicas del empleo de la poblacion","idTemasNivel2":0}

###******************************************
###		indicadores
###******************************************
curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/indicadores

{"data":[{"idIndicador":"1007000018","descripcion":"Poblacion de 14 y mas anios","id_temas_nivel_3":0},{"idIndicador":"1007000019","descripcion":"Poblacion economicamente activa","id_temas_nivel_3":0}]}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/indicadores

<list>
  <indicador>
    <idIndicador>1007000018</idIndicador>
    <descripcion>Poblacion de 14 y mas anios</descripcion>
    <id_temas_nivel_3>0</id_temas_nivel_3>
  </indicador>
  <indicador>
    <idIndicador>1007000019</idIndicador>
    <descripcion>Poblacion economicamente activa</descripcion>
    <id_temas_nivel_3>0</id_temas_nivel_3>
  </indicador>
</list>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/indicadores/1007000018

{"idIndicador":"1007000018","descripcion":"Poblacion de 14 y mas anios","id_temas_nivel_3":0}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/indicadores/1007000018

<indicador>
  <idIndicador>1007000018</idIndicador>
  <descripcion>Poblacion de 14 y mas anios</descripcion>
  <id_temas_nivel_3>0</id_temas_nivel_3>
</indicador>

###****************************************
###     registros de indicadores
###****************************************
####OjO:dado el id de un indicador,este regresa todos los registros
#### que hay de ese indicador especificando su año la cantidad y el municipio
#### del registro, entonces puede regresar registros del 
#### el mismo año e igual cantidad pero que pertenece a otro municipio

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/indicadoresmontos/1007000018/municipios

{"data":[{"anio":2010,"cantidad":83400615,"idMunicipio":0{"anio":2010,"cantidad":485417,"idMunicipio":1},{"anio":2011,"cantidad":501089,"idMunicipio":1}]}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/indicadoresmontos/1007000018/municipios

<list>
  <registro>
    <anio>2010</anio>
    <cantidad>83400615</cantidad>
    <idMunicipio>0</idMunicipio>
  </registro>
  <registro>
    <anio>2010</anio>
    <cantidad>485417</cantidad>
    <idMunicipio>1</idMunicipio>
  </registro>
  <registro>
    <anio>2011</anio>
    <cantidad>501089</cantidad>
    <idMunicipio>1</idMunicipio>
  </registro>
</list>

####ahora si especificamos solo un municipio solo nos dara
####informacion de el municipio indicado
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/indicadoresmontos/1007000018/municipios/1

<list>
  <registro>
    <anio>2010</anio>
    <cantidad>485417</cantidad>
  </registro>
  <registro>
    <anio>2011</anio>
    <cantidad>501089</cantidad>
  </registro>
</list>

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/indicadoresmontos/1007000018/municipios/1

{"data":[{"anio":2010,"cantidad":485417},{"anio":2011,"cantidad":501089}]}