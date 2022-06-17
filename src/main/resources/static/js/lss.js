 
   


function listar1() {
    
    $.ajax({
        url: "/ac/all",
        type: 'GET',
        success: function (x) {
            $("#tablita1 tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita1").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idventa + "</td><td>" + x[i].fecha
                        + "</td><td>" + x[i].idusuario + "</td><td>" + x[i].idcliente + "</td><td>" + x[i].idsucursal + "</td><td>" + x[i].tipocomprobante + "</td><td>" + x[i].seriecomprobante+ "</td><td>" + x[i].numerocomprobante+ "</td><td><a href='#' onclick='editar1("
                        + x[i].idventa + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar1(" + x[i].idventa + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}

function editar1(id) {
    $.ajax({
        url: "/ac/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_titulo").val(w.fecha);
            $("#editar_descripcion").val(w.idusuario);
            $("#editar_correo").val(w.idcliente);
            $("#editar_sucursal").val(w.idsucursal);
            $("#editar_tipo").val(w.tipocomprobante);
            $("#editar_serie").val(w.seriecomprobante);
            $("#editar_numero").val(w.numerocomprobante);
            $("#idpost").val(w.idventa);
        }
    });
    $("#modalEditar1").modal('show');
}

function eliminar1(id) {

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
                    url: "/ac/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar1();
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

$("#guardar1").click(function () {
    var nom = $("#nombre").val();
    var ape= $("#apellido").val();
    var correo= $("#correo").val();
    var sucur= $("#sucursal").val();
    var tipo= $("#tipo").val();
    var serie= $("#serie").val();
    var numero= $("#numero").val();
    $.ajax({
        url: "/ac/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'fecha': nom, 'idusuario': ape, 'idcliente': correo,'idsucursal': sucur,'tipocomprobante': tipo,'seriecomprobante': serie,'numerocomprobante': numero}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            listar1();
        }
    });
    $("#modalGuardar1").modal('hide');
});

$("#modificar1").click(function () {
    var titulo = $("#editar_titulo").val();
    var desc = $("#editar_descripcion").val();
    var correo = $("#editar_correo").val();
    var sucur = $("#editar_sucursal").val();
    var tipo= $("#editar_tipo").val();
    var serie= $("#editar_serie").val();
    var numero= $("#editar_numero").val();
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
                    url: "/ac/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idventa': id, 'fecha': titulo, 'idsuario': desc, 'idcliente': correo,'idsucursal': sucur,'tipocomprobante': tipo,'seriecomprobante': serie,'numerocomprobante': numero}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar1();
                    }
                });
                $("#modalEditar1").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});

