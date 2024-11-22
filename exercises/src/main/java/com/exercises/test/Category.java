package com.exercises.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author liutianlong
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    String id;
    String code;
    String parentid;
    List<Category> children;
}
