
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

&ltlist&gt
  &ltentidad&gt
    &ltidEntidad&gt0&lt/idEntidad&gt
    &ltdescEntidad&gtNacional&lt/descEntidad&gt
  &lt/entidad&gt
&lt/list&gt

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/entidades/0

{"idEntidad":0,"descEntidad":"Nacional"}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/entidades/0

&ltentidad&gt
  &ltidEntidad&gt0&lt/idEntidad&gt
  &ltdescEntidad&gtNacional&lt/descEntidad&gt
&lt/entidad&gt
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

&ltlist&gt
  &ltmunicipio&gt
    &ltidMunicipio&gt0&lt/idMunicipio&gt
    &ltdescMunicipio&gtNacional&lt/descMunicipio&gt
    &ltidEntidad&gt0&lt/idEntidad&gt
  &lt/municipio&gt
&lt/list&gt

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/municipios/0

&ltmunicipio&gt
  &ltidMunicipio&gt0&lt/idMunicipio&gt
  &ltdescMunicipio&gtNacional&lt/descMunicipio&gt
  &ltidEntidad&gt0&lt/idEntidad&gt
&lt/municipio&gt

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

&ltlist&gt
  &ltTemas-Nivel-1&gt
    &ltidTemasNivel1&gt0&lt/idTemasNivel1&gt
    &ltdescripcion&gtSociedad y Gobierno&lt/descripcion&gt
  &lt/Temas-Nivel-1&gt
&lt/list&gt

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

&ltTema-Nivel-1&gt
  &ltidTemasNivel1&gt0&lt/idTemasNivel1&gt
  &ltdescripcion&gtSociedad y Gobierno&lt/descripcion&gt
&lt/Tema-Nivel-1&gt

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel2

&ltlist&gt
  &lttema-nivel-2&gt
    &ltidTemasNivel2&gt0&lt/idTemasNivel2&gt
    &ltdescripcion&gtEmpleo y relaciones laborales&lt/descripcion&gt
    &ltidTemasNivel1&gt0&lt/idTemasNivel1&gt
  &lt/tema-nivel-2&gt
&lt/list&gt

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel2

{"data":[{"idTemasNivel2":0,"descripcion":"Empleo y relaciones laborales","idTemasNivel1":0}]}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel2/0

&ltTema-Nivel-2&gt
  &ltidTemasNivel2&gt0&lt/idTemasNivel2&gt
  &ltdescripcion&gtEmpleo y relaciones laborales&lt/descripcion&gt
  &ltidTemasNivel1&gt0&lt/idTemasNivel1&gt
&lt/Tema-Nivel-2&gt

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel2/0

{"idTemasNivel2":0,"descripcion":"Empleo y relaciones laborales","idTemasNivel1":0}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel3

&ltlist&gt
  &lttema-nivel-3&gt
    &ltidTemasNivel3&gt0&lt/idTemasNivel3&gt
    &ltdescripcion&gtCaracteristicas del empleo de la poblacion&lt/descripcion&gt
    &ltidTemasNivel2&gt0&lt/idTemasNivel2&gt
  &lt/tema-nivel-3&gt
&lt/list&gt

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasnivel3

{"data":[{"idTemasNivel3":0,"descripcion":"Caracteristicas del empleo de la poblacion","idTemasNivel2":0}]}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasnivel3/0

&ltTema-Nivel-3&gt
  &ltidTemasNivel3&gt0&lt/idTemasNivel3&gt
  &ltdescripcion&gtCaracteristicas del empleo de la poblacion&lt/descripcion&gt
  &ltidTemasNivel2&gt0&lt/idTemasNivel2&gt
&lt/Tema-Nivel-3&gt

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

&ltlist&gt
  &ltindicador&gt
    &ltidIndicador&gt1007000018&lt/idIndicador&gt
    &ltdescripcion&gtPoblacion de 14 y mas anios&lt/descripcion&gt
    &ltid_temas_nivel_3&gt0&lt/id_temas_nivel_3&gt
  &lt/indicador&gt
  &ltindicador&gt
    &ltidIndicador&gt1007000019&lt/idIndicador&gt
    &ltdescripcion&gtPoblacion economicamente activa&lt/descripcion&gt
    &ltid_temas_nivel_3&gt0&lt/id_temas_nivel_3&gt
  &lt/indicador&gt
&lt/list&gt

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/indicadores/1007000018

{"idIndicador":"1007000018","descripcion":"Poblacion de 14 y mas anios","id_temas_nivel_3":0}

curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/indicadores/1007000018

&ltindicador&gt
  &ltidIndicador&gt1007000018&lt/idIndicador&gt
  &ltdescripcion&gtPoblacion de 14 y mas anios&lt/descripcion&gt
  &ltid_temas_nivel_3&gt0&lt/id_temas_nivel_3&gt
&lt/indicador&gt

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

&ltlist&gt
  &ltregistro&gt
    &ltanio&gt2010&lt/anio&gt
    &ltcantidad&gt83400615&lt/cantidad&gt
    &ltidMunicipio&gt0&lt/idMunicipio&gt
  &lt/registro&gt
  &ltregistro&gt
    &ltanio&gt2010&lt/anio&gt
    &ltcantidad&gt485417&lt/cantidad&gt
    &ltidMunicipio&gt1&lt/idMunicipio&gt
  &lt/registro&gt
  &ltregistro&gt
    &ltanio&gt2011&lt/anio&gt
    &ltcantidad&gt501089&lt/cantidad&gt
    &ltidMunicipio&gt1&lt/idMunicipio&gt
  &lt/registro&gt
&lt/list&gt

####ahora si especificamos solo un municipio solo nos dara
####informacion de el municipio indicado
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/indicadoresmontos/1007000018/municipios/1

&ltlist&gt
  &ltregistro&gt
    &ltanio&gt2010&lt/anio&gt
    &ltcantidad&gt485417&lt/cantidad&gt
  &lt/registro&gt
  &ltregistro&gt
    &ltanio&gt2011&lt/anio&gt
    &ltcantidad&gt501089&lt/cantidad&gt
  &lt/registro&gt
&lt/list&gt

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/indicadoresmontos/1007000018/municipios/1

{"data":[{"anio":2010,"cantidad":485417},{"anio":2011,"cantidad":501089}]}
