package com.philip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.philip.model.User;
import com.philip.util.DbUtil;

public class UserDao {
    private Connection connection;

    public UserDao() {
        connection = DbUtil.getConnection();
    }

    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into schedule(title,startTime,endTime,day) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getTitle());
            preparedStatement.setInt(2, user.getStartTime());
            preparedStatement.setInt(3, user.getEndTime());
            preparedStatement.setInt(4, user.getDay());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where userid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set title=?, startTime=?, endTime=?, day=?" +
                            "where userid=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getTitle());
            preparedStatement.setInt(2, user.getStartTime());
            preparedStatement.setInt(3, user.getEndTime());
            preparedStatement.setInt(4, user.getDay());
            preparedStatement.setInt(5, user.getUserid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setTitle(rs.getString("title"));
                user.setStartTime(rs.getInt("startTime"));
                user.setEndTime(rs.getInt("endTime"));
                user.setDay(rs.getInt("day"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserById(int userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setUserid(rs.getInt("userid"));
                user.setTitle(rs.getString("title"));
                user.setStartTime(rs.getInt("startTime"));
                user.setEndTime(rs.getInt("endTime"));
                user.setDay(rs.getInt("day"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

}
