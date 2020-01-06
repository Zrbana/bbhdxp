package design.mode.abstractFacory;



public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if(args.length!=1){
            System.out.println("Usage:java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1:java Main listFactory.ListFactory");
            System.out.println("Example 2:java Main tableFactory.TableFactory");
        }
        Afactory afactory = Afactory.getFactory(args[0]);

        Link people  =afactory.createLink("人民日报","http://www.people.com.cn/");
        Link gmw  =afactory.createLink("光明日报","http://www.gmw.cn/");

        Link us_yahoo =afactory.createLink("Yahoo","http://www.Yahoo.cn/");
        Link jp_yahoo  =afactory.createLink("Yahoo!japan","http://www.Yahoo.co.jp/");
        Link excite =afactory.createLink("Excite","http://www.excite.com/");
        Link google =afactory.createLink("Google","http://www.google.com/");

        Tray traynews = afactory.createTray("日报");
        traynews.add(people);
        traynews.add(gmw);

        Tray trayahoo = afactory.createTray("Yhoo");
        trayahoo.add(us_yahoo);
        trayahoo.add(jp_yahoo);

        Tray traysearch = afactory.createTray("检索引擎");
        traysearch.add(excite);
        traysearch.add(google);

        Page page = afactory.createPage("LinkPage","你某某某n");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}
