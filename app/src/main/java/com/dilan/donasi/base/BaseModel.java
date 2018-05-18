package com.dilan.donasi.base;

import java.util.List;

import lombok.Data;

/**
 * Created by Rosinante24 on 10/01/18.
 */
@Data
public class BaseModel<T> {
    private List<T> results;
}
