package crud;
public class Main {
    public static void main(String[] args) {
        try{
            MainForm form = new MainForm();
            form.setVisible(true);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }        
    }
}
