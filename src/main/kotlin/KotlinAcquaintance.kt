import java.lang.IllegalArgumentException

//Тело выражение. Тип возвращаемого значения определяется компилятором
fun max(a: Int, b: Int) = if (a > b) a else b

//Тело блок. Тип возвращаемого значения должен быть указан явно
fun maxBlock(a: Int, b: Int): Int {
    return if (a > b){
        a
    }else{
        b
    }
}

fun main(args: Array<String>){
    //Переменные могут не иметь возвращаемого типа, однако, в таком случае, должны быть проинициализированы
    val a = 42
    val b: Int
    b = 23

    val name = if (args.isNotEmpty()) args[0] else "Kotlin!"
    println("Hello $name");

    val person = Person("BOb", true)
    println(person.toString())

    //Цикл for отличается от реализованного в java. Работает аналогично for-each с некоторыми дополнениями(понятие range)

    val range = 1..100 // это range от 1 до 100

    for (i in range){
        println(i)
    }

    //Есть возможность задавать шаг циклу, а также пускать его в обратном порядке
    for (i in 100 downTo 1 step 2){
        println(i)
    }

    //Чтобы исключить из перебора последнее значение итератора (аналог операции size - 1) используется оператор until
    for (i in 1 until 100 step 10){
        println(i)
    }

    //Есть возможность сохранять индекс при обходе массива, без создания отдельной переменной
    val listOfSomeThing = arrayListOf("10", "20", "30")
    for ((index, element) in listOfSomeThing.withIndex()){  //Метод withIndex() позволяет обходить коллекцию с сохранением индекса
        println("$index : $element")
    }

    println(recognize('a'))

    //реализация вызова метода позволяет прописывать именованные аргументы
    println(listOfSomeThing.joinToString(separator = "; ", prefix = "(", postfix = ")"))

    //Обращение к функции расширению работает как обычный вызов метода класса
    println("Hello world".lastChar())

    val user = User(1, "A", "B")
    saveUser(user)
    println(user.toString())
}

//Существует возможность вкладывать функции друг в друга. В том числе и с помощью функций расширений класса
class User(val id: Int, val name: String, val address: String){
    override fun toString(): String {
        return "User(id=$id, name='$name', address='$address')"
    }
}

fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User){
    user.validateBeforeSave()
}

//Проверка на вхождение в диапазон. Работает и с коллекциями, и со своими типами объектов. Вопрос только в реализации Comparable
fun recognize(c: Char) = when (c){
    in '1'..'9' -> "its a digit"
    in 'A'..'Z', in 'a'..'z' -> "its a letter"
    else -> "watafuckmazafaka"
}

//Есть возможность задавать значения по умолчанию прямо в сигнатуре метода
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String{
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

//Функция расширение создает метод для класса String и определили его поведение для объекта типа String черех this
fun String.lastChar(): Char = this.get(this.length - 1)

//Как определяется что именно isSquare должно вернуть значение. Скорее всего реализация метода get для property isSquare
//является инициалзацией этой переменной
class Rectangle(private val height: Int, private val width: Int){
    val isSquare = height == width
}

//Класс изначально public (Так называемый объект значение). Инициализация конструктора происходит по умолчанию
//Важно то, что пременные определённые как val доступны только для чтения, а var для чтения/записи
class Person(
    private val name: String,
    private val isMarried: Boolean){
    override fun toString(): String {
        return "Person(Name='$name', isMarried=$isMarried)"
    }
}



