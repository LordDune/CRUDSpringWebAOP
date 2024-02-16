package com.example.demo.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Data
@Service
public class DatabaseSQLService {
    @Value("${SQL.findAll}")
    private String findAll;
    @Value("${SQL.save}")
    private String save;
    @Value("${SQL.deleteById}")
    private String deleteById;
    @Value("${SQL.update}")
    private String update;
    @Value("${SQL.getUser}")
    private String getUser;
}
