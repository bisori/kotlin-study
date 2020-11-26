package com.github.bisori.study

import java.math.BigInteger

fun main() {
    fun test(case: Int) {
        println("case: $case")
        println(Fibonacci.dp(case))
        println(Fibonacci.rec(case))
        println()
    }

    test(1)
    test(2)
    test(3)
    test(10)
    test(1000)
}

object Fibonacci {

    fun rec(n: Int): BigInteger =
        if (n < 2) {
            BigInteger.ONE
        } else {
            tailrec fun rec(num1: BigInteger, num2: BigInteger, index: Int): BigInteger {
                if (index < n) {
                    return rec(num2, num1 + num2, index + 1)
                }
                return num2
            }
            rec(BigInteger.ONE, BigInteger.ONE, 2)
        }

    fun dp(n: Int): BigInteger =
        if (n < 2) {
            BigInteger.ONE
        } else {
            val result = Array<BigInteger>(n) { BigInteger.ZERO }
            result[0] = BigInteger.ONE
            result[1] = BigInteger.ONE
            (2 until n).forEach {
                result[it] = result[it - 1] + result[it - 2]
            }
            result[n - 1]
        }
}


