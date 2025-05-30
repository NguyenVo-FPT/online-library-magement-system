package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import config.db;
import dto.SystemConfig;
import interfaces.IConfigSystemDAO;
import java.sql.PreparedStatement;

public class SystemConfigDAO implements IConfigSystemDAO {

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
    public int updateConfig(String key, String value, String desc) {
        int result = 0;
        Connection cn = null;

        try {
            // connect with db
            cn = db.getConnection();
            if (cn != null) {
                String sql = "update [dbo].[system_config]\n"
                        + "set [config_key] = 'active'\n"
                        + "where email = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, key);
                result = st.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public SystemConfig getConfigByKey(String key) {
        SystemConfig result = null;
        Connection cn = null;
        try {
            cn = db.getConnection(); // connect with db
            if (cn != null) {
                String sql = "select [id], [config_key], [config_value], [description]\n"
                        + "from [dbo].[system_config]"
                        + "where [config_key] = ?";

                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, key);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int id = table.getInt("id");
                    String value = table.getString("config_value");
                    String description = table.getString("description");

                    result = new SystemConfig(id, key, value, description);
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

        return result;
    }

}
