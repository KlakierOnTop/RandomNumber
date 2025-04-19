import kotlin.random.Random

fun main() {
    greetPlayer()
    val randomNumber = Random.nextInt(1, 101)
    playGame(randomNumber)
    sayGoodbye()
}

fun greetPlayer() {
    println(" Witaj w grze 'Zgadnij liczbę'!")
    println(" Komputer wylosował liczbę z zakresu 1-100.")
    println(" Czy uda Ci się ją odgadnąć?")
}

fun playGame(targetNumber: Int) {
    var attempts = 0
    while (true) {
        val guess = getUserGuess()
        attempts++
        if (checkGuess(guess, targetNumber, attempts)) break
    }
}

fun getUserGuess(): Int {
    while (true) {
        print("Podaj swoją liczbę: ")
        val input = readLine()
        val number = input?.toIntOrNull()
        if (number != null) {
            return number
        } else {
            println("Niepoprawny format! Wprowadź liczbę całkowitą.")
        }
    }
}

fun checkGuess(guess: Int, target: Int, attempts: Int): Boolean {
    return when {
        guess < target -> {
            println("Za mało! Spróbuj większej liczby.")
            false
        }
        guess > target -> {
            println("Za dużo! Spróbuj mniejszej liczby.")
            false
        }
        else -> {
            println("Gratulacje Pizdo! Odgadłeś liczbę $target w $attempts próbach.")
            true
        }
    }
}

fun sayGoodbye() {
    println("Wypierdalaj zjebie do następnego")
}
