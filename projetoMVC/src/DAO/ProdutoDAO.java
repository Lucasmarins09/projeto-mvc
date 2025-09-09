package DAO;

import model.Produto;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements GenericDAO{

    private Connection conn;

    public ProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Boolean insert(Object object) throws SQLException {
        Produto produto = (Produto) object;
        PreparedStatement stmt = null;

        // Corrigido: vírgula entre preco e status + 3 placeholders
        String sql = "INSERT INTO produto (descricao, preco, status) VALUES (?, ?, ?)";

        try {
            // Prepara o comando SQL
            stmt = this.conn.prepareStatement(sql);

            // Inserindo os valores nas interrogações
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setBoolean(3, produto.isStatus());

            // Executa a SQL no banco
            stmt.executeUpdate(); // melhor que execute() para INSERT
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            e.printStackTrace();
            return false;

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }


    @Override
    public Boolean update(Object object) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
