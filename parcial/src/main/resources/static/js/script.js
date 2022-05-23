$(document).ready(function () {
    listar();

});
function listar() {
    $.ajax({
        url: "/post/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idlibro+ "</td><td>" + x[i].titulo+ "</td><td>" + x[i].idioma+ "</td><td>" + x[i].paginas+ "</td><td>" + x[i].descripcion + "</td><td>" + x[i].idautor
                        + "</td><td>" + x[i].ideditorial + "</td><td><a href='#' onclick='editar("
                        + x[i].idlibro + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idlibro + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}
function editar(id) {
    $.ajax({
        url: "/post/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_titulo").val(w.titulo);
            $("#editar_idioma").val(w.idioma);
            $("#editar_paginas").val(w.paginas);
            $("#editar_descripcion").val(w.descripcion);
            $("#editar_idautor").val(w.idautor);
            $("#editar_ideditorial").val(w.ideditorial);
            $("#idpost").val(w.idlibro);
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
                    url: "/post/" + id,
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
    var titulo = $("#titulo").val();
    var idioma = $("#idioma").val();
    var paginas = $("#paginas").val();
    var descripcion = $("#descripcion").val();
    var idautor = $("#idautor").val();
    var ideditorial = $("#ideditorial").val();
    $.ajax({
        url: "/post/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'titulo': titulo, 'idioma': idioma, 'paginas': paginas, 'descripcion': descripcion, 'idautor': idautor, 'ideditorial': ideditorial}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            limpiar();
            listar();
        }
    });
    $("#modalGuardar").modal('hide');
});
function limpiar() {
    $("#titulo").val("");
    $("#idioma").val("");
    $("#paginas").val("");
    $("#descripcion").val("");
    $("#idautor").val("");
    $("#ideditorial").val("");
}
$("#modificar").click(function () {
    var titulo = $("#editar_titulo").val();
    var idioma = $("#editar_idioma").val();
    var paginas = $("#editar_paginas").val();
    var descripcion = $("#editar_descripcion").val();
    var idautor = $("#editar_idautor").val();
    var ideditorial = $("#editar_ideditorial").val();
    
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
                    url: "/post/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idlibro': id,'titulo': titulo, 'idioma': idioma, 'paginas': paginas, 'descripcion': descripcion, 'idautor': idautor, 'ideditorial': ideditorial}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        limpiar();
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