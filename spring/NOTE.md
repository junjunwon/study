## super
- 자신이 상속받는 부모의 생성자를 호출하는 메서드
- 자식클래스가 인스턴스를 생성하면, 인스턴스 안에는 자식 클래스의 고유 멤버 뿐만 아니라 부모 클래스의 모든 멤버까지 포함되어 있다.
- 부모클래스의 멤버를 초기화하기 위해서는 부모클래스의 생성자를 호출해야 하는데... 
- 보통은 자바 컴파일러가 super을 자동으로 생성해주지만, 
- 부모 클래스에 기본 생성자가 아닌 매개변수를 가지는 생성자가 있다면 자식클래스에 super가 자동으로 추가되지 않는다.
  - 이때 오버로딩 된 생성자에 맞춰 자식 클래스에 super(오버로딩된 매개변수만큼 추가)하여 부모클래스의 매개변수에 접근한다.

```java
class Parent {
    int a;
    Parent (int b) {
        a = b;
    } 
}
class Child extends Parent {
    int b;
    Child() {
        super(40);
        b = 20;
    }
}
```