$(document).ready(function() {
    // on ready
});


async function registrarUsuario() {
    let datos = {};
    datos.nombre = document.getElementById('textNombre').value;
    datos.apellido = document.getElementById('textApellido').value;
    datos.email = document.getElementById('textCorreo').value;
    datos.telefono = document.getElementById('textTelefono').value;
    datos.password = document.getElementById('textContraseña').value;

    let repetirPassword = document.getElementById('textRepetirContraseña').value;

    if (repetirPassword != datos.password) {
        alert('Las contraseñas no coinciden');
        return;
    }

    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("La cuenta fue creada con exito! Inicia sesión!");
    window.location.href = 'login.html'

}