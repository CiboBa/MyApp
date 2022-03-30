package program;

import program.ui.InitialView;

import java.sql.ResultSet;
import java.sql.Statement;

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
