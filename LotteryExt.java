package com.dialpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

public class LotteryExt {
	

	

	public ArrayList<Integer> parseStringToIntArray(String parseArray) {
		if(parseArray.length()>14){
			return null;
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		HashSet<Integer> hashSet = new HashSet<Integer>(); 
		 boolean isSolutionExists=recursiveApproach(al ,hashSet,parseArray,7);
		 return isSolutionExists?al:null;
	}



	private boolean recursiveApproach(ArrayList<Integer> al, HashSet<Integer> hashSet, String parseArray,
			int i) {
		if(i==0){
			return true;
		}
		if(parseArray.length()<i){
			return false;
		}else if (parseArray.length()==i){
			HashSet<Integer> hs = new LinkedHashSet<Integer>();
			for(Character c:parseArray.toCharArray()){
				Integer cValue=Character.getNumericValue(c);
				if(hs.contains(cValue)){
					return false;
				}else{
					hs.add(cValue);
					
				}
			}
			al.addAll(hs);
			hashSet.addAll(hs);
			return true;
			
		}else{
				Integer firstElement=Character.getNumericValue(parseArray.charAt(0));
				Integer secondElement=Character.getNumericValue(parseArray.charAt(1));
				boolean solutionExists=false;
				int newElement;
				if(firstElement<6){
					newElement=firstElement*10+secondElement;
					solutionExists=logicToAddNewElement(al, hashSet, parseArray, i, newElement);
					if(solutionExists){
						return true;
					}
				}
				
				newElement=firstElement;
				return logicToAddNewElement(al, hashSet, parseArray, i, newElement);
				
			
		}
		

	}

	private boolean logicToAddNewElement(ArrayList<Integer> al, HashSet<Integer> hashSet, String parseArray, int i,
			Integer newElement) {
		boolean solutionExists;
		if(!hashSet.contains(newElement)){
			al.add(newElement);
			hashSet.add(newElement);			
			solutionExists=recursiveApproach(al, hashSet, newElement>9?parseArray.substring(2):parseArray.substring(1), i-1);
			if(solutionExists){
				return true;
			}
				al.remove(newElement);
				hashSet.remove(newElement);
		}
		return false;
	}
	

}
