package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.python.antlr.PythonParser.flow_stmt_return;

public class UI extends JFrame{
	final int TEXTLENGTH=28;
	final String label="请输入文件夹路径";
	
	JLabel dictionaryLabel = new JLabel(label);
	JLabel fileLabel1=new JLabel(label);
	JLabel fileLabel3=new JLabel("请输入训练集文件.arff");
	JLabel fileLabel4=new JLabel("请输入测试集文件.arff");
	JLabel wordLabel=new JLabel("输入分类文件夹路径");
	JLabel arffLabel = new JLabel("请输入arff文件夹");
	
	JTextField dictionaryText = new JTextField(TEXTLENGTH);
	JTextField txtExtraction = new JTextField(TEXTLENGTH);
	JTextField txtDividewordText = new JTextField(TEXTLENGTH);
	JTextField txtTest1 = new JTextField(TEXTLENGTH);
	JTextField txtTest2 = new JTextField(TEXTLENGTH);
	JTextField txtArff = new JTextField(TEXTLENGTH);
	
	JButton btnEmailDecode = new JButton("邮件解码");
	JButton btnFeatureExtractionButton = new JButton("特征提取");
	JButton btnDivideWord=new JButton("分词处理");
	JButton Exitbtn = new JButton("退出");
	JButton btnTest = new JButton("实验");
	JButton btnArff = new JButton("合成arff");
	
	JPanel panelNorth=new JPanel();
	JPanel panelFileSource = new JPanel();//面板
    JPanel panelExtraction = new JPanel();
    JPanel panelWord=new JPanel();
    JPanel panelDivideWord = new JPanel();
    JPanel panelDivideWord2 = new JPanel();
    JPanel panelTest1 = new JPanel();
    JPanel panelTest2 = new JPanel();
    JPanel panelExit = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelTest = new JPanel();
    JPanel panelArff = new JPanel();
    
    JPanel panelRadioBtn = new JPanel();
    JRadioButton jrb1 = new JRadioButton("垃圾",true);
    JRadioButton jrb2 = new JRadioButton("非垃圾",false);
    ButtonGroup group = new ButtonGroup();
    
    public UI(){}
    
    public UI(String title,int height,int width){
    	this.setSize(width,height);
    	this.setTitle(title);
    	this.setLayout(new BorderLayout());
    	this.setVisible(true);
    	
    	group.add(jrb1);
    	group.add(jrb2);
    	panelRadioBtn.setLayout(new GridLayout(3,1));
    	panelRadioBtn.add(jrb1);
    	panelRadioBtn.add(jrb2);
    	
    	panelNorth.setLayout(new BorderLayout());
    	
    	panelFileSource.setLayout(new FlowLayout(FlowLayout.LEFT));
    	panelFileSource.add(dictionaryLabel);
    	panelFileSource.add(dictionaryText);
    	panelFileSource.add(btnEmailDecode);
    	panelNorth.add(panelFileSource,BorderLayout.NORTH);
    	   	
      	
    	panelExtraction.setLayout(new FlowLayout(FlowLayout.LEFT)); 	
    	panelExtraction.add(fileLabel1);
    	panelExtraction.add(txtExtraction);
    	panelExtraction.add(btnFeatureExtractionButton);
    	// 单选按钮
    	panelExtraction.add(panelRadioBtn);
    	panelNorth.add(panelExtraction,BorderLayout.CENTER);
        
    	panelWord.setLayout(new BorderLayout());   	
    	panelDivideWord.setLayout(new FlowLayout(FlowLayout.LEFT)); 	
    	panelDivideWord2.setLayout(new FlowLayout(FlowLayout.LEFT));
    	panelDivideWord2.add(wordLabel);
    	panelDivideWord2.add(txtDividewordText);
    	panelDivideWord2.add(btnDivideWord);
    	panelWord.add(panelDivideWord,BorderLayout.NORTH);
    	panelWord.add(panelDivideWord2,BorderLayout.CENTER);
    	panelNorth.add(panelWord,BorderLayout.SOUTH);
    	
        add(panelNorth,BorderLayout.NORTH);
        
        panelTest.setLayout(new BorderLayout());
        panelTest1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelTest1.add(fileLabel3);
        panelTest1.add(txtTest1);
        panelTest2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelTest2.add(fileLabel4);
        panelTest2.add(txtTest2);
        panelTest2.add(btnTest);
        
        panelTest.add(panelTest1,BorderLayout.NORTH);
        panelTest.add(panelTest2,BorderLayout.CENTER);
        panelCenter.add(panelTest,BorderLayout.NORTH);
        
        panelArff.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelArff.add(arffLabel);
        panelArff.add(txtArff);
        panelArff.add(btnArff);
        panelCenter.add(panelArff,BorderLayout.CENTER);
        
        add(panelCenter,BorderLayout.CENTER);
        
        
        panelExit.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelExit.add(Exitbtn);
   
        add(panelExit, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
