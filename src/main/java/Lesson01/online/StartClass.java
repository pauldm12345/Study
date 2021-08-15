package Lesson01.online;

//one-line

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 12.08.2021
 */

public class StartClass {

    public static int test = 50;

    public static void main(String[] args) {
//        System.out.println("Hello from JVM!!!");
//        System.out.print("Hello from JVM!!!");

//        String myString = "Hello!";
//        System.out.println(myString + " > " + myString + " JVM is Java Coll" + myString); //РєРѕРЅРєР°С‚РµРЅР°С†РёСЏ СЃС‚СЂРѕРє
//
//        //С†РµР»С‹Рµ С‡РёСЃР»Р°
//        byte myByte = 50; //-128..+127 (1byte)
//        short myShort = 400; //-32768..+32767 (2bytes)
//        int myInteger = 20000000; //-2.1mlrd..+2.1mlrd (4bytes) DEFAULT
//        long myLong = 3500000000L; //-2^63..+2^63 (8bytes)
//
//        //С‡РёСЃР»Р° СЃ С‚РѕС‡РєРѕР№
//        float myFloat = 15.35f; //<>.00000000 (4 bytes)
//        double myDouble = 15.35; //<>.0000000000000000 (8 bytes) DEFAULT
//
//        //char
//        char myChar = '_';
//
//        //boolean
//        boolean myBoolean = true; //=false; (1/0) (1 byte)
//
//        //Math-operations
//        //+,-,*,/,^ - in the school
//
//        float a = 150;
//        float b = 369;
//        System.out.println("Result: " + (a + b));

//        int qwerty = 100;
//
//        if (qwerty == 100) {
//            System.out.println("qwerty > 100");
//        } else {
//            System.out.println("qwerty < 100");
//        }
//
//        if (qwerty < 20) {
//            System.out.println("FAIL!");
//        }
//
//        if (qwerty >= 100) {
//            System.out.println(">100");
//        } else if (qwerty < 20) {
//            System.out.println("<20");
//        } else {
//            System.out.println("QWERTY");
//        }

//        String nameHusband = "Boris";
//        int cash = 1000;
//
//        methodTypeVoid(nameHusband);
//        methodTypeVoid("Alex");
//
//        int cashback = methodTypeReturned(nameHusband, cash);
//        System.out.println("Result return-method >>> " + methodTypeReturned(nameHusband, cash));
//        System.out.println("cashback = " + cashback);

        int a = 159;

        System.out.println("after = " + test);

        test = doSomething(a);

        System.out.println("before = " + test);

        String valueFromMethod = doSomething1();
        System.out.println(valueFromMethod);
        System.out.println(doSomething1());
    }

    public static int doSomething(int inputValue) {
        inputValue = 20;
        return 150;
    }

    public static String doSomething1() {
        return "Hello";
    }

//    public static void methodTypeVoid(String name) {
//        System.out.println(name + " go home");
//        System.out.println(name + " buy something");
//        System.out.println(name + " go to shop");
//    }
//
//    public static int methodTypeReturned(String name, int valueCash) {
//        System.out.println(name + " go home");
//        System.out.println(name + " buy something");
//        System.out.println(name + " go to shop");
//        return valueCash - 258;
//    }

}
