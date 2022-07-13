window.addEventListener('load', function () {



   //Al cargar la página buscamos y obtenemos el formulario donde estarán

   //los datos que el usuario cargará de la nueva película

   const formulario = document.querySelector('#add_new_odontologo');



   //Ante un submit del formulario
   //se ejecutará la siguiente función

   formulario.addEventListener('submit', function (event) {

      //creamos un JSON que tendrá los datos
      //del nuevo odontologo
       const formDatos = {
           nombre: document.querySelector('#nombre').value,
           apellido: document.querySelector('#apellido').value,
           matricula: document.querySelector('#matricula').value,

       };

       //invocamos la API odontologos utilizando la función fetch de JavaScript
       //con el método POST que guardará
       //el odontologo que enviaremos en formato JSON

       const url = '/odontologos';

       const settings = {
           method: 'POST',
           headers: {
               'Content-Type': 'application/json',
           },
           body: JSON.stringify(formDatos)

       }

       fetch(url, settings)
           .then(response => response.json())
           .then(data => {

                //Si no hay ningún error,
                //se muestra un mensaje diciendo que la película
                //fue agregada
                console.log(data);
                let successAlert = '<p style = "color:green"> Odontólogo agregado </p>'


                                           document.querySelector('#response').innerHTML = successAlert;
                                           document.querySelector('#response').style.display = 'block';
                                           resetUploadForm();




           })

           .catch(error => {

                   //Si hay algún error,

                   //se muestra un mensaje diciendo que la película

                   //no se pudo guardar y se intente nuevamente

                   let errorAlert = '<p style = "color:red"> Error intente nuevamente </p>'



                     document.querySelector('#response').innerHTML = errorAlert;

                     document.querySelector('#response').style.display = 'block';
                     resetUploadForm();

                    //se dejan todos los campos vacíos

                    //por si se quiere ingresar otra película


           })



   });


function resetUploadForm(){

       document.querySelector('#nombre').value = "";

       document.querySelector('#apellido').value = "";

       document.querySelector('#matricula').value = "";



   }

    (function(){
            let pathname = window.location.pathname;
            if(pathname === "/"){
                document.querySelector(".nav .nav-item a:first").addClass("active");
            } else if (pathname == "/odontologoListar.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })();

})

