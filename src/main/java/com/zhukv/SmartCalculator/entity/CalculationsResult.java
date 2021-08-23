package com.zhukv.SmartCalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CalculationsResult {
    private String result, historicalOutput;
}
