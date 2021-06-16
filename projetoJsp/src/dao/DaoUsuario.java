package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanProjetoJsp;
import connection.SingleConnection;

public class DaoUsuario {
	private  Connection connection;
	
		public DaoUsuario() {
			connection = SingleConnection.getConnection();
		}
		public void salvar(BeanProjetoJsp usuario)  {
					try{
					String sql = "insert into usuario(login, senha) values (?, ?)";
					PreparedStatement insert = connection.prepareStatement(sql);
					insert.setString(1, usuario.getLogin());
					insert.setString(2, usuario.getSenha());
					insert.execute();
					connection.commit();
					}catch (Exception e){
						e.printStackTrace();
						try {
							connection.rollback();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
		public List<BeanProjetoJsp> listar() throws  Exception{
			List<BeanProjetoJsp> listar = new ArrayList<BeanProjetoJsp>();
			
			
			String sql = "SELECT * FROM usuario";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
					BeanProjetoJsp beanProjetoJsp = new BeanProjetoJsp();
					beanProjetoJsp.setLogin(resultSet.getString("login"));
					beanProjetoJsp.setSenha(resultSet.getString("senha"));
					listar.add(beanProjetoJsp);
			}
			return listar;	
		}
		
		public void delete (String login){
			try {
			String sql = " delete from usuario where login = ' " + login + " ' ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
}
