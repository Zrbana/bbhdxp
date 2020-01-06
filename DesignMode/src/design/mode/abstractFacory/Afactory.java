package design.mode.abstractFacory;

public abstract class Afactory {
    public static Afactory getFactory(String classname) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Afactory afactory = null;
        try{
            afactory  = (Afactory) Class.forName(classname).newInstance();

            }catch (Exception e){
            e.printStackTrace();
        }
        return afactory;
    }
    public abstract  Link createLink(String caption,String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title,String author);
}
