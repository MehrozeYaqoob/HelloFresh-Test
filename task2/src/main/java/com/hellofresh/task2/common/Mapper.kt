package com.hellofresh.task2.common

interface Mapper<From, To> {
    fun map(from: From): To
}
