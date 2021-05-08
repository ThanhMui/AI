/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8_puzzlebfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Do Thi Thanh Mui
 */
public class Node {
    int i, j;
	
	Integer[][] state = new Integer[3][3];
        int indexs =1;
	List<Node> near = new ArrayList<>();
	String path = "";
	Integer costOfPath = 0;
        Integer nodeV;
	int searchDepth = 0;
	int maxSearchDepth = 0;
	public Node(Integer nodeVal, int i, int j, Integer[][] state, String pathToGoal,Integer costOfPath)
	{
		this.nodeV = nodeVal;
		this.i = i;
		this.j = j;
		this.state = state;
		this.path = pathToGoal;
		this.costOfPath = costOfPath;
		this.searchDepth = costOfPath;
	}
	
	
	



	private void getLeftNeighbor() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i, j1 = j - 1;
		Integer nodeValTemp;
		if(j - 1 >= 0)
		{
			nodeValTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(nodeValTemp, i1, j1, stateTemp, path+" ", costOfPath+1);
			near.add(tempNode);
		}
		
	}



	private void getRightNeighbor() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i, j1 = j + 1;
		Integer nodeValTemp;
		if(j + 1 < 3)
		{
			nodeValTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(nodeValTemp, i1, j1, stateTemp, path+" ", costOfPath+1);
			near.add(tempNode);
		}
		
	}
        private void getTopNeighbor() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i - 1, j1 = j;
		Integer nodeValTemp;
		if(i - 1 >= 0)
		{
			nodeValTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(nodeValTemp, i1, j1, stateTemp, path+"", costOfPath+1);
			near.add(tempNode);
		}
		
		
		
	}

	private void getBottomNeighbor() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i + 1, j1 = j;
		Integer nodeValTemp;
		if(i + 1 < 3)
		{
			nodeValTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(nodeValTemp, i1, j1, stateTemp, path+" ", costOfPath+1);
			near.add(tempNode);
		}
		
	}



	


	public Node() {
		super();
	}



	public void setState(Integer[][] state) {
		this.state = state;
	}



	public List<Node> getNeighbors()    
        {
           
		getTopNeighbor();
                
		getBottomNeighbor();
                
		getLeftNeighbor();
                 
		getRightNeighbor();
		return near;
	}


public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodeV == null) ? 0 : nodeV.hashCode());
		return result;
	}

public void setPathToGoal(String pathToGoal) {
		this.path = pathToGoal;
	}

public void setSearchDepth(int searchDepth) {
		this.searchDepth = searchDepth;
	}
	

	public void setNeighbors(List<Node> neighbors) {
		this.near = neighbors;
	}



	public void setNodeVal(Integer nodeVal) {
		this.nodeV = nodeVal;
	}

	public int getI() {
		return i;
	}

	

	public void setJ(int j) {
		this.j = j;
	}

	public Integer getNodeVal() {
		return nodeV;
	}
public String getPathToGoal() {
		return path;
	}


public Integer getCostOfPath() {
		return costOfPath;
	}



	


	public int getSearchDepth() {
		return searchDepth;
	}

	

	public Integer[][] getState() {
		return state;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (nodeV == null) {
			if (other.nodeV != null)
				return false;
		} else if (!nodeV.equals(other.nodeV))
			return false;
		return true;
	}



	


	
	public int getMaxSearchDepth() {
		return searchDepth+1;
	}

	public void setMaxSearchDepth(int maxSearchDepth) {
		this.maxSearchDepth = maxSearchDepth;
	}
	
}
