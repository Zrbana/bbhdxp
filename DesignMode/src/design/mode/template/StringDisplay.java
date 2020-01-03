package design.mode.template;

public class StringDisplay extends AbstractDisplay {

    private String string;
    private int width;
    public StringDisplay(String string){
        this.string = string;
        this.width = string.getBytes().length;
    }


    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|"+string+"|");
    }

    @Override
    public void close() {
        printLine();
    }

    public void printLine(){
        System.out.println("+");
        for(int i =0;i<width;i++){
            System.out.println("-");
        }
        System.out.println("+");
    }
}
