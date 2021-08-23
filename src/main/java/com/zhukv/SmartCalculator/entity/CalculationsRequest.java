package com.zhukv.SmartCalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CalculationsRequest {
    private String first, second, operator;
    private boolean square;
}
