package com.stayvida.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.stayvida.backend.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.EmptyResultDataAccessException;
@Repository
public class LoginUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String findUserNameIfValid(String email, String password) {
        try {
            String sql = "SELECT username FROM users WHERE email = ? AND password = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{email, password}, String.class);
        } catch (EmptyResultDataAccessException e) {
            return null; // No matching user
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
