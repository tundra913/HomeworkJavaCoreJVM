public class JvmComprehension { //этот класс ищет и подгружает ClassLoader(Application, Platform и Bootstrap),
    // далее происходит связывание, далее инициализация статических полей и методов класса (в памяти помещается в Metaspace)

    public static void main(String[] args) { //в момент вызова метода метода создается фрейм main в стеке
        int i = 1;                      // 1 инициализируется переменная, помещается в созданный фрейм main в стеке
        Object o = new Object();        // 2 создается объект, помещается в кучу, переменная этого объекта в стек во фрейм,
        // происходит связывание ссылок
        Integer ii = 2;                 // 3 создается объект Integer, помещается в кучу, переменная ii в стек
        printAll(o, i, ii);             // 4 создается фрейм prinAll в стеке, в него помещаются переменные o
        // (связвание ссылок с обджектом из кучи), i, ii, вызывается и исполняется метод printAll
        System.out.println("finished"); // 7 создается еще один фрейм println, вызывается и исполняется метод println из системных,
        // вывод в консоль текста finished
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 создается объект Integer в куче, а переменная инициализируется и
        // помещается в фрейм printAll, значение uselessVar = 700
        System.out.println(o.toString() + i + ii);  // 6 вызывается и исполняется метод println из системных, выводится в консоль Object@...12
        // создается новый фрейм println с переменными о(ссылка на Object), i, ii
    }
}
//сборщик мусора проверяет объекты в куче(Object, Integer) и удаляет, если они недостижимы.
