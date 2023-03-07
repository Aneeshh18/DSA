package inheri.java;

public class Box {
    double l;
    double h;
    double w;

    Box () {
        this.l = 1;
        this.h = 1;
        this.w = 1;
    }

    Box (double side){
        this.w = side;
        this.l = side;
        this.h = side;
    }

    Box (double l , double h, double w){
        this.l = l;
        this.h = h;
        this.w = w;
    }
    Box(Box old){
        this.h = old.h;
        this.l = old.l;
        this.w = old.w;
    }

    public void info(){
        System.out.println("Runnig the box");
    }
}
