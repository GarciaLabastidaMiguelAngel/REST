/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * crea un objeto tipo div con los atributos pasados como parametro
 * en un JSON
 */  

var dominio="localhost:8080";//dominio de solicitudes de la API

function create_div(atributos){
        var div=document.createElement("div");
        if(typeof atributos!== "undefined" && atributos!==null){
        for (var clave in atributos){
            var atributo=document.createAttribute(clave);
            atributo.value=atributos[clave];
            div.attributes.setNamedItem(atributo);
         }
        }
        return div;
    }
    
    
 /*
 * crea un objeto tipo canvas con los atributos pasados como parametro
 * en un JSON
 */    
function create_canvas(atributos){
        var div=document.createElement("canvas");
        if(typeof atributos!== "undefined" && atributos!==null){
        for (var clave in atributos){
            var atributo=document.createAttribute(clave);
            atributo.value=atributos[clave];
            div.attributes.setNamedItem(atributo);
         }
        }
        return div;
    }

/*
 * 
 * @param {type} atributos
 * @param {type} datos
 * @returns {create_select_entidades.select|Element}
 */

function create_select(atributos,defaultText){
        var select=document.createElement("select");
        if(typeof atributos!== "undefined" && atributos!==null){
        for (var clave in atributos){
            var atributo=document.createAttribute(clave);
            if(atributos[clave])
                atributo.value=atributos[clave];
            select.attributes.setNamedItem(atributo);
         }
        }
        if(defaultText){
            var option=document.createElement("option");
            option.value="-1";
            var text=document.createTextNode(defaultText);
            option.appendChild(text);
            select.appendChild(option);
        }
        return select;
    }

    /*
 * crea un objeto tipo boton con los atributos pasados como parametro
 * en un JSON y la etiqueta del label como segundo parametro
 */    
function create_button(atributos,texto){
        var button=document.createElement("button");
        if(typeof atributos!== "undefined" && atributos!==null){
        for (var clave in atributos){
            var atributo=document.createAttribute(clave);
            atributo.value=atributos[clave];
            button.attributes.setNamedItem(atributo);
         }
        }
        if(texto){
            button.appendChild(document.createTextNode(texto));
        }
        return button;
    }
    



function GUI(){

    /*
     *obtenemos una referencia al contenedor principal
     */
    var principal= document.getElementById("principal");

    /*
     * creamos un row para los select de entidades y municipios
     */
     var row=create_div({class:"row",id:"row-entidades-municipios"});
     var col1=create_div({class:"col-md-1"});
     var col2=create_div({class:"col-md-5",id:"cont-entidades"});
     var col3=create_div({class:"col-md-5",id:"cont-municipios"});
     var col4=create_div({class:"col-md-1"});
     row.appendChild(col1);
     row.appendChild(col2);
     row.appendChild(col3);
     row.appendChild(col4);
     var select_entidades=create_select({id:"entidades",class:"form-control"},"Selecciona una entidad");
     col2.appendChild(select_entidades);
     var select_municipio=create_select({id:"municipios",class:"form-control"},"Selecciona un Municipio");
     col3.appendChild(select_municipio);
     principal.appendChild(row);
     /*
      * creamos row para los  select de temas de nivel
      */
     principal.appendChild(document.createElement("br"));
     row=create_div({class:"row",id:"row-temas"});
     col1=create_div({class:"col-md-4",id:"cont-temas1"});
     col2=create_div({class:"col-md-4",id:"cont-temas2"});
     col3=create_div({class:"col-md-4",id:"cont-temas3"});
     row.appendChild(col1);
     row.appendChild(col2);
     row.appendChild(col3);
     var temas1=create_select({id:"temas1",class:"form-control"},"Selecciona un tema de nivel 1");
     var temas2=create_select({id:"temas2",class:"form-control"},"Selecciona un tema de nivel 2");
     var temas3=create_select({id:"temas3",class:"form-control"},"Selecciona un tema de nivel 3 ");
     col1.appendChild(temas1);
     col2.appendChild(temas2);
     col3.appendChild(temas3);
     principal.appendChild(row);
     
     /*
      * se crea row para el select de indicador
      */
     principal.appendChild(document.createElement("br"));
     row=create_div({class:"row",id:"row-indicador"});
     col1=create_div({class:"col-md-4"});
     col2=create_div({class:"col-md-4",id:"cont-indicadores"});
     col3=create_div({class:"col-md-4"});
     row.appendChild(col1);
     row.appendChild(col2);
     row.appendChild(col3);
     var indicadores=create_select({class:"form-control",id:"indicadores"},"Selecciona un indicador");
     col2.appendChild(indicadores);
     principal.appendChild(row);
     /*
      * creamos row para boton de grafica
      */
     principal.appendChild(document.createElement("br"));
      row=create_div({class:"row",id:"row-boton"});
      col1=create_div({class:"col-md-5"});
      col2=create_div({class:"col-md-2",id:"cont-btn"});
      col3=create_div({class:"col-md-5"});
      var boton=create_button({id:"boton-1",class:"btn btn-primary btn-lg"},"Mostrar Estadistica");
      principal.appendChild(row);
      row.appendChild(col1);
      row.appendChild(col2);
      row.appendChild(col3);
      col2.appendChild(boton);
      /*
       * creamos row para canvas
       */
      row=row=create_div({class:"row",id:"row-canvas"});
      col1=create_div({class:"col-md-2"});
      col2=create_div({class:"col-md-8",id:"cont-canvas"});
      col3=create_div({class:"col-md-2"});
      var canvas=create_canvas({id:"canvas", height:"200", width:"400"});
      row.appendChild(col1);
      row.appendChild(col2);
      row.appendChild(col3);
      col2.appendChild(canvas);
      principal.appendChild(row);
      
      
}



