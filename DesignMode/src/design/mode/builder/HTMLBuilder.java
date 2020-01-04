package design.mode.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLBuilder extends Builder
{
    private String filename;
    private PrintWriter writer;//用于编写文件的PrintWriter
    @Override
    public void makeTitle(String title) throws IOException {
        filename  = title+".html";
        writer = new PrintWriter(new FileWriter(filename));
        writer.println("<html><head><title>"+title+"</title></head><body>");//输出标题
        writer.println("<hl>"+title+"</hl>");
    }

    @Override
    public void makeString(String str) {

        writer.println("<p>"+str+"</p>");
    }

    @Override
    public void makeItems(String[] items) {

        writer.println("<ul>");
        for(int i=0;i<items.length;i++){
            writer.println("<li>"+items[i]+"</li>");
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {

        writer.println("</body></html>");
        writer.close();
    }
    public String getResult(){
        return filename;
    }
}
