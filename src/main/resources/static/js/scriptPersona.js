$(document).ready(function () {   
      listar();
});

function listar() {

    $.ajax({
        url: "/act2/all",
        type: 'GET',
        success: function (x) {
            $("#tablita2 tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita2").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idpersona + "</td><td>" + x[i].nombrepersona
                        + "</td><td>" + x[i].apellidopersona + "</td><td>" + x[i].dnipersona + "</td><td>" + x[i].sexo + "</td><td>" + x[i].nacionalidad + "</td><td>" + x[i].direccion + "</td><td>" + x[i].correo + "</td><td>" + x[i].telefonopersona + "</td><td><a href='#' onclick='editar("
                        + x[i].idpersona + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idpersona + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
           
            }
        }
    });
}

function editar(id) {
    
    $.ajax({
        url: "/act2/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombre").val(w.nombrepersona);
            $("#editar_apellido").val(w.apellidopersona);
            $("#editar_dni").val(w.dnipersona);
            $("#editar_sexo").val(w.sexo);
            $("#editar_nacionalidad").val(w.nacionalidad);
            $("#editar_direccion").val(w.direccion);
            $("#editar_correo").val(w.correo);
            $("#editar_telefono").val(w.telefonopersona);
            $("#idpost").val(w.idpersona);
        }
    });
    $("#modalEditar3").modal('show');
}

function eliminar(id) {

    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/act2/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}

$("#guardar3").click(function () {
    
    var nombre = $("#nombre").val();
  //  window.alert(nombre);
    var apellido= $("#apellido").val();
    var dni= $("#dni").val();
    var sexo = $("#sexo").val();
    var nacionalidad= $("#nacionalidad").val();
    var direccion= $("#direccion").val();
    var correo = $("#correo").val();
    var telefono= $("#telefono").val();
    
    $.ajax({
        url: "/act2/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombrepersona': nombre , 'apellidopersona': apellido, 'dnipersona': dni,'sexo': sexo, 'nacionalidad': nacionalidad, 'direccion': direccion, 'correo': correo, 'telefonopersona': telefono}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            listar();
        }
    });
    $("#modalGuardar3").modal('hide');
});

$("#modificar3").click(function () {
    var nombre = $("#editar_nombre").val();
  //  window.alert(nombre);
    var apellido= $("#editar_apellido").val();
    var dni= $("#editar_dni").val();
    var sexo = $("#editar_sexo").val();
    var nacionalidad= $("#editar_nacionalidad").val();
    var direccion= $("#editar_direccion").val();
    var correo = $("#editar_correo").val();
    var telefono= $("#editar_telefono").val();
    
    var id = $("#idpost").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/act2/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idpersona': id, 'nombrepersona': nombre , 'apellidopersona': apellido, 'dnipersona': dni,'sexo': sexo, 'nacionalidad': nacionalidad, 'direccion': direccion, 'correo': correo, 'telefonopersona': telefono}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
                $("#modalEditar3").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});