function loadData(){
    
    /*
      *  encargado de cargar las entidades 
      */

            $.ajax({
                type: "GET",
                url: "http://"+dominio+"/api/entidades",
                dataType: "json",
                success: function(json){
                            if(json.data){
                                 var entidades=document.getElementById("entidades");
                                    var option;
                                    var text;
                                    var entidad;
                                  for(var llave in json.data){
                                        entidad=json.data[llave];
                                        option=document.createElement("option");
                                        option.value=entidad.idEntidad;
                                        text=document.createTextNode(entidad.descEntidad);
                                        option.appendChild(text);
                                        entidades.appendChild(option);
                                  }  
                            }
                            else{
                                alert("Algo salio mal lo sentimos....");
                            }
                },
                error:function(code,ajaxOptions, thrownError){
                   alert("Algo salio mal lo sentimos.... :(");
                }
                });
      /*
      *  encargado de cargar los temas de nivel 1 
      */

            $.ajax({
                type: "GET",
                url: "http://"+dominio+"/api/temasnivel1",
                dataType: "json",
                success: function(json){
                            if(json.data){
                                 var temas=document.getElementById("temas1");
                                    var option;
                                    var text;
                                    var t;
                                  for(var llave in json.data){
                                        t=json.data[llave];
                                        option=document.createElement("option");
                                        option.value=t.idTemasNivel1;
                                        text=document.createTextNode(t.descripcion);
                                        option.appendChild(text);
                                        temas.appendChild(option);
                                  }  
                            }
                            else{
                                alert("Algo salio mal lo sentimos....");
                            }
                },
                error:function(code,ajaxOptions, thrownError){
                   alert("Algo salio mal lo sentimos.... :(");
                }
                });   
    
}



