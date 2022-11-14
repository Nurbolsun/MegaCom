import java.sql.*;

public class Main {
    public static void main(String[] args){

/*        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\SQL\\itschool.db");
            PreparedStatement preparedStatement = connection.prepareStatement("update tb_teachers set name=? where id=?");
            preparedStatement.setString(1, "Бактилек");
            preparedStatement.setInt(2, 5);
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_teachers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("id" + resultSet.getString("id"));
                System.out.println("name" + resultSet.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itschool", "5432", "5432");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_courses");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("id" + resultSet.getString("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}