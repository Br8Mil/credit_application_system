package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Erro, the field cannot be empty.") val firstName: String,
    @field:NotEmpty(message = "Erro, the field cannot be empty.") val lastName: String,
    @field:CPF(message = "The CPF entered and invalid") val cpf: String,
    @field:NotNull(message = "Erro, the field cannot be empty.") val income: BigDecimal,
    @field:Email(message = "The email entered and invalid.") val email: String,
    @field:NotEmpty(message = "Erro, the field cannot be empty.") val password: String,
    @field:NotEmpty(message = "Erro, the field cannot be empty.") val zipCode: String,
    @field:NotEmpty(message = "Erro, the field cannot be empty.") val street: String
) {
    fun toEntety(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
