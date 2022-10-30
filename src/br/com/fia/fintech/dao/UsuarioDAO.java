package br.com.fia.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.UsuarioModel;

public class UsuarioDAO extends ConexaoBanco {

	public UsuarioDAO(){
		getConexao();
	}
	
	public UsuarioModel findById (int codigo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		
		UsuarioModel usuarioSelecionado = new UsuarioModel();
		
		stbQuery.append("SELECT cd_usuario, nm_nome, ds_email, ds_senha, nm_apelido, nr_cpf FROM T_USUARIO WHERE CD_USUARIO = ?");
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(1, codigo);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {	
				usuarioSelecionado = new UsuarioModel();
				usuarioSelecionado.setCd_usuario(rs.getInt("cd_usuario"));
				usuarioSelecionado.setNm_nome(rs.getString("nm_nome"));
				usuarioSelecionado.setDs_email(rs.getString("ds_email"));
				usuarioSelecionado.setDs_senha(rs.getString("ds_senha"));
				usuarioSelecionado.setNm_apelido(rs.getString("nm_apelido"));
				usuarioSelecionado.setNr_cpf(rs.getString("nr_cpf"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResult(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}
		return usuarioSelecionado;
	}

	public List<UsuarioModel> findAll(){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		List<UsuarioModel> listaUsuarios = new ArrayList<>();

		stbQuery.append("SELECT cd_usuario, nm_nome, ds_email, ds_senha, nm_apelido, nr_cpf FROM T_USUARIO ORDER BY CD_USUARIO");

		try {

			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());

			rs = stmt.executeQuery();

			while (rs.next()) {

				UsuarioModel usuario = new UsuarioModel();
				usuario.setCd_usuario(rs.getInt("cd_usuario"));
				usuario.setNm_nome(rs.getString("nm_nome"));
				usuario.setDs_email(rs.getString("ds_email"));
				usuario.setDs_senha(rs.getString("ds_senha"));
				usuario.setNm_apelido(rs.getString("nm_apelido"));
				usuario.setNr_cpf(rs.getString("nr_cpf"));

				listaUsuarios.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}

		return listaUsuarios;
	}

	public void criarUsuario (UsuarioModel usuario) {		

		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append(" INSERT INTO T_USUARIO (CD_USUARIO, NM_NOME, DS_EMAIL, DS_SENHA, NM_APELIDO, NR_CPF) VALUES (SEQ_USUARIO.NEXTVAL,?, ?, ?,?,? )");
		
		
		int param = 1;

		try {
			
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setString(param ++, usuario.getNm_nome());
			stmt.setString(param ++, usuario.getDs_email());
			stmt.setString(param ++, usuario.getDs_senha());
			stmt.setString(param ++, usuario.getNm_apelido());
			stmt.setString(param ++, usuario.getNr_cpf());		
			
			stmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	
	}
	
	public void mudarSenha(UsuarioModel usuario) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append("UPDATE T_USUARIO SET DS_SENHA = ? WHERE CD_USUARIO = ?");
		
		int param = 1;
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setString(param++, usuario.getDs_senha());
			stmt.setInt(param++, usuario.getCd_usuario());
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	}
	
	public void alterarEmail(UsuarioModel usuario) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append("UPDATE T_USUARIO SET DS_EMAIL = ? WHERE CD_USUARIO = ?");
		
		int param = 1;
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setString(param++, usuario.getDs_email());
			stmt.setInt(param++, usuario.getCd_usuario());
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	}

	public void atualizarUsuario(UsuarioModel usuario){
	
		
		Connection conn = null;
		PreparedStatement stmt = null;

		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append(" UPDATE T_USUARIO SET nm_nome = ?, ds_email = ?, ds_senha = ?, nm_apelido = ?, nr_cpf = ? where cd_usuario = ?");
	
		int param = 1;
			try {
				
				conn = getConexao();
				stmt = conn.prepareStatement(stbQuery.toString());
				
				stmt.setString(param ++, usuario.getNm_nome());
				stmt.setString(param ++, usuario.getDs_email());
				stmt.setString(param ++, usuario.getDs_senha());
				stmt.setString(param ++, usuario.getNm_apelido());
				stmt.setString(param ++, usuario.getNr_cpf());
				stmt.setInt(param ++, usuario.getCd_usuario());
				
				stmt.executeQuery();
	
			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				closeStatement(stmt);
				closeConnection(conn);
			}
		
		}


	public void excluirUsuario (int codigo){
		
		Connection conn = null;
		PreparedStatement stmt = null;

		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append("DELETE FROM T_USUARIO WHERE CD_USUARIO = ? ");
		
		try {
			
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			stmt.setInt(1, codigo);
			
			stmt.executeUpdate();
			
			System.out.println("Excluiu o usuario!");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	
	}

}
