package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class IntArithmeticsTest {

    @DisplayName("PLUS 연산을 적용하면, 더하기가 된다.")
    @Test
    fun plus() {
        val left = 2
        val right = 3
        assertThat(IntArithmetics.PLUS.apply(left, right))
            .isEqualTo(5)
    }

    @DisplayName("MINUS 연산을 적용하면, 빼기가 된다.")
    @Test
    fun minus() {
        val left = 2
        val right = 3
        assertThat(IntArithmetics.MINUS.apply(left, right))
            .isEqualTo(-1)
    }

    @DisplayName("TIMES 연산을 적용하면, 곱하기가 된다.")
    @Test
    fun times() {
        val left = 5
        val right = 4
        assertThat(IntArithmetics.MULTIPLY.apply(left, right))
            .isEqualTo(20)
    }

    @DisplayName("DIVIDES 연산을 적용하면, 나누기가 된다.")
    @Test
    fun divides() {
        val left = 20
        val right = 2
        assertThat(IntArithmetics.DIVIDE.apply(left, right))
            .isEqualTo(10)
    }

    @DisplayName("0으로 나누려고 하면 IllegalException 이 발생한다.")
    @Test
    fun divideBy0() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { IntArithmetics.DIVIDE.apply(1, 0) }
            .withMessage("숫자는 0으로 나눌 수 없습니다.")
    }

    @DisplayName("지원하지 않은 연산자에 대해서는 IllegalException 이 발생한다.")
    @Test
    fun illegalOperator() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { IntArithmetics.from("%") }
            .withMessage("허용되지 않은 연산자 입니다.")
    }

    @DisplayName("정적 팩토리는 입력받은 문자와 연관된 연산자를 반환해야한다.")
    @Test
    fun from() {
        assertAll({
            assertThat(IntArithmetics.from("+"))
                .isEqualTo(IntArithmetics.PLUS)
        }, {
            assertThat(IntArithmetics.from("-"))
                .isEqualTo(IntArithmetics.MINUS)
        }, {
            assertThat(IntArithmetics.from("×"))
                .isEqualTo(IntArithmetics.MULTIPLY)
        }, {
            assertThat(IntArithmetics.from("÷"))
                .isEqualTo(IntArithmetics.DIVIDE)
        })
    }
}
