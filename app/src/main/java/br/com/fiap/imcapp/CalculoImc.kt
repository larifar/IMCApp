package br.com.fiap.imcapp

import kotlin.math.pow

fun calcularImc(peso: Double, altura: Double): Double {
    if(peso == 0.0 || altura == 0.0){
        return 0.0
    }
    return peso / (altura / 100).pow(2)
}

fun obterStatusImc(imc: Double): Pair<String,String> {
    return when {
        imc == 0.0 -> Pair("Insira dados", "cinza")
        imc < 18.5 -> Pair("Abaixo do peso", "vermelho")
        imc >= 18.5 && imc < 25.0 -> Pair("Peso Ideal", "verde")
        imc >= 25.0 && imc < 30.0 -> Pair("Levemente acima do peso", "amarelo")
        imc >= 30.0 && imc < 35.0 -> Pair("Obesidade Grau I", "vermelho")
        imc >= 35.0 && imc < 40.0 -> Pair("Obesidade Grau II", "vermelho")
        else -> Pair("Obesidade Grau III", "vermelho")
    }
}

fun parseStringToDouble(number: String):Double{
    return try {
        number.toDouble()
    } catch (e: NumberFormatException) {
        0.0
    }
}

fun pegarCor(cor: String): Int{
    return when (cor){
        "cinza" -> R.color.cinza_card
        "amarelo" -> R.color.amarelo_card
        "vermelho" -> R.color.vermelho
        "verde" -> R.color.verde_card
        else -> R.color.cinza_card
    }
}
