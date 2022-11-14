package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.jdbc.ConexaoBanco;
import br.com.fiap.fintech.model.RecebidoModel;

public class RecebidoDAOImpl extends ConexaoBanco implements RecebidoDAO{

	public RecebidoModel findById(int codigo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		
		RecebidoModel recebidoModel = new RecebidoModel();
		
		stbQuery.append("SELECT T_USUARIO_CD_USUARIO, cd_recebido, vl_valor, dt_data, ds_categoria, ds_descricao FROM T_RECEBIDO WHERE cd_recebido = ? ");

		try {
			
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				
				recebidoModel = new RecebidoModel();
				
            	java.sql.Date data = rs.getDate("dt_data");
            	Calendar dtData = Calendar.getInstance();
            	dtData.setTimeInMillis(data.getTime());
            	
				recebidoModel.setCd_usuario(rs.getInt("T_USUARIO_CD_USUARIO"));
				recebidoModel.setCd_recebido( rs.getInt("cd_recebido") );
				recebidoModel.setVl_valor( rs.getDouble("vl_valor"));
				recebidoModel.setDt_data(dtData);
				recebidoModel.setDs_categoria( rs.getString("ds_categoria"));
				recebidoModel.setDs_descricao( rs.getString("ds_descricao"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}

		return recebidoModel;
	}

	public List<RecebidoModel> findAll(){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		
		List<RecebidoModel> listaRecebidos = new ArrayList<>();
		
		stbQuery.append("SELECT T_USUARIO_CD_USUARIO, cd_recebido, vl_valor, dt_data, ds_categoria, ds_descricao FROM T_RECEBIDO");
		
		try {
			
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			rs = stmt.executeQuery();
			
			while( rs.next() ) {

				RecebidoModel recebido = new RecebidoModel();
				
            	java.sql.Date data = rs.getDate("dt_data");
            	Calendar dtData = Calendar.getInstance();
            	dtData.setTimeInMillis(data.getTime());
            	
            	recebido.setCd_usuario(rs.getInt("t_usuario_cd_usuario"));
				recebido.setCd_recebido( rs.getInt("cd_recebido"));
				recebido.setVl_valor( rs.getDouble("vl_valor"));
				recebido.setDt_data(dtData);
				recebido.setDs_categoria(rs.getString("ds_categoria"));
				recebido.setDs_descricao(rs.getString("ds_descricao"));
				
				listaRecebidos.add(recebido);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}

		return listaRecebidos;
	}

	public void inserirNovoRecebido(RecebidoModel recebido){
		Connection conn= null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append(" INSERT INTO T_RECEBIDO (T_USUARIO_CD_USUARIO, cd_recebido, vl_valor, dt_data, ds_categoria, ds_descricao) VALUES (?, SEQ_RECEBIDO.NEXTVAL, ?, ?, ?, ? )");

		int param = 1;
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());

			stmt.setInt(param++, recebido.getCd_usuario());
			stmt.setDouble(param++, recebido.getVl_valor());
			stmt.setDate(param ++, new java.sql.Date(recebido.getDt_data().getTimeInMillis()));	
			stmt.setString(param++, recebido.getDs_categoria());
			stmt.setString(param++, recebido.getDs_descricao());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	}

	public void atualizarRecebido(RecebidoModel recebido){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append(" UPDATE T_RECEBIDO SET vl_valor = ?, dt_data = ?, ds_categoria = ?, ds_descricao = ? where cd_recebido = ?");

		int param = 1;
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
					
			stmt.setDouble(param++, recebido.getVl_valor());
			stmt.setDate(param ++, new java.sql.Date(recebido.getDt_data().getTimeInMillis()));	
			stmt.setString(param++, recebido.getDs_categoria());
			stmt.setString(param++, recebido.getDs_descricao());
			stmt.setInt(param++, recebido.getCd_recebido());

				
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	}
	
	public void excluirRecebido(int codigo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append("DELETE FROM T_RECEBIDO WHERE cd_recebido = ? ");
		
		try {
			
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(1, codigo);
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	}
	
}
