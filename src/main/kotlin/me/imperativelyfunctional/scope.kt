package me.imperativelyfunctional

class BankAccount(private val total: Int, var name: String = "default") {
    private var balance = total

    fun deposit(amount: Int) {
        balance += amount
    }

    fun withdraw(amount: Int) {
        balance -= amount
    }

    fun printBalance() {
        println("Account $name : $balance")
    }

    fun getBalance() = balance
}

fun main() {
    with()
}

private fun with() {
    with(BankAccount(100)) {
        deposit(10)
        withdraw(20)
        printBalance()
    }
}

private fun apply() {
    val bankAccount = BankAccount(100).apply {
        println("Initial balance is : ${getBalance()}")
    }

    with(bankAccount) {
        deposit(10)
        withdraw(20)
        printBalance()
    }
}

private fun also() {
    val bankAccount = BankAccount(100).also {
        println("Initial balance is : ${it.getBalance()}")
        it
    }

    with(bankAccount) {
        deposit(10)
        withdraw(20)
        printBalance()
    }
}

private fun let() {
    val bankAccount = BankAccount(100).let {
        println("Initial balance is : ${it.getBalance()}")
        it
    }

    with(bankAccount) {
        deposit(10)
        withdraw(20)
        printBalance()
    }
}

private fun run() {
    val bankAccount = BankAccount(100).run {
        println("Initial balance is : ${getBalance()}")
        this
    }

    with(bankAccount) {
        deposit(10)
        withdraw(20)
        printBalance()
    }
}