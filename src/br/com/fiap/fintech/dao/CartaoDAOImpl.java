package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.jdbc.ConexaoBanco;
import br.com.fiap.fintech.model.CartaoModel;

public class CartaoDAOImpl extends ConexaoBanco implements CartaoDAO{
	
	public CartaoModel findById(int codigo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		
		CartaoModel cartao = new CartaoModel();
		
		stbQuery.append("SELECT t_banco_t_usuario_cd_usuario, t_banco_nr_conta, nr_numero_cartao, dt_vencimento, nm_nome FROM t_cartao where nr_numero_cartao = ?");
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(1, codigo);			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
            	java.sql.Date data = rs.getDate("dt_vencimento");
            	Calendar dtVencimento = Calendar.getInstance();
            	dtVencimento.setTimeInMillis(data.getTime());
				
				cartao.setCd_usuario(rs.getInt("t_banco_t_usuario_cd_usuario"));
				cartao.setNr_conta(rs.getInt("t_banco_nr_conta"));
				cartao.setNr_numero_cartao(rs.getInt("nr_numero_cartao"));
				cartao.setDt_vencimento(dtVencimento);
				cartao.setNm_nome(rs.getString("nm_nome"));
				
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(stmt);
			closeConnection(conn);
			closeResult(rs);
		}
		return cartao;
	}
	
	public List<CartaoModel> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		
		List<CartaoModel> listaCartoes = new ArrayList<>();
		
		stbQuery.append("SELECT t_banco_t_usuario_cd_usuario, t_banco_nr_conta, nr_numero_cartao, dt_vencimento, nm_nome FROM t_cartao");
		
		try {
			
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			rs = stmt.executeQuery();
			
			while (rs.next()){
				
				CartaoModel cartao = new CartaoModel();
				
            	java.sql.Date data = rs.getDate("dt_vencimento");
            	Calendar dtVencimento = Calendar.getInstance();
            	dtVencimento.setTimeInMillis(data.getTime());
				
				cartao.setCd_usuario(rs.getInt("t_banco_t_usuario_cd_usuario"));
				cartao.setNr_conta(rs.getInt("t_banco_nr_conta"));
				cartao.setNr_numero_cartao(rs.getInt("nr_numero_cartao"));
				cartao.setDt_vencimento(dtVencimento);
				cartao.setNm_nome(rs.getString("nm_nome"));
				
				listaCartoes.add(cartao);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn); 
			closeStatement(stmt); 
			closeResult(rs);
		}
		return listaCartoes;
	}
	
	public void adicionarCartao(CartaoModel cartao) {
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append("INSERT INTO t_cartao (t_banco_t_usuario_cd_usuario, t_banco_nr_conta, nr_numero_cartao, dt_vencimento, nm_nome) VALUES (?, ?, ?, ?, ?) ");
		
		int param =1;
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(param++, cartao.getCd_usuario());
			stmt.setInt(param++, cartao.getNr_conta());
			stmt.setInt(param++, cartao.getNr_numero_cartao());
			stmt.setDate(param ++, new java.sql.Date(cartao.getDt_vencimento().getTimeInMillis()));	
			stmt.setString(param++, cartao.getNm_nome());
			
			stmt.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(conn);
			closeStatement(stmt);
		}
	}
	
	public void alterarDadosDoCartao(CartaoModel cartao) {
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
	
		stbQuery.append("UPDATE T_CARTAO SET t_banco_nr_conta = ?, nr_numero_cartao = ?, dt_vencimento = ?, nm_nome = ? where nr_numero_cartao = ?");
		
		int param = 1;
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
		
			
			stmt.setInt(param++, cartao.getNr_conta());
			stmt.setInt(param++, cartao.getNr_numero_cartao());
			stmt.setDate(param ++, new java.sql.Date(cartao.getDt_vencimento().getTimeInMillis()));	
			stmt.setString(param++, cartao.getNm_nome());
			stmt.setInt(param++, cartao.getNr_numero_cartao());

			
			stmt.executeUpdate();
			
	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(conn);
			closeStatement(stmt);
		}
	}
	
	public void excluirCartao(int codigo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append("DELETE FROM T_CARTAO WHERE nr_numero_cartao = ?");
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(1, codigo);
			
			stmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	}
}
