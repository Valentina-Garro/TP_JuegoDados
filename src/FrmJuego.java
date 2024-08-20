import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FrmJuego extends JFrame {
    
    JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas;
    Dado dado1, dado2;
    Random r = new Random();

    private int lanazmientos, cenas;


    public FrmJuego(){
        setTitle("Apostemos a los dados!");
        setSize(600,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        lblDado1 = new JLabel();
        lblDado2 = new JLabel();
        JLabel lbl1 = new JLabel();
        JLabel lbl2 = new JLabel();
        lblLanzamientos = new JLabel();
        lblCenas = new JLabel();
        JButton btnIniciar = new JButton();
        JButton btnLanzar = new JButton();

        dado1 = new Dado();
        dado2 = new Dado();

        //Instrucciones para cargar una Imágen y configurar etiquetas
        String rutaDado = "/imagenes/1.jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaDado));

        lblDado1.setIcon(imgDado);
        lblDado2.setIcon(imgDado);

        lblDado1.setBounds(10,10,imgDado.getIconWidth(),imgDado.getIconHeight());
        lblDado2.setBounds(20+imgDado.getIconWidth(),10,imgDado.getIconWidth(),imgDado.getIconHeight());

        //Configuraciones de etiquetas de texto
        lbl1.setText("Lanzamientos");
        lbl2.setText("Cenas");
        lbl1.setBounds(50+2*imgDado.getIconWidth(),10,100,25);
        lbl2.setBounds(160+2*imgDado.getIconWidth(),10,100,25);

        //lblLanzamientos.setText("0");
        lblLanzamientos.setBackground(new Color(0,0,0));
        lblLanzamientos.setForeground(new Color(51,255,0));
        lblLanzamientos.setBounds(50 + 2*imgDado.getIconWidth(),40,100,100);
        lblLanzamientos.setOpaque(true);
        lblLanzamientos.setFont(new Font("Tahoma",1,72));
        lblLanzamientos.setHorizontalAlignment(SwingConstants.CENTER);

        //lblCenas.setText("0");
        lblCenas.setBackground(new Color(0,0,0));
        lblCenas.setForeground(new Color(51,255,0));
        lblCenas.setBounds(160 + 2*imgDado.getIconWidth(),40,100,100);
        lblCenas.setOpaque(true);
        lblCenas.setFont(new Font("Tahoma",1,72));
        lblCenas.setHorizontalAlignment(SwingConstants.CENTER);

        //Inicialización de los contadores
        lanazmientos =0;
        cenas=0;
        mostrarContadores();

        // Configuración de los botónes
        btnIniciar.setText("Iniciar");
        btnIniciar.setBounds(10,150,100,25);
        btnIniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnIniciar_Click(e);
            }
        });

        btnLanzar.setText("Lanzar");
        btnLanzar.setBounds(120, 150, 100, 25);
        btnLanzar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnLanzar_Click(e);
            }
        });

        // Añadir los componentes al contenedor principal
        getContentPane().setLayout(null);
        getContentPane().add(lblDado1);
        getContentPane().add(lblDado2);
        getContentPane().add(lbl1);
        getContentPane().add(lbl2);
        getContentPane().add(lblLanzamientos);
        getContentPane().add(lblCenas);
        getContentPane().add(btnIniciar);
        getContentPane().add(btnLanzar);
    }

    //Método para manejar eventos
    private void btnIniciar_Click(ActionEvent e) {
        // Reinicia los contadores de Lanzamientos y Cenas a cero y actualiza
        lanazmientos = 0;
        cenas = 0;
        mostrarContadores();
    }

    private void btnLanzar_Click(ActionEvent e) {
        dado1.lanzar(r);
        dado2.lanzar(r);

        dado1.mostrar(lblDado1);
        dado2.mostrar(lblDado2);

        lanazmientos++;
        if (dado1.getNumero() + dado2.getNumero() >= 11) {
            cenas++;
        }

        mostrarContadores();
    }
    
    public void mostrarContadores() {
        lblLanzamientos.setText(String.valueOf(lanazmientos));
        lblCenas.setText(String.valueOf(cenas));

    }

   


}
