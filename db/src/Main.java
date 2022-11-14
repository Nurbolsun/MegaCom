import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\SQL\\itschool.db");
       /* PreparedStatement preparedStatement = connection.prepareStatement("insert into tb_teachers(name) values(?)");
        preparedStatement.setString(1, "Санжар");
        preparedStatement.executeUpdate();*/

            PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_teachers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("id: " + resultSet.getString("id"));
                System.out.println("name: " + resultSet.getString("name"));
            }
            resultSet.close();
            preparedStatement.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            connection.close();
        }

    }
}