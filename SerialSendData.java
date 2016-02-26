

import jssc.SerialPort;
import jssc.SerialPortException;
import java.awt.*;
import java.awt.event.*;

class Serial
{

    Serial(String data)
    {
        SerialPort serialPort = new SerialPort("COM9");
        try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            String send="!"+data+"%";
            System.out.println(data+" successfully writen to port: " + serialPort.writeBytes(send.getBytes()));
            System.out.println("Port closed: " + serialPort.closePort());
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
    }
}

class SNAK extends Frame implements ActionListener
{
    Label l1;
    Button b1;
    TextField t1;
    SNAK(String s)
    {
        super(s);
        setVisible(true);
        setSize(700, 500);
        setLayout(new FlowLayout());
        setBackground(Color.yellow);
        addWindowListener(new WindowAdapter()
                                    {
                                        public void windowClosing(WindowEvent we)
                                        {
                                            System.exit(0);
                                        }
                                    });
         l1=new Label("ENTER MESSAGE:");
         t1=new TextField("enter text here..",15);
         b1=new Button("SEND MESSAGE TO DISPLAY");
         add(l1);
         add(t1);
         add(b1);
         b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae)
    {
        String read=t1.getText();
        Serial s=new Serial(read);
    }
}

public class SerialSendData
{
public static void main(String args[])
{
    SNAK s1=new SNAK("SNAK TERMINAL");
}
}
