package DAO;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO {

    public List<Object> getAll();

    public Object getById(int id);

    public Boolean insert(Object object) throws SQLException;

    public Boolean update(Object object);

    public void delete(int id);


}
