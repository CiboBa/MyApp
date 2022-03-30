package program;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import program.ui.InitialView;
import program.users.models.StandardUser;
import program.users.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App {


    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {

        InitialView initialView = new InitialView();
        initialView.init();

//        TextView textView = new TextView();
//        textView.init();

//        String sql_select = "Select * From users";
//
//        try (Connection conn = DBConnection.createNewDBConnection()) {
//
//            statement = conn.createStatement();
//            resultSet = statement.executeQuery(sql_select);
//
//            List<User> users = new ArrayList<>();
//
//            while (resultSet.next()) {
//
//                StandardUser standardUser = new StandardUser();
//
//                standardUser.setUsername(resultSet.getString("username"));
//                standardUser.setPassword(resultSet.getString("password"));
//
//                users.add(standardUser);
//            }
//
//            ObjectMapper mapper = new ObjectMapper();
//            String JSONOutput = mapper.writeValueAsString(users);
//            System.out.println("this is json: " + JSONOutput);
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }
}
