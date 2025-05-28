package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import config.db;
import dto.SystemConfig;
import interfaces.IConfigSystemDAO;

public class SystemConfigDAO implements IConfigSystemDAO{
    ArrayList<SystemConfig> configList = new ArrayList<>();

    @Override
    public ArrayList<SystemConfig> getList() {
        Connection cn = null;

        try {
            cn = db.getConnection(); // connect with db
            if (cn != null) {
                String sql = "select [id], [config_key], [config_value], [description]\n"
                        + "from [dbo].[system_config]"; // query and excute query

                Statement st = cn.createStatement();
                ResultSet table = st.executeQuery(sql);
                while (table.next()) {
                    int id = table.getInt("id");
                    String key = table.getString("config_key");
                    String value = table.getString("config_value");
                    String description = table.getString("description");

                    SystemConfig sc = new SystemConfig(id, key, value, description);
                    configList.add(sc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close(); // close connection
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return configList;
    }

    @Override
    public int updateConfig() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateConfig'");
    }

}