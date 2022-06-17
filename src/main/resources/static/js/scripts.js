
$(document).ready(function () {   
    listar();
     listar1();

});

function listar() {
     
    $.ajax({
        url: "/act/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idproducto + "</td><td>" + x[i].marca
                        + "</td><td>" + x[i].color + "</td><td>" + x[i].talla + "</td><td><a href='#' onclick='editar("
                        + x[i].idproducto + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idproducto + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}

function editar(id) {
    $.ajax({
        url: "/act/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_titulo").val(w.marca);
            $("#editar_descripcion").val(w.color);
            $("#editar_correo").val(w.talla);
            $("#idpost").val(w.idproducto);
        }
    });
    $("#modalEditar").modal('show');
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
                    url: "/act/" + id,
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

$("#guardar").click(function () {
    var nom = $("#nombre").val();
    var ape= $("#apellido").val();
    var correo= $("#correo").val();
    $.ajax({
        url: "/act/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'marca': nom, 'color': ape, 'talla': correo}),
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
    $("#modalGuardar").modal('hide');
});

$("#modificar").click(function () {
    var titulo = $("#editar_titulo").val();
    var desc = $("#editar_descripcion").val();
    var correo = $("#editar_correo").val();
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
                    url: "/act/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idproducto': id, 'marca': titulo, 'color': desc, 'talla': correo}),
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
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});



