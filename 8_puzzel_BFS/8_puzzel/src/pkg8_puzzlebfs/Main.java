/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8_puzzlebfs;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 *
 * @author Do Thi Thanh Mui
 */
public class Main {
   
	
	public static void main(String[] args) {
		System.out.println("\t\t\tBFS 8-PUZZLE");
		
		//long start = System.currentTimeMillis();
		LocalDateTime startTime = LocalDateTime.now();
		BFS bfs = new BFS("1","2","0","3","4","5","6","7","8");//trạng thái ban đầu
		boolean success = bfs.solve();
		LocalDateTime endTime = LocalDateTime.now();
		
		if(success)
		{
			
			
			
			
			
			
			
			
			
		   
			
		}
		else
		{
			System.err.println("Không được tìm thấy!");
		}
		

	}
	

}
