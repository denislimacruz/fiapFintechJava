package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.jdbc.ConexaoBanco;
import br.com.fiap.fintech.model.InvestimentoModel;

public class InvestimentoDAOImpl extends ConexaoBanco implements InvestimentoDAO{
	
	
	public InvestimentoModel findById(int codigo) {
       
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		
		InvestimentoModel investimentoModel = new InvestimentoModel();

		stbQuery.append("SELECT t_usuario_cd_usuaio, cd_investimento, nm_nome, vl_valor, dt_data, dt_vencimento, ds_rendimento FROM T_INVESTIMENTO WHERE cd_investimento = ? ");
        
		try {
			
        	conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(1, codigo);
			
			rs = stmt.executeQuery();
			
            if (rs.next() ) {
                
            	investimentoModel = new InvestimentoModel();
            	
            	java.sql.Date data = rs.getDate("dt_data");
            	Calendar dtData = Calendar.getInstance();
            	dtData.setTimeInMillis(data.getTime());
            	java.sql.Date data2 = rs.getDate("dt_vencimento");
            	Calendar dtVencimento = Calendar.getInstance();
            	dtVencimento.setTimeInMillis(data2.getTime());
            	
            	investimentoModel.setCd_usuario(rs.getInt("t_usuario_cd_usuario"));
                investimentoModel.setCd_investimento( rs.getInt("cd_investimento"));
                investimentoModel.setNm_nome( rs.getString("nm_nome"));
                investimentoModel.setVl_valor( rs.getDouble("vl_valor"));
                investimentoModel.setDs_rendimento( rs.getString("ds_rendimento"));
                investimentoModel.setDt_data(dtData);
                investimentoModel.setDt_vencimento(dtVencimento);
            }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResult(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}

        return investimentoModel;
    }
	
		
	public List<InvestimentoModel> findAll(){
	
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			StringBuffer stbQuery = new StringBuffer();
			
	        List<InvestimentoModel> listaInvestimentos = new ArrayList<>();
	        
	       stbQuery.append("SELECT t_usuario_cd_usuario, cd_investimento, nm_nome, vl_valor, dt_data, dt_vencimento, ds_rendimento FROM T_INVESTIMENTO");
	    	
	
	        try {
	        	conn = getConexao();
				stmt = conn.prepareStatement(stbQuery.toString());
				
	            rs = stmt.executeQuery();
	
	            while( rs.next() ) {
	            	
	            	InvestimentoModel investimentoModel = new InvestimentoModel();
	            	
	            	java.sql.Date data = rs.getDate("dt_data");
	            	Calendar dtData = Calendar.getInstance();
	            	dtData.setTimeInMillis(data.getTime());
	            	java.sql.Date data2 = rs.getDate("dt_vencimento");
	            	Calendar dtVencimento = Calendar.getInstance();
	            	dtVencimento.setTimeInMillis(data2.getTime());
	                
	                investimentoModel.setCd_usuario( rs.getInt("t_usuario_cd_usuario"));
	                investimentoModel.setCd_investimento( rs.getInt("cd_investimento"));
	                investimentoModel.setNm_nome( rs.getString("nm_nome"));
	                investimentoModel.setVl_valor( rs.getInt("vl_valor"));
	                investimentoModel.setDs_rendimento( rs.getString("ds_rendimento"));
	                investimentoModel.setDt_data(dtData);
	                investimentoModel.setDt_vencimento(dtVencimento);
	
	                listaInvestimentos.add(investimentoModel);
	            }
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeResult(rs);
				closeStatement(stmt);
				closeConnection(conn);
			}
	
	        return listaInvestimentos;
	
	}

    public void adicionarInvestimento(InvestimentoModel investimento) {
        
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();

        stbQuery.append(" INSERT INTO T_INVESTIMENTO(t_usuario_cd_usuario, cd_investimento, nm_nome, vl_valor, dt_data, dt_vencimento, ds_rendimento) VALUES (?,SEQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?)");
		
        int param = 1;

		try {
			
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(param ++, investimento.getCd_usuario());
			stmt.setString(param ++, investimento.getNm_nome());
			stmt.setDouble(param ++, investimento.getVl_valor());
			stmt.setDate(param ++, new java.sql.Date(investimento.getDt_data().getTimeInMillis()));		
			stmt.setDate(param ++, new java.sql.Date(investimento.getDt_vencimento().getTimeInMillis()));
			stmt.setString(param ++, investimento.getDs_rendimento());
			
			stmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeConnection(conn);
		}
	
	}
    
    public void excluirInvestimento(int codigo) {
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	StringBuffer stbQuery = new StringBuffer();
    	
    	stbQuery.append("DELETE FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ? ");
    	
    	try {
    		conn = getConexao();
    		stmt = conn.prepareStatement(stbQuery.toString());
    		
    		stmt.setInt(1, codigo);
    		
    		stmt.executeUpdate();
    		
    		System.out.println("Investimento excluido!");
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		closeConnection(conn);
    		closeStatement(stmt);
    	}
    }
    
}
