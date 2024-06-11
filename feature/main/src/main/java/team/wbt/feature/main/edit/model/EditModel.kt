package team.wbt.feature.main.edit.model

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

data class EditModel(
    // 거래처
    val title: String = "",
    // 금액
    val amount: String = "",
    // 분류: 수입, 지출, 이체
    val type: Transaction = Transaction.Income,
    // 카테고리
    val category: String = "",
    // 거래처
    val counterPart: String = "",
    // 입금 계좌, 결제 수단, 이체 계좌
    val paymentMethod: String = "",
    // 날짜
    val date: Date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
    // 메모
    val memo: String = "",
) {
    fun dateToString(): String {
        return SimpleDateFormat("yyyy년MM월dd일 hh시mm분").format(date)
    }
}

sealed interface Transaction {

    data object Income : Transaction

    data class Expense(
        // 예산에서 제외
        val excludeFromBudget: Boolean = false,
    ) : Transaction

    data object Transfer : Transaction

}