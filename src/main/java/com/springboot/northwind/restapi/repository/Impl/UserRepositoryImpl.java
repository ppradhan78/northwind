package com.springboot.northwind.restapi.repository.Impl;

import com.springboot.northwind.restapi.entity.User;
import com.springboot.northwind.restapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT UserId, Username, PasswordHash,Email,PhoneNumber FROM Users WHERE Username = ?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), username);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return User.builder()
                    .userId(rs.getInt("UserId"))
                    .username(rs.getString("Username"))
                    .passwordHash(rs.getString("PasswordHash"))
                    .email(rs.getString("Email"))
                    .phoneNumber(rs.getString("PhoneNumber"))
                    .build();
        }
    }
}