function asignarEventos(){
     
   /*
       * se añade evento al boton de mostrar grafica de estadisticas estadisticas
       */
      $("#boton-1").click(
            function(){
                if($("#entidades").val()==="-1"){
                    alert("Debes seleccionar una entidad y municipio...");
                    return;
                }
                if($("#municipios").val()==="-1"){
                    alert("Debes seleccionar un municipio...");
                    return;
                }
                
                 if($("#temas1").val()==="-1"){
                    alert("Debes seleccionar un tema de nivel 1,2 y 3...");
                    return;
                }
                
                if($("#temas2").val()==="-1"){
                    alert("Debes seleccionar un tema de nivel 2 y 3...");
                    return;
                }
                
                if($("#temas3").val()==="-1"){
                    alert("Debes seleccionar un tema de nivel 3...");
                    return;
                }
                if($("#indicadores").val()==="-1"){
                    alert("Debes seleccionar un indicador...");
                    return;
                }
                    
            $.ajax({
                type: "GET",
                url: "http://"+dominio+"/api/indicadoresmontos/"+$("#indicadores").val()+"/municipios/"+$("#municipios").val(),
                dataType: "json",
                success: function(json){
                    if(json.data){
                        var labelsext=new Array();
                        var dataext=new Array();
                        for(var i=0;i<json.data.length;++i){
                            labelsext[i]=json.data[i].anio;
                            dataext[i]=json.data[i].cantidad;
                        }
                        console.log(labelsext);
                        console.log(dataext);
                           var barChartData = {
                                            labels : labelsext,
                                            datasets : [
                                                    {
                                                            fillColor : "rgba(255,0,0,0.8)",
                                                            strokeColor : "rgba(255,255,255,0.8)",
                                                            highlightFill: "rgba(0,0,255,0.75)",
                                                            highlightStroke: "rgba(220,220,0,1)",
                                                            data :dataext
                                                        }
                                            ]

                            };
                            
                            var ctx = document.getElementById("canvas").getContext("2d");
                            window.myBar = new Chart(ctx).Bar(barChartData, {
                                    responsive : true
                            });
                    }
                    
                },
                error:function(){
                                    alert("no existen registros del indicador\nen el municipio especificado");
                    
                }
            });
               
                 
         }  
        );
/*
 * se aisgna evento a select entidades para cargar municipios segun la entidad
 */
      
    $("#entidades").change(function(){
        var values=$("#entidades").val();
        if(values!=="-1"){//si la opcion seleccionada es valida
             $.ajax({
                type: "GET",
                url: "http://"+dominio+"/api/entidades/"+values+"/municipios",
                dataType: "json",
                success: function(json){
                            if(json.data){
                                 var municipios=document.getElementById("municipios");
                                 if ( municipios.hasChildNodes() ){
                                    while ( municipios.childNodes.length >= 1 ) {
                                        municipios.removeChild( municipios.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var m;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Seleccione un Municipio");
                                     option.appendChild(text);
                                     municipios.appendChild(option);
                                     municipios[0].selected=true;
                                  for(var llave in json.data){
                                        m=json.data[llave];
                                        option=document.createElement("option");
                                        option.value=m.idMunicipio;
                                        text=document.createTextNode(m.descMunicipio);
                                        option.appendChild(text);
                                        municipios.appendChild(option);
                                  }  
                            }
                            else{
                                alert("Algo salio mal lo sentimos....");
                            }
                },
                error:function(code,ajaxOptions, thrownError){
                                    var municipios=document.getElementById("municipios");
                                    if ( municipios.hasChildNodes() ){
                                            while ( municipios.childNodes.length >= 1 ) {
                                                municipios.removeChild( municipios.firstChild );
                                                }
                                    }
                                    var option;
                                    var text;
                                    var m;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Seleccione un Municipio");
                                     option.appendChild(text);
                                     municipios.appendChild(option);
                                     municipios[0].selected=true;
                        }
                });   
        }
        else{
                                    var municipios=document.getElementById("municipios");
                                    if ( municipios.hasChildNodes() ){
                                        while ( municipios.childNodes.length >= 1 ) {
                                            municipios.removeChild( municipios.firstChild );
                                            }
                                    }
                                    var option;
                                    var text;
                                    var m;
                                    option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Seleccione un Municipio");
                                     option.appendChild(text);
                                     municipios.appendChild(option);
                                     municipios[0].selected=true;
        }
        
    });
    
   /*
    * se asigna evento a select temas1 para cargar temas2
    */ 
    
       $("#temas1").change(function(){
        var values=$("#temas1").val();
        if(values!=="-1"){//si la opcion seleccionada es valida
             $.ajax({
                type: "GET",
                url: "http://"+dominio+"/api/temasnivel1/"+values+"/temasnivel2",
                dataType: "json",
                success: function(json){
                            if(json.data){
                                 var temas=document.getElementById("temas2");
                                 if ( temas.hasChildNodes() ){
                                    while ( temas.childNodes.length >= 1 ) {
                                        temas.removeChild( temas.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var t;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un tema de nivel 2");
                                     option.appendChild(text);
                                     temas.appendChild(option);
                                     temas[0].selected=true;
                                  for(var llave in json.data){
                                        t=json.data[llave];
                                        option=document.createElement("option");
                                        option.value=t.idTemasNivel2;
                                        text=document.createTextNode(t.descripcion);
                                        option.appendChild(text);
                                        temas.appendChild(option);
                                  }  
                            }
                            else{
                                alert("Algo salio mal lo sentimos....");
                            }
                },
                error:function(code,ajaxOptions, thrownError){
                                    var temas=document.getElementById("temas2");
                                 if ( temas.hasChildNodes() ){
                                    while ( temas.childNodes.length >= 1 ) {
                                        temas.removeChild( temas.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var t;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un tema de nivel 2");
                                     option.appendChild(text);
                                     temas.appendChild(option);
                                     temas[0].selected=true;
                                      temas=document.getElementById("temas3");
                                    if ( temas.hasChildNodes() ){
                                    while ( temas.childNodes.length >= 1 ) {
                                        temas.removeChild( temas.firstChild );
                                        }
                                    }
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un tema de nivel 3");
                                     option.appendChild(text);
                                     temas.appendChild(option);
                                     temas[0].selected=true;
                                      var indicadores=document.getElementById("indicadores");
                                 if ( indicadores.hasChildNodes() ){
                                    while ( indicadores.childNodes.length >= 1 ) {
                                        indicadores.removeChild( indicadores.firstChild );
                                        }
                                    }
                  
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un indicador");
                                     option.appendChild(text);
                                     indicadores.appendChild(option);
                                     indicadores[0].selected=true;
                                                }
                                        });   
                                }
                                else{
                                           var temas=document.getElementById("temas2");
                                    if ( temas.hasChildNodes() ){
                                    while ( temas.childNodes.length >= 1 ) {
                                        temas.removeChild( temas.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var t;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un tema de nivel 2");
                                     option.appendChild(text);
                                     temas.appendChild(option);
                                     temas[0].selected=true;
                                     temas=document.getElementById("temas3");
                                    if ( temas.hasChildNodes() ){
                                    while ( temas.childNodes.length >= 1 ) {
                                        temas.removeChild( temas.firstChild );
                                        }
                                    }
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un tema de nivel 3");
                                     option.appendChild(text);
                                     temas.appendChild(option);
                                     temas[0].selected=true;
                                      var indicadores=document.getElementById("indicadores");
                                 if ( indicadores.hasChildNodes() ){
                                    while ( indicadores.childNodes.length >= 1 ) {
                                        indicadores.removeChild( indicadores.firstChild );
                                        }
                                    }
                  
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un indicador");
                                     option.appendChild(text);
                                     indicadores.appendChild(option);
                                     indicadores[0].selected=true;
                                    
                                                
        }
        
    });
    
    
        
   /*
    * se asigna evento a select temas2 para cargar temas3
    */ 
    
       $("#temas2").change(function(){
        var values=$("#temas2").val();
        if(values!=="-1"){//si la opcion seleccionada es valida
             $.ajax({
                type: "GET",
                url: "http://"+dominio+"/api/temasnivel2/"+values+"/temasnivel3",
                dataType: "json",
                success: function(json){
                            if(json.data){
                                 var temas=document.getElementById("temas3");
                                 if ( temas.hasChildNodes() ){
                                    while ( temas.childNodes.length >= 1 ) {
                                        temas.removeChild( temas.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var t;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un tema de nivel 3");
                                     option.appendChild(text);
                                     temas.appendChild(option);
                                     temas[0].selected=true;
                                  for(var llave in json.data){
                                        t=json.data[llave];
                                        option=document.createElement("option");
                                        option.value=t.idTemasNivel3;
                                        text=document.createTextNode(t.descripcion);
                                        option.appendChild(text);
                                        temas.appendChild(option);
                                  }  
                            }
                            else{
                                alert("Algo salio mal lo sentimos....");
                            }
                },
                error:function(code,ajaxOptions, thrownError){
                                    var temas=document.getElementById("temas3");
                                 if ( temas.hasChildNodes() ){
                                    while ( temas.childNodes.length >= 1 ) {
                                        temas.removeChild( temas.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var t;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un tema de nivel 3");
                                     option.appendChild(text);
                                     temas.appendChild(option);
                                     temas[0].selected=true;
                                      var indicadores=document.getElementById("indicadores");
                                 if ( indicadores.hasChildNodes() ){
                                    while ( indicadores.childNodes.length >= 1 ) {
                                        indicadores.removeChild( indicadores.firstChild );
                                        }
                                    }
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un indicador");
                                     option.appendChild(text);
                                     indicadores.appendChild(option);
                                     indicadores[0].selected=true;
                                                
                                                }
                                        });   
                                }
                                else{
                                    var temas=document.getElementById("temas3");
                                    if ( temas.hasChildNodes() ){
                                    while ( temas.childNodes.length >= 1 ) {
                                        temas.removeChild( temas.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var t;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un tema de nivel 3");
                                     option.appendChild(text);
                                     temas.appendChild(option);
                                     temas[0].selected=true;
                                     var indicadores=document.getElementById("indicadores");
                                 if ( indicadores.hasChildNodes() ){
                                    while ( indicadores.childNodes.length >= 1 ) {
                                        indicadores.removeChild( indicadores.firstChild );
                                        }
                                    }
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un indicador");
                                     option.appendChild(text);
                                     indicadores.appendChild(option);
                                     indicadores[0].selected=true;
                                                
                            }
        
    }); 
    
    
    /*
    * se asigna evento a select temas3 para cargar indicadores
    */ 
    
       $("#temas3").change(function(){
        var values=$("#temas3").val();
        if(values!=="-1"){//si la opcion seleccionada es valida
             $.ajax({
                type: "GET",
                url: "http://"+dominio+"/api/temasnivel3/"+values+"/indicadores",
                dataType: "json",
                success: function(json){
                            if(json.data){
                                 var indicadores=document.getElementById("indicadores");
                                 if ( indicadores.hasChildNodes() ){
                                    while ( indicadores.childNodes.length >= 1 ) {
                                        indicadores.removeChild( indicadores.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var t;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un indicador");
                                     option.appendChild(text);
                                     indicadores.appendChild(option);
                                     indicadores[0].selected=true;
                                  for(var llave in json.data){
                                        t=json.data[llave];
                                        option=document.createElement("option");
                                        option.value=t.idIndicador;
                                        text=document.createTextNode(t.descripcion);
                                        option.appendChild(text);
                                        indicadores.appendChild(option);
                                  }  
                            }
                            else{
                                alert("Algo salio mal lo sentimos....");
                            }
                },
                error:function(code,ajaxOptions, thrownError){
                                    var indicadores=document.getElementById("indicadores");
                                 if ( indicadores.hasChildNodes() ){
                                    while ( indicadores.childNodes.length >= 1 ) {
                                        indicadores.removeChild( indicadores.firstChild );
                                        }
                                    }
                                    var option;
                                    var text;
                                    var t;
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un indicador");
                                     option.appendChild(text);
                                     indicadores.appendChild(option);
                                     indicadores[0].selected=true;
                                     
                                                }
                                        });   
                                }
                                else{
                                     var indicadores=document.getElementById("indicadores");
                                 if ( indicadores.hasChildNodes() ){
                                    while ( indicadores.childNodes.length >= 1 ) {
                                        indicadores.removeChild( indicadores.firstChild );
                                        }
                                    }
                                     option=document.createElement("option");
                                     option.value="-1";
                                     text=document.createTextNode("Selecciona un indicador");
                                     option.appendChild(text);
                                     indicadores.appendChild(option);
                                     indicadores[0].selected=true;
                                     
                            }
        
        
    });
}


$(document).ready(function(){
GUI();
loadData();
asignarEventos();

});




