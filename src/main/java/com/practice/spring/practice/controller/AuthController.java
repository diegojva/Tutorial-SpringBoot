package com.practice.spring.practice.controller;

import com.practice.spring.practice.dao.UsuarioDAO;
import com.practice.spring.practice.model.Usuario;
import com.practice.spring.practice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String iniciarSesion(@RequestBody Usuario usuario){

        Usuario usuarioLogueado = usuarioDAO.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLogueado!=null){

            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogueado.getId()),usuarioLogueado.getEmail());

            return tokenJWT;
        }
        return "FAIL";
    }

}
