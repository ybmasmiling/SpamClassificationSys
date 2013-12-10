package email_decode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import org.python.core.PyFunction;
import org.python.util.PythonInterpreter;

import org.python.util.PythonInterpreter;
import org.python.util.install.*;  
import org.python.core.*;
import org.python.core.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Decode_UI frame = new Decode_UI("中文垃圾邮件过滤系统", 700, 550);
        frame.setVisible(true);
        
        //解码按钮事件
        frame.OKbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		/*遍历文件夹*/
        		String filePath = frame.dictionaryText.getText();
        		try {
					dealFiles_decode(filePath);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
        	}
        });
        
        
        
        //退出按钮事件
        frame.Exitbtn.addActionListener(new ActionListener() {    
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}
	
	/**
	 * 邮件解码
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	private static void dealFiles_decode(String filePath) throws FileNotFoundException{
		File root = new File(filePath);    //打开指定路径的文件
		if(root.exists() && root.isDirectory()){    //若是文件夹则将里面的文件解码
			PythonInterpreter interpreter = new PythonInterpreter();  
			interpreter.execfile("F:\\MailProject\\lxc\\decodemail.py");
			PyFunction func = (PyFunction)interpreter.get("decodebody_str",PyFunction.class);
			
			//System.out.println(filePath);
			File dict = new File(filePath+"-decode");
			dict.mkdirs();
			//System.out.println(dict.getAbsolutePath());
			File[] files = root.listFiles();
			for(File file:files){
				Decode_Mail.decodeMail(file.getAbsolutePath(),dict.getAbsolutePath(),func);
			}
		}else{
			System.out.println("文件夹不存在！");
		}
	}
	
	private static void dealFiles_feature_extraction(String filePath){
		File root = new File(filePath);
		if(root.exists() && root.isDirectory()){    //若是文件夹则将里面的文件解码			
			System.out.println(root.getAbsolutePath());  //test(文件夹路径)
			File[] files = root.listFiles();
			for(File file:files){
			}
		}else{
			System.out.println("文件夹不存在！");
		}
	}
}

