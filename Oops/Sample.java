// class Test{
//     void m1(A a){
//         System.out.println("A version");
//     }
//     void m1(B b){
//         System.out.println("B version");
//     }

// }
class A {
    void print(char c) {
        System.out.println("A");
    }
    // void print(float a) {
    //     System.out.println(a);
    // }

}

class B extends A {
    void print(char c) {
        System.out.println("From B ");
    }

}

class Sample {
    public static void main(String[] args) {
        A b = new B();
        b.print('a');
    }
}