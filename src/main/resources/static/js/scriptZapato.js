$(document).ready(function () {   
      listar();
});

function listar() {

    $.ajax({
        url: "/act3/all",
        type: 'GET',
        success: function (x) {
            $("#tablita3 tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita3").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idzapato + "</td><td>" + x[i].marca
                        + "</td><td>" + x[i].talla + "</td><td>" + x[i].color + "</td><td>" + x[i].preciozapato + "</td><td>" + x[i].descripcion + "</td><td>" + x[i].stock + "</td><td>" + x[i].estado + "</td><td>" + x[i].idcategoria + "</td><td><a href='#' onclick='editar("
                        + x[i].idzapato + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idzapato + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
           
            }
        }
    });
}

function editar(id) {
    
    $.ajax({
        url: "/act3/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombre").val(w.marca);
            $("#editar_apellido").val(w.talla);
            $("#editar_dni").val(w.color);
            $("#editar_sexo").val(w.preciozapato);
            $("#editar_nacionalidad").val(w.descripcion);
            $("#editar_direccion").val(w.stock);
            $("#editar_correo").val(w.estado);
            $("#editar_telefono").val(w.idcategoria);
            $("#idpost").val(w.idzapato);
        }
    });
    $("#modalEditar4").modal('show');
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
                    url: "/act3/" + id,
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

$("#guardar4").click(function () {
    
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
        url: "/act3/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'marca': nombre , 'talla': apellido, 'color': dni,'preciozapato': sexo, 'descripcion': nacionalidad, 'stock': direccion, 'estado': correo, 'idcategoria': telefono}),
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
    $("#modalGuardar4").modal('hide');
});

$("#modificar4").click(function () {
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
                    url: "/act3/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idzapato': id,'marca': nombre , 'talla': apellido, 'color': dni,'preciozapato': sexo, 'descripcion': nacionalidad, 'stock': direccion, 'estado': correo, 'idcategoria': telefono}),
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
                $("#modalEditar4").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});




