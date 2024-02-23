public class GraphicsFactory {
    public static CarController createCC(){
        return new CarController();
    }
    public static DrawPanel createDP(int x, int y){
        return new DrawPanel(x,y);
    }
    public static CarView createCV(String framename,CarController carC){
        return new CarView(framename, carC);
    }
}
