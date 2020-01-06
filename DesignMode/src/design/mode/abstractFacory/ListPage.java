package design.mode.abstractFacory;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>"+title+"</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<hl>"+title+"</hl>\n");
        buffer.append("<ul>\n");
        Iterator it = content.iterator();
        while(it.hasNext()){
            Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>"+"</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
