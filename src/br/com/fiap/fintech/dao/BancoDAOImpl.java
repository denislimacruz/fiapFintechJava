package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.jdbc.ConexaoBanco;
import br.com.fiap.fintech.model.BancoModel;



public class BancoDAOImpl extends ConexaoBanco implements BancoDAO{

	public BancoModel findById(int codigo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery= new StringBuffer();
		
		BancoModel bancoModel = new BancoModel();
		
		stbQuery.append("SELECT T_USUARIO_CD_USUARIO, nr_conta, digito_conta, nr_agencia, digito_agencia FROM T_BANCO WHERE nr_conta = ? ");
		
		try {	
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(1, codigo);
			
			rs = stmt.executeQuery();
			
			
			if ( rs.next() ) {
				bancoModel = new BancoModel();
				bancoModel.setCd_usuario(rs.getInt("T_USUARIO_CD_USUARIO"));
				bancoModel.setNr_conta( rs.getInt("nr_conta") );
				bancoModel.setDigito_conta(rs.getInt("digito_conta"));
				bancoModel.setNr_agencia( rs.getInt("nr_agencia"));
				bancoModel.setDigito_agencia(rs.getInt("digito_agencia"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(conn);
			closeStatement(stmt);
			closeResult(rs);
		}
		
		return bancoModel;
	}
		
	public List<BancoModel> findAll(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer stbQuery = new StringBuffer();
		
		List<BancoModel> listaBancos = new ArrayList<BancoModel>();
		
		stbQuery.append("SELECT T_USUARIO_CD_USUARIO, nr_conta, digito_conta, nr_agencia, digito_agencia FROM T_BANCO");
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			rs = stmt.executeQuery();
			
			
			while( rs.next() ) {
				BancoModel bancoModel = new BancoModel();
				bancoModel.setCd_usuario(rs.getInt("T_USUARIO_CD_USUARIO"));
				bancoModel.setNr_conta( rs.getInt("nr_conta") );
				bancoModel.setDigito_conta(rs.getInt("digito_conta"));
				bancoModel.setNr_agencia( rs.getInt("nr_agencia"));
				bancoModel.setDigito_agencia(rs.getInt("digito_agencia"));
				listaBancos.add(bancoModel);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
			closeStatement(stmt);
			closeResult(rs);
		}
		
		return listaBancos;	
	}
	
	public void adicionarBanco(BancoModel bancoModel){

		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append(" INSERT INTO T_BANCO (T_USUARIO_CD_USUARIO, nr_conta, digito_conta, nr_agencia, digito_agencia) VALUES (?, ?, ?, ?, ?)");
		
	
		int param = 1;
		
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(param++, bancoModel.getCd_usuario());
			stmt.setInt(param++, bancoModel.getNr_conta());
			stmt.setInt(param++, bancoModel.getDigito_conta());
			stmt.setInt(param++, bancoModel.getNr_agencia());
			stmt.setInt(param++, bancoModel.getDigito_agencia());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
			closeStatement(stmt);
		}
		
	}
	
	public void alterarDadosDoBanco(BancoModel bancoModel){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append(" UPDATE T_BANCO SET nr_conta = ?, digito_conta = ?, nr_agencia = ?, digito_agencia = ? WHERE T_USUARIO_CD_USUARIO = ?");
			
		int param = 1;
		try {
			conn = getConexao();
			stmt = conn.prepareStatement(stbQuery.toString());
			
			stmt.setInt(param++, bancoModel.getNr_conta());
			stmt.setInt(param++, bancoModel.getDigito_conta());
			stmt.setInt(param ++, bancoModel.getNr_agencia());	
			stmt.setInt(param++, bancoModel.getDigito_agencia());
			stmt.setInt(param++, bancoModel.getCd_usuario());
			
			stmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
			closeStatement(stmt);
		}		
	}
	
	public void excluirBanco(int codigo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuffer stbQuery = new StringBuffer();
		
		stbQuery.append("DELETE FROM T_BANCO WHERE nr_conta = ?");
		
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
