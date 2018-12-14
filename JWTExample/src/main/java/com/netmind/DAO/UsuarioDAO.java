package com.netmind.DAO;

import com.netmind.modelos.Usuario;
//En esta clase abstracta definimos los m�todos
public abstract class UsuarioDAO extends DAO {
	public abstract Usuario getUsuario(String username, String password) throws Exception;
	public abstract Usuario getUsuarioByMail(String email) throws Exception;
}
