package dao;

import interfaces.IUserDAO;
import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import config.db;

public class UserDAO implements IUserDAO {

    @Override
    public User getUserByEmail(String email) {
        User result = null;
        Connection cn = null;

        try {
            cn = db.getConnection(); // connect with db
            if (cn != null) {
                String sql = "select [id],[name],[email],[password],[role],[status]\n"
                        + "from [dbo].[users]\n"
                        + "where [email] = '" + email + "'"; // query and excute query

                Statement st = cn.createStatement();
                ResultSet table = st.executeQuery(sql);
                if (table != null && table.next()) { // read data in table
                    int id = table.getInt("id");
                    String name = table.getString("name");
                    String password = table.getString("password");
                    String role = table.getString("role");
                    String status = table.getString("status");

                    result = new User(id, name, email, password, role, status);
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

    @Override
    public User getUserForLogin(String email, String password) {
        User result = null;
        Connection cn = null;

        try {
            cn = db.getConnection(); // connect with db
            if (cn != null) {
                String sql = "select [id],[name],[email],[password],[role],[status]\n"
                        + "from [dbo].[users]\n"
                        + "where [email] = ? and [password] = ?  COLLATE Latin1_General_CS_AS"; // query and excute query

                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, email);
                st.setString(2, password);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) { // read data in table
                    int id = table.getInt("id");
                    String name = table.getString("name");
                    String role = table.getString("role");
                    String status = table.getString("status");

                    result = new User(id, name, email, password, role, status);
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

    @Override
    public int addNewUser(User user) {
        int result = 0;
        Connection cn = null;

        try {
            // connect with db
            cn = db.getConnection();
            if (cn != null) {
                String sql = "insert [dbo].[users]\n"
                        + "values (?,?,?,'user', 'active')";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, user.getName());
                st.setString(2, user.getEmail());
                st.setString(3, user.getPassword());

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
    public int deleteUser(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public int updateUser(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

}
