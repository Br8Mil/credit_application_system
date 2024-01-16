package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Erro, the field cannot be empty.") val creditValue: BigDecimal,
    @field:Future(message = "The chosen date must be in the future.") val dayFirstOfInstallment: LocalDate,
    val numberOfInstallment: Int,
    @field:NotNull(message = "Erro, the field cannot be empty.") val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )
}
