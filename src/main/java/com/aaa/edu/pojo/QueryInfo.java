package com.aaa.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryInfo {
    String query;
    Integer pageNumber;
    Integer pageSize;
}
