package DAO;

import Model.Customer;

import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.lang.reflect.*;

public class AbstractDAO<T> {
    protected static final Logger LOGGER=Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String createSelectQuery(String field)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("ordermanagement." + type.getSimpleName().toLowerCase());
        sb.append(" WHERE " + field + " =? ");
        return sb.toString();
    }

    private String createSelectQuery1()
    {
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("ordermanagement." + type.getSimpleName().toLowerCase());
        //sb.append(" WHERE " + field + " =? ");
        return sb.toString();
    }

    private String createDeleteQuery(String field)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("DELETE ");
        sb.append(" FROM ");
        sb.append("ordermanagement." + type.getSimpleName().toLowerCase());
        sb.append(" WHERE " + field + " =? ");
        return sb.toString();
    }

    private String createUpdateQuery(String field1,String field2)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" SET " + field1 + " =? ");
        sb.append(" WHERE " + field2 + " =? ");
        return sb.toString();
    }

    @SuppressWarnings("deprecation")
    private List <T> createObjects(ResultSet resultSet)
    {
        List <T> list=new ArrayList<T>();
        try
        {
            while(resultSet.next())
            {
                T instance=type.newInstance();
                for (Field field : type.getDeclaredFields())
                {
                    Object value=resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor=new PropertyDescriptor(field.getName(),type);
                    Method method=propertyDescriptor.getWriteMethod();
                    method.invoke(instance,value);

                }
                list.add(instance);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());
        }

        return list;
    }

    public T findbyID(int id, String field)
    {
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String query=createSelectQuery(field);
        try
        {
            conn=ConnectionFactory.getConnection();
            statement=conn.prepareStatement(query);
            statement.setInt(1,id);
            resultSet=statement.executeQuery();
            return createObjects(resultSet).get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
        return null;
    }

    public List<T> findall() throws SQLException {
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String query=createSelectQuery1();
        List<T> lista=new ArrayList<T>();
        try
        {
            conn=ConnectionFactory.getConnection();
            statement=conn.prepareStatement(query);
            resultSet=statement.executeQuery();
            lista=createObjects(resultSet);
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
        return null;

    }

    public void delete(int id, String field)
    {
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String query=createDeleteQuery(field);
        try
        {
            conn=ConnectionFactory.getConnection();
            statement=conn.prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
    }

    public void update(String field1,String field2,String intr,int id)
    {
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String query=createUpdateQuery(field1,field2);
        try
        {
            conn=ConnectionFactory.getConnection();
            statement=conn.prepareStatement(query);
            statement.setString(1,intr);
            statement.setInt(2,id);
            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
    }

    public void update2(String field1,String field2,int intr,int id)
    {
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String query=createUpdateQuery(field1,field2);
        try
        {
            conn=ConnectionFactory.getConnection();
            statement=conn.prepareStatement(query);
            statement.setInt(1,intr);
            statement.setInt(2,id);
            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
    }

}
