/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.User;
import java.sql.SQLException;
/**
 *
 * @author ADMIN
 */
public interface IUserDAO {
 public void insertUser(User user) throws SQLException;
 public User selectUser(int id);
 public List<User> selectAllUsers();
 public boolean deleteUser(int id) throws SQLException;
 public boolean updateUser(User user) throws SQLException;
}
