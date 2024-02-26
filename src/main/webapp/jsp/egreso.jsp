<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Egreso</title>
    <link rel="stylesheet" href="css/styleMovimientos.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>

</head>

<body>
    <!-- nav -->
    <header class="header_pagina_principal">
        <button class="boton boton2 usuario_shortcut">
            <img src="https://picsum.photos/30" alt="imagen de usuario">
            <p>Usuario</p>
        </button>
        <div>
            <a href="dashboard.html">
                <iconify-icon class="icono" icon="carbon:view-filled" width="18"></iconify-icon>
                <span>Dashboard</span>
            </a>
            <a href="configuracion.html">
                <iconify-icon class="icono" icon="carbon:view-filled" width="18"></iconify-icon>
                <span>ConfiguraciÃ³n</span>
            </a>
        </div>
    </header>
    <main class="main_pagina_principal">
        <div class="contenedor_default dash_head">
            <header class="header_contenedor">
                <h3>Banco</h3>
                <button class="boton boton2 color_inactivo_boton">
                    <iconify-icon class="icono" icon="carbon:view-filled" width="18"></iconify-icon>
                </button>
            </header>
            <main class="balance">
                <iconify-icon class="icono" icon="cryptocurrency:usd" style="color: white;" width="32"></iconify-icon>
                <h1>1000.00</h1>
            </main>
        </div>

        <div class="contenedor_form">
            <form action="index.html">
                <label for="egreso">Dinero a debitar</label>
                <input id="egreso" type="number" max="0">
                <label for="categoria">CategorÃ­a</label>
                <select name="tipo" id="tipo" class="select-categoria">
                    <option value="0">Seleccione una categoria</option>
                    <option value="1">Comida</option>
                    <option value="2">Transferencia</option>
                    <option value="3">NÃ³mina</option>
                    <option value="4">Universidad</option>
                  </select>
                <label for="fecha">Selecciona una fecha:</label>
                <input type="date" id="fecha" name="fecha">
                <label for="">Concepto</label>
                <input type="text" placeholder="Ingrese motivo de egreso"/>
                <div class="btn-confirmacion">
                    <input type="submit" class="boton boton1" value="Debitar">
                    <input type="submit" class="boton boton-cancelar" value="Cancelar">
                </div>
            </form>
        </div>
    </main>

</body>

</html>