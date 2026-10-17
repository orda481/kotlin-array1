//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    print("Сколько строк? ")
    val rows = readln().toInt()
    print("Сколько столбцов? ")
    val cols = readln().toInt()
    val arr = Array(rows) { IntArray(cols) }
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            while (true) {
                print("Введите трёхзначное число [$i][$j]: ")
                val num = readln().toInt()
                if (num < 100 || num > 999) {
                    println("Ошибка!")
                } else {
                    arr[i][j] = num
                    break
                }
            }
        }
    }
    println("\nМассив:")
    for (i in 0 until rows) {
        for (j in 0 until cols) print("${arr[i][j]}\t")
        println()
    }
    val used = BooleanArray(10)
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            var num = arr[i][j]
            while (num > 0) {
                used[num % 10] = true
                num = num / 10
            }
        }
    }
    var count = 0
    for (digits in 0..9) {
        if (used[digits]) count++
    }
    println("В массиве использовано $count различных цифр")
}