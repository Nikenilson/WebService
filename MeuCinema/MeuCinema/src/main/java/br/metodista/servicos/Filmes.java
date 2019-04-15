package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Filmes {
	public static boolean cadastrado(int id) throws Exception
	{
		boolean ret = false;

		try
		{
			String sql;

            sql = "SELECT * " +
                  "FROM FILME " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, id);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            ret = resultado.first();
		}
		catch(SQLException erro)
		{
			throw new Exception("Filme não encontrado");
		}

		return ret;
	}

	public static void incluir (Filme filme) throws Exception
    {
        if (filme==null)
            throw new Exception ("Filme não fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO FILME " +
                  "(ID,FILME,SINOPSE,GENERO,DURACAO,TRAILER) " +
                  "VALUES " +
                  "(?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt      ( 1, filme.getId ());
            BDSQLServer.COMANDO.setString    (2, filme.getFilme ());
            BDSQLServer.COMANDO.setString    (3, filme.getSinopse ());
            BDSQLServer.COMANDO.setString    (4, filme.getGenero ());
            BDSQLServer.COMANDO.setInt       (5, filme.getDuracao ()); //O que fazer?
            BDSQLServer.COMANDO.setString    (6, filme.getTrailer ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir filme");
        }
    }

    public static void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM FILME " +
                  "WHERE ID=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir filme");
        }
    }

    public static void alterar (Filme filme) throws Exception
    {
        if (filme==null)
            throw new Exception ("Filme nao fornecido");

        if (!cadastrado (filme.getId()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE FILME " +
                  "SET FILME=? " +
                  ", SINOPSE=? " +
                  ", GENERO=? "+
                  ", DURACAO=? "+
                  ", TRAILER=? "+
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString 	 (1, filme.getFilme ());
            BDSQLServer.COMANDO.setString    (2, filme.getSinopse ());
            BDSQLServer.COMANDO.setString    (3, filme.getGenero ());
            BDSQLServer.COMANDO.setInt 	 	 (4, filme.getDuracao ()); //O que fazer?
            BDSQLServer.COMANDO.setString 	 (5, filme.getTrailer ());
            BDSQLServer.COMANDO.setInt    	 (6, filme.getId ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados do filme");
        }
    }

    public static Filme getFilme (int codigo) throws Exception
    {
        Filme filme = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FILME " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            filme = new Filme     (resultado.getInt      ("ID"),
                                   resultado.getString   ("FILME"),
                                   resultado.getString   ("SINOPSE"),
                                   resultado.getString   ("GENERO"),
                                   resultado.getInt      ("DURACAO"),
                                   resultado.getString   ("TRAILER"))/;
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar filme");
        }

        return filme;
    }

    public static MeuResultSet getFilmes () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FILME";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar filmes");
        }

        return resultado;
    }
}
