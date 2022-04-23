import javax.swing.*;
import java.awt.*;


public class Decorator extends JComponent {
    //    class contructor passing JComponent
    public Decorator(JComponent c) {
        setLayout(new GridLayout());
        add(c);
    }
}


