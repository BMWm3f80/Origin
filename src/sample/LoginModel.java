package sample;
import java.sql.*;
public class LoginModel {
    Connection conection;
    public LoginModel(){
        conection = SqliteConnection.Connector();
        if(conection == null) System.exit(1);
    }

    public boolean isDbConnected(){
        try {
            return !conection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
    public boolean isLogin(String username, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM Users WHERE Username = ? and Password = ?";
        try {
            preparedStatement = conection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
}

