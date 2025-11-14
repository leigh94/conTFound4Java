package com.leigh4java.contfound4java.learnTest;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailedNumberValidator {

    // 更详细的错误信息枚举
    public enum ValidationResult {
        VALID("格式正确"),
        NULL_OR_EMPTY("输入为空"),
        INVALID_CHARACTERS("包含非法字符"),
        INTEGER_PART_TOO_LONG("整数部分超过22位"),
        DECIMAL_PART_TOO_LONG("小数部分超过2位"),
        INVALID_FORMAT("格式不正确");

        private final String description;

        ValidationResult(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * 详细校验数字格式
     * @param numberStr 数字字符串
     * @return 校验结果
     */
    public static ValidationResult validateDetailed(String numberStr) {
        // 检查空值
        if (numberStr == null || numberStr.trim().isEmpty()) {
            return ValidationResult.NULL_OR_EMPTY;
        }

        String cleanedStr = numberStr.trim().replace(",", "");

        // 检查是否只包含数字、小数点、正负号
        if (!cleanedStr.matches("^[-+]?[0-9.]*$")) {
            return ValidationResult.INVALID_CHARACTERS;
        }

        // 分割整数和小数部分
        String[] parts = cleanedStr.split("\\.");

        // 检查小数点数量
        if (parts.length > 2) {
            return ValidationResult.INVALID_FORMAT;
        }

        // 校验整数部分
        String integerPart = parts[0].replaceFirst("^[-+]?", ""); // 移除正负号
        if (integerPart.isEmpty()) {
            return ValidationResult.INVALID_FORMAT;
        }
        if (integerPart.length() > 22) {
            return ValidationResult.INTEGER_PART_TOO_LONG;
        }

        // 校验小数部分（如果有）
        if (parts.length == 2) {
            String decimalPart = parts[1];
            if (decimalPart.length() > 2) {
                return ValidationResult.DECIMAL_PART_TOO_LONG;
            }
        }

        // 尝试转换为BigDecimal进行最终验证
        try {
            new BigDecimal(cleanedStr);
            return ValidationResult.VALID;
        } catch (NumberFormatException e) {
            return ValidationResult.INVALID_FORMAT;
        }
    }
}