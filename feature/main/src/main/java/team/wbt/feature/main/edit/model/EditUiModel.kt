package team.wbt.feature.main.edit.model

import java.time.LocalDateTime

data class EditUiModel(
    // 거래처
    val title: String = "",
    // 금액
    val amount: String = "",
    // 분류: 수입, 지출, 이체
    val type: Transaction = Transaction.Income(),
)

sealed class Transaction {
    // 금액
    abstract val amount: String
    // 카테고리
    abstract val category: String
    // 거래처
    abstract val counterPart: String
    // 날짜
    abstract val date: LocalDateTime
    // 메모
    abstract val memo: String

    data class Income(
        override val amount: String = "",
        override val category: String = "",
        override val counterPart: String = "",
        override val date: LocalDateTime = LocalDateTime.now(),
        override val memo: String = "",
    ) : Transaction()

    data class Expense(
        override val amount: String = "",
        override val category: String = "",
        override val counterPart: String = "",
        override val date: LocalDateTime = LocalDateTime.now(),
        override val memo: String = "",
        // 결제 수단
        val paymentMethod: String,
        // 예산에서 제외
        val excludeFromBudget: Boolean = false,
    ) : Transaction()

    data class Transfer(
        override val amount: String = "",
        override val category: String = "",
        override val counterPart: String = "",
        override val date: LocalDateTime = LocalDateTime.now(),
        override val memo: String = "",
        // 계좌
        val account: String = "",
    ) : Transaction()

}