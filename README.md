
#URL disponibles al momento#
##GET##
###/api/entidades###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/entidades

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/entidades
###/api/entidades/{id}###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/entidades/{id}

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/entidades/{id}
###/api/municipios###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/municipios

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/municipios
###/api/municipios/{id}###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/municipios/{id}

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/municipios/{id}
###/api/entidades/{id}/municipios###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/entidades/{id}/municipios

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/entidades/{id}/municipios
###/api/temasnivel1###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasNivel1

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasNivel1
###/api/temasnivel1/{id}###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasNivel1/{id}

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasNivel1/{id}
###/api/temasnivel2###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasNivel2

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasNivel2
###/api/temasnivel2/{id}###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasNivel2/{id}

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasNivel2/{id}
###/api/temasnivel3###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasNivel3

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasNivel3
###/api/temasnivel3/{id}###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasNivel3/{id}

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasNivel3/{id}
###/api/temasnivel1/{id}/temasnivel2###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasNivel1/{id}/temasNivel2

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasNivel1/{id}/temasNivel2
###/api/temasnivel2/{id}/temasnivel3###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/temasNivel2/{id}/temasNivel3

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/temasNivel2/{id}/temasNivel3
###/api/indicadores###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/indicadores

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/indicadores
###/api/indicadores/{id}###
curl -X GET \
  -H "accept: application/xml" \
  http://localhost:8080/api/indicadores/{id}

curl -X GET \
  -H "accept: application/json" \
  http://localhost:8080/api/indicadores/{id}
##POST##
###/api/entidades###
curl -X POST \
-H "Content-Type: application/json" \
-H "accept: application/json" \
-d '{"descEntidad":"Oaxaca"}' \
http://localhost:8080/api/entidades

curl -X POST \
-H "Content-Type: application/xml" \
-H "accept: application/xml" \
-d "<entidad>
	<descEntidad>Mexico</descEntidad>
    </entidad>" \
####http://localhost:8080/api/entidades####
###/api/municipios###
curl -X POST \
-H "Content-Type: application/json" \
-H "accept: application/json" \
-d '{"descMuniciopio":"Oaxaca","idEntidad":"1"}' \
http://localhost:8080/api/municipios

curl -X POST \
-H "Content-Type: application/xml" \
-H "accept: application/xml" \
-d "<municipio>
	<descMuniciopio>Mexico</descMuniciopio>
	<idEntidad>2</idEntidad>
    </municipio>" \
http://localhost:8080/api/municipios
##PUT##
###pendiente###
##DELETE##
###pendiente###
