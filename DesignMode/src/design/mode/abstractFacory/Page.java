package design.mode.abstractFacory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;

public abstract class Page {
    protected String title;
    protected String author;
    protected ArrayList content = new ArrayList();
    public Page(String title,String author){
        this.title =title;
        this.author =author;
    }
    public void add(Item item){
        content.add(item);
    }

    public void output(){
        try{
            String filename = title+".html";
            Writer writer = new FileWriter(filename);
            writer.close();
            System.out.println(filename+"编写完成。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public abstract String makeHTML();
}
