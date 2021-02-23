package com.example.bttomnavi.util

import com.alibaba.fastjson.JSON

class JsonParser {

    companion object {
        fun <T> parserToBean(jsonStr: String, clz: Class<T>): T {
            return JSON.parseObject(jsonStr, clz)
        }
    }
}