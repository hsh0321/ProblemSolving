public class test{
    public static void main(String[] args) {
        parent p = new child();
        p.play();
    }
    StringBuilder sb;

}

class parent{
    void play(){
        System.out.println(1);
        this.show();
    }

    void show(){
        System.out.println(2);
    }
}

class child extends parent{
    void show(){
        System.out.println(3);
    }
}