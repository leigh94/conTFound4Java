package com.leigh4java.contfound4java.learnTest;

import java.util.regex.Pattern;
import java.math.BigDecimal;

public class NumberFormatValidator {

    // 正则表达式：小数点前最多22位数字，小数点后最多2位数字
    private static final String DECIMAL_REGEX = "^[-+]?\\d{1,22}(\\.\\d{1,2})?$";
    private static final Pattern DECIMAL_PATTERN = Pattern.compile(DECIMAL_REGEX);

    /**
     * 校验数字字符串格式
     * @param numberStr 数字字符串
     * @return true-格式正确，false-格式错误
     */
    public static boolean validateDecimalFormat(String numberStr) {
        if (numberStr == null || numberStr.trim().isEmpty()) {
            return false;
        }

        // 清理字符串（移除空格、千分位分隔符）
        String cleanedStr = numberStr.trim().replace(",", "");

        // 正则表达式校验
        return DECIMAL_PATTERN.matcher(cleanedStr).matches();
    }

}
