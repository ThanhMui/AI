/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8_puzzlebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Do Thi Thanh Mui
 */
public class BFS {
	Node top;
          int i_index= 1;
	Node currentNode;
        Node saveCurrentNode;
	Integer[][] goal = {{0,1,2},{3,4,5},{6,7,8}}; 
	Queue<Node> takeroot = new LinkedList<Node>(); 
        Queue<Node> saveQueue = new LinkedList<>(); 
         Integer[][] initState = new Integer[3][3]; 
	List<Node> edNodes = new ArrayList<>(); 
	public BFS(String... state)
	{
		int index = 0;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				
				if(state[index].equals("0")) {
					top = new Node(0, i, j,initState,"",0);
				}
				initState[i][j] = Integer.parseInt(state[index++]);
				
			}
		}
		top.setState(initState);
             takeroot.add(top);
             currentNode = takeroot.poll();
             System.out.println("Trạng thái ban đầu");
             printCurrentState();
	}
	
	public boolean solve()
	{
          
		boolean solved = false;
		takeroot.add(top);
		          System.out.println("OPEN={}");
                          System.out.println("CLOSE={}");
                          String open ="";
                          String close ="";
                        saveQueue.add(top);
                              
		while(!takeroot.isEmpty())
		{
//                    if(i_index==3){
//                        System.out.println("Tu trang thai S"+ (i_index-2)+"chuyenr qua trang thais");
//                    }
			
			currentNode = takeroot.poll();
                      saveCurrentNode=saveQueue.poll();
                      
                     // printCurrentState();
			edNodes.add(currentNode);
                        if(i_index<6){
                          System.out.println("Trang thai S"+i_index);
                          open+="S"+i_index+",";
                        }
                             
                             
			if(findGoal())
			{
                            if(i_index==6 ){
                               
                                 String[] parts = open.split(",");
                                open = open.replace("S2,", "");
                                 
                                         
                                           
                                     String[] partse = open.split(",");
                                      open = open.replace("S3,", "");
                                       System.out.println("Thêm S"+(i_index-2)+",S"+(i_index-1)+ " vào tập OPEN={"+open+"}");
                                 close+=parts[i_index-6]+",";
                                                                  close+=partse[i_index-6]+",";

                           System.out.println("Thêm S"+(i_index-4)+",S3"+" vào tập CLOSE={"+close+"}");
                            System.out.println("\n\n");
                                             System.out.println("Từ trạng thái S"+ (i_index-3)+" chuyển qua trạng thái");
                                            
                                        }
                             System.out.println("Trạng thái S"+i_index);
//                            printCurrentState();
				solved = true;
                               open+="S"+i_index+",";
				printCurrentState();
                                  System.out.println("Trạng thái S"+i_index+" là trạng thái đích");
                                System.out.println("Bài toán dừng!");
                                 String[] partsss = open.split(",");
                                open = open.replace("S4,", "");
                                 
                                         
                                           
                                     String[] partses = open.split(",");
                                      open = open.replace("S5,", "");
                                       System.out.println("Thêm S"+i_index+ " vào tập OPEN={"+open+"}");
                                    
                                 close+=partsss[i_index-6]+",";
                                  close+=partses[i_index-6]+",";
                                  
                           System.out.println("Thêm S"+(i_index-2)+",S"+(i_index-1)+" vào tập CLOSE={"+close+"}");
                           
                           ///FINISH
                            System.out.println("\n\n");
                            System.out.println("Tập OPEN={}");
                           String[] partsess = open.split(",");
                                      open = open.replace("S6,", "");
                                       close+=partsess[i_index-6]+",";
                                        System.out.println("Thêm S"+(i_index)+" vào tập CLOSE={"+close+"}");
                                        
                                        
                                        //cuối
                                        System.out.println("\n\n");
                                        System.out.println("Đường đi BFS của 8 Puzzle: BFS={"+close+"}");
                                        
                                        
				return solved;
			}
			else
			{
                            
                          
                                    
				printCurrentState();
                                
//                                  System.out.println("Them S"+i_index+"vào tập OPEN="+open);
////                                      String[] parts = open.split(",");
////                                      close+=parts[i_index-1]+",";
//                            System.out.println("Them S"+i_index+"vào tập CLOSE="+close);
                                     
                                      if(i_index==1 ){
                                           System.out.println("\n\n");
                                             System.out.println("Từ trạng thái S"+ (i_index)+" chuyển qua trạng thái");
                                            
                                              System.out.println("Thêm S"+i_index+" vào tập OPEN={"+open+"}");
                                      String[] partss = open.split(",");
                                      close+=partss[i_index-1]+",";
                                      
                            System.out.println("Tập CLOSE={}");
                                        }
                                     if(i_index==3 ){
                                          open = open.replace("S1,", "");
                                          System.out.println("Thêm S"+(i_index-1)+", S"+(i_index)+" vào tập OPEN={"+open+"}");
                                           
                                     String[] parts = open.split(",");
                                //   close+=parts[i_index-3]+",";
                           System.out.println("Them S"+(i_index-2)+" vào tập CLOSE={"+close+"}");
                                      System.out.println("\n\n");
                                             System.out.println("Từ trạng thái S"+ (i_index-1)+" chuyển qua trạng thái");
                                            
                                            // System.out.println("Tap closed:{S"+(i_index-2));
                                        }
                                       i_index++;
			}
			
			
			for(Node neighbor : currentNode.getNeighbors())
			{
				if(edNodes.indexOf(neighbor) == -1 && takeroot.contains(neighbor) == false)//khong chua trang thai da duyet
				{
					takeroot.add(neighbor);
                                       
                                        
					
				}
                             //   printCurrentState();
                              
			}
			currentNode.setNeighbors(null);
                        
                        
                       			//printCurrentState();
                                        
		}
                
		
		
		
		
		
		return solved;
	}

	private boolean findGoal() {
		boolean success = true;
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(!currentNode.getState()[i][j].equals(goal[i][j]))
				{
					success = false;
                                       
					break;
				}
						
			}
			if(success == true)
			{
                           
                                       
				break;
			}
			
		}
		
		return success;
	}
	private void printCurrentState() {
		System.out.println("Current state after: " + currentNode.getPathToGoal());
              
		for(int i = 0;i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print(currentNode.getState()[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public Integer[][] getInitialState() {
		return initState;
	}

	public void setInitialState(Integer[][] initialState) {
		this.initState = initialState;
	}

	public Node getRoot() {
		return top;
	}

	public void setRoot(Node root) {
		this.top = root;
	}

	public Node getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(Node currentNode) {
		this.currentNode = currentNode;
	}

	public Integer[][] getGoalState() {
		return goal;
	}

	public void setGoalState(Integer[][] goalState) {
		this.goal = goalState;
	}

	public Queue<Node> getFringe() {
		return takeroot;
	}

	public void setFringe(Queue<Node> fringe) {
		this.takeroot = fringe;
	}

	public List<Node> getExploredNodes() {
		return edNodes;
	}

	public void setExploredNodes(List<Node> exploredNodes) {
		this.edNodes = exploredNodes;
	}

	
	
	

    
}
