package captchagenerate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.random.*;



public class captchagenerate extends JFrame {
	private JLabel CaptchaLabel;
	private JTextField captchaTextField;
	private JButton generateButton;
	private String generatedCaptcha;
	
     public captchagenerate() {
	setTitle("Captcha Generator");
	setSize(400,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	CaptchaLabel = new JLabel();
	captchaTextField = new JTextField(10);
	generateButton = new JButton("generate captcha");
	generateButton.setForeground(Color.RED);
	generateButton.setFont(new Font("Arial",Font.BOLD,20));
	
	generateButton.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
	    	   generatedCaptcha = generateCaptcha();
	    	   captchaTextField.setText(generatedCaptcha);
	       }
	});
	JPanel panel = new JPanel();
	panel.add(CaptchaLabel);
	panel.add(captchaTextField);
	panel.add(generateButton);
	add(panel);
}


	private String generateCaptcha() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder captcha = new StringBuilder();
		Random random = new Random();
		
	for(int i = 0;i < 6;i++) {
		char c = characters.charAt(random.nextInt(characters.length()));
		captcha.append(c);
	}
	return captcha.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          SwingUtilities.invokeLater(new Runnable() {
        	  public void run() {
        		  new captchagenerate().setVisible(true);
        		  
          }
          });
          
}
}