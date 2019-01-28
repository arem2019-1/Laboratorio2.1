
var Calculos = (function () {
    function manDat() {
        num = document.getElementById("x").value;
        //alert(num);
        addCelda();
        axios.get('http://localhost:4567/hello/put/' + num ).then(function (response) {
            console.log('save succesfully');
        })
                .catch(function (error) {
                    console.log(error);
                });
    };

    function getMedia(){
            alert("Hola, pasamos");
            

            $(document).ready(function(){
             $("button").click(function(){
            $.get("http://localhost:4567/hello/get/media", function(data, status){
              alert("Data: " + data + "\nStatus: " + status);
            });
          });
});
       
    };        
        
    
    function getDv(){
        axios.get('http://localhost:4567/hello/ad/dv' ).then(function (response) {
            document.getElementById("dv").innerHTML = response.data;
            console.log('save succesfully');
        })
                .catch(function (error) {
                    console.log(error);
                });        
        
    };
    
    function addCelda() {
        var body = document.getElementsByTagName("body")[0];

        // Crea un elemento <table> y un elemento <tbody>
        var tabla = document.createElement("table");
        var tblBody = document.createElement("tbody");

        var hilera = document.createElement("tr");

        var celda = document.createElement("td");
        var textoCelda = document.createTextNode(num);

        celda.appendChild(textoCelda);
        hilera.appendChild(celda);
        tblBody.appendChild(hilera);
        tabla.appendChild(tblBody);
        // appends <table> into <body>
        body.appendChild(tabla);
        // modifica el atributo "border" de la tabla y lo fija a "2";
        tabla.setAttribute("border", "2");
    }

    function genera_tabla() {
        // Obtener la referencia del elemento body
        var body = document.getElementsByTagName("body")[0];

        // Crea un elemento <table> y un elemento <tbody>
        var tabla = document.createElement("table");
        var tblBody = document.createElement("tbody");

        var hilera = document.createElement("tr");
        var celda = document.createElement("td");
        var textoCelda = document.createTextNode("NUmeros Estadistica ");
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);
        tblBody.appendChild(hilera);
        tabla.appendChild(tblBody);
        // appends <table> into <body>
        body.appendChild(tabla);
        tabla.setAttribute("border", "2");
    }


    return {
        manDat: manDat,
        addCelda:addCelda,
        genera_tabla:genera_tabla,
        getMedia:getMedia,
        getDv:getDv
    };
})();


