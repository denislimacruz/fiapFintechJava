package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.jdbc.ConexaoBanco;
import br.com.fiap.fintech.model.GastoModel;

public class GastoDAOImpl extends ConexaoBanco implements GastoDAO{

	public GastoModel findById(int codigo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		
		GastoModel gastoModel = new GastoModel();
		
		stbQuery.append("SELECT T_USUARIO_CD_USUARIO, cd_gasto, vl_valor, dt_data, ds_categoria, ds_descricao FROM T_GASTO WHERE cd_gasto = ? " );

		try {
			
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			

			if ( rs.next() ) {
				
            	java.sql.Date data = rs.getDate("dt_data");
            	Calendar dtData = Calendar.getInstance();
            	dtData.setTimeInMillis(data.getTime());
            	
            	gastoModel.setCd_usuario( rs.getInt("T_USUARIO_CD_USUARIO"));
				gastoModel.setCd_gasto( rs.getInt("cd_gasto"));
				gastoModel.setVl_valor( rs.getInt("vl_valor"));
				gastoModel.setDt_data(dtData);
                gastoModel.setDs_categoria( rs.getString("ds_categoria"));
                gastoModel.setDs_descricao( rs.getString("ds_descricao"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}
		
		return gastoModel;
	}

	public List<GastoModel> findAll(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();

		List<GastoModel> listaGastos = new ArrayList<GastoModel>();
		
		stbQuery.append("SELECT T_USUARIO_CD_USUARIO, cd_gasto, vl_valor, dt_data, ds_categoria, ds_descricao FROM T_GASTO");

		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			rs = stmt.executeQuery();

			while( rs.next() ) {

				GastoModel gastoModel = new GastoModel();
				
            	java.sql.Date data = rs.getDate("dt_data");
            	Calendar dtData = Calendar.getInstance();
            	dtData.setTimeInMillis(data.getTime());
            	
				gastoModel.setCd_usuario( rs.getInt("T_USUARIO_CD_USUARIO"));
				gastoModel.setCd_gasto( rs.getInt("cd_gasto"));
				gastoModel.setVl_valor( rs.getDouble("vl_valor"));
				gastoModel.setDt_data(dtData);
                gastoModel.setDs_categoria( rs.getString("ds_categoria"));
                gastoModel.setDs_descricao( rs.getString("ds_descricao"));

				listaGastos.add(gastoModel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}
		return listaGastos;
	}

	public void inserirGasto(GastoModel gastoModel){
		
		Connection conn= null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append(" INSERT INTO T_GASTO(T_USUARIO_CD_USUARIO, cd_gasto, vl_valor, dt_data, ds_categoria, ds_descricao) VALUES (?, SEQ_GASTO.NEXTVAL, ?, ?, ?, ?)");

		int param = 1;
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(param++, gastoModel.getCd_usuario());
			stmt.setDouble(param++, gastoModel.getVl_valor());
			stmt.setDate(param ++, new java.sql.Date(gastoModel.getDt_data().getTimeInMillis()));	
            stmt.setString(param++, gastoModel.getDs_categoria());
            stmt.setString(param++, gastoModel.getDs_descricao());
			
            stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	}

	public void atualizarGasto(GastoModel gastoModel){

		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append(" UPDATE T_GASTO SET vl_valor = ?, dt_data = ?, ds_categoria = ?, ds_descricao = ? where cd_gasto = ?");
		
		int param = 1;

		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());

		     stmt.setDouble(param++, gastoModel.getVl_valor());
		     stmt.setDate(param ++, new java.sql.Date(gastoModel.getDt_data().getTimeInMillis()));	
             stmt.setString(param++, gastoModel.getDs_categoria());
             stmt.setString(param++, gastoModel.getDs_descricao());
             stmt.setInt(param++, gastoModel.getCd_gasto());
             
             stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeStatement(stmt);
				closeConnection(conn);
			}


	}

	public void exclurGasto(int codigo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append("DELETE FROM T_GASTO WHERE cd_gasto = ?");
		
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
