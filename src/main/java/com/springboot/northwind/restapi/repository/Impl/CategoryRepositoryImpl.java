package com.springboot.northwind.restapi.repository.Impl;
import com.springboot.northwind.restapi.entity.Category;
import com.springboot.northwind.restapi.repository.CategoryRepository;

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
public class CategoryRepositoryImpl  implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "SELECT CategoryID, CategoryName,Description,Picture FROM Categories";
    private static final String SELECT_BY_ID = "SELECT CategoryID, CategoryName,Description,Picture FROM Categories WHERE CategoryID = ?";
    private static final String INSERT = "INSERT INTO Categories (CategoryName,Description) VALUES (?,?)";
    private static final String UPDATE = "UPDATE Categories SET CategoryName = ? WHERE CategoryID = ?";
    private static final String DELETE = "DELETE FROM Categories WHERE CategoryID = ?";

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new CategoryRowMapper());
    }

    @Override
    public Optional<Category> findById(Integer id) {
        List<Category> list = jdbcTemplate.query(SELECT_BY_ID, new CategoryRowMapper(), id);
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }

    @Override
    public void save(Category entity) {
        jdbcTemplate.update(INSERT, entity.getCategoryName());
    }

    @Override
    public void update(Category entity) {
        jdbcTemplate.update(UPDATE, entity.getCategoryName(), entity.getCategoryId());
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update(DELETE, id);
    }

    private static class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Category.builder()
                    .categoryId(rs.getInt("CategoryID"))
                    .categoryName(rs.getString("CategoryName"))
                    .description(rs.getString("Description"))
                    .picture(rs.getBytes("Picture"))
                    .build();
        }
    }
}
