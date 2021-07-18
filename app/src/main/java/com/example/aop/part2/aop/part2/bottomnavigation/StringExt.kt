package com.example.aop.part2.aop.part2.bottomnavigation

import java.util.regex.Pattern

/**
 * @author danke (https://github.com/danke77)
 * @date 16/7/9
 */

/**
 * get the first letter of one string
 */
fun getFirstLetter(str: String?): String {
    if (str == null) {
        return "#"
    }
    if (str.trim().length == 0) {
        return "#"
    }
    val c = str.trim().substring(0, 1)[0]

    val pattern = Pattern.compile("^[A-Za-z]+$")
    if (pattern.matcher(c + "").matches()) {
        return (c + "").toUpperCase()
    } else {
        return "#"
    }
}