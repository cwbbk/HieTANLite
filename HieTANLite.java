//----------Author: Cen Wan----------- 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;
import java.util.LinkedHashSet;


public class Hie_TAN_Lite_BP {

	public static String[][] ConditionalMI(String[][] TrainingDataset, ArrayList<String> PairOfVertices){
		String[][] TableCondMI = new String[PairOfVertices.size()+1][2];
		TableCondMI[0][0]="PairOfVertices";
		TableCondMI[0][1]="MutualInforValue";
		int tableRowIndex=1;
		
		for(int i=0; i<PairOfVertices.size(); i++){
			double MIValue=0;
			String VA=PairOfVertices.get(i).substring(0,PairOfVertices.get(i).indexOf("&"));
			String VB=PairOfVertices.get(i).substring(PairOfVertices.get(i).indexOf("&")+1);
			String C="class";
			   
			   double CountVA0VB0C1=0;
			   double CountVA0VB1C1=0;
			   double CountVA1VB0C1=0;
			   double CountVA1VB1C1=0;
			   double CountVA0VB0C0=0;
			   double CountVA0VB1C0=0;
			   double CountVA1VB0C0=0;
			   double CountVA1VB1C0=0;
			   double CountVA1C1=0;
			   double CountVA0C1=0;
			   double CountVB1C1=0;
			   double CountVB0C1=0;
			   double CountVA1C0=0;
			   double CountVA0C0=0;
			   double CountVB1C0=0;
			   double CountVB0C0=0;
			   double CondProbVA0VB0C1=0;
			   double CondProbVA0VB1C1=0;
			   double CondProbVA1VB0C1=0;
			   double CondProbVA1VB1C1=0;
			   double CondProbVA0VB0C0=0;
			   double CondProbVA0VB1C0=0;
			   double CondProbVA1VB0C0=0;
			   double CondProbVA1VB1C0=0;
			   double CondProbVA1C1=0;
			   double CondProbVA0C1=0;
			   double CondProbVB1C1=0;
			   double CondProbVB0C1=0;
			   double CondProbVA1C0=0;
			   double CondProbVA0C0=0;
			   double CondProbVB1C0=0;
			   double CondProbVB0C0=0;
			   double JointProbVA0VB0C1=0;
			   double JointProbVA0VB1C1=0;
			   double JointProbVA1VB0C1=0;
			   double JointProbVA1VB1C1=0;
			   double JointProbVA0VB0C0=0;
			   double JointProbVA0VB1C0=0;
			   double JointProbVA1VB0C0=0;
			   double JointProbVA1VB1C0=0;
			   
			   ArrayList<String> arrayListForColumnIndexC1 = new ArrayList<String>(); 
			   ArrayList<String> arrayListForColumnIndexC0 = new ArrayList<String>();
			   for(int column=1; column<TrainingDataset[0].length; column++){
				   if(TrainingDataset[TrainingDataset.length-1][column].equals("1")){
					   arrayListForColumnIndexC1.add(Integer.toString(column));
				   }else{
					   arrayListForColumnIndexC0.add(Integer.toString(column));
				   }
			   }
			   
			   for(int sss=1; sss<TrainingDataset.length; sss++){
				   if(TrainingDataset[sss][0].equals(VA)){
					   for(int rrr=0; rrr<arrayListForColumnIndexC1.size(); rrr++){
						   if(TrainingDataset[sss][Integer.parseInt(arrayListForColumnIndexC1.get(rrr))].equals("1")){
							   for(int rowVB=0; rowVB<TrainingDataset.length; rowVB++){
								   if(TrainingDataset[rowVB][0].equals(VB)){
									   if(TrainingDataset[rowVB][Integer.parseInt(arrayListForColumnIndexC1.get(rrr))].equals("1")){
										   CountVA1VB1C1++;
									   }else{
										   CountVA1VB0C1++;
									   }
								   }
							   }
						   }else{
							   for(int rowVB2=0; rowVB2<TrainingDataset.length; rowVB2++){
								   if(TrainingDataset[rowVB2][0].equals(VB)){
									   if(TrainingDataset[rowVB2][Integer.parseInt(arrayListForColumnIndexC1.get(rrr))].equals("0")){
										   CountVA0VB0C1++;
									   }else{
										   CountVA0VB1C1++;
									   }
								   }
							   }
						   }
					   }
				   }
			   }
			   
			   for(int sss=1; sss<TrainingDataset.length; sss++){
				   if(TrainingDataset[sss][0].equals(VA)){
					   for(int rrr=0; rrr<arrayListForColumnIndexC0.size(); rrr++){
						   if(TrainingDataset[sss][Integer.parseInt(arrayListForColumnIndexC0.get(rrr))].equals("1")){
							   for(int rowVB=0; rowVB<TrainingDataset.length; rowVB++){
								   if(TrainingDataset[rowVB][0].equals(VB)){
									   if(TrainingDataset[rowVB][Integer.parseInt(arrayListForColumnIndexC0.get(rrr))].equals("1")){
										   CountVA1VB1C0++;
									   }else{
										   CountVA1VB0C0++;
									   }
								   }
							   }
						   }else{
							   for(int rowVB2=0; rowVB2<TrainingDataset.length; rowVB2++){
								   if(TrainingDataset[rowVB2][0].equals(VB)){
									   if(TrainingDataset[rowVB2][Integer.parseInt(arrayListForColumnIndexC0.get(rrr))].equals("0")){
										   CountVA0VB0C0++;
									   }else{
										   CountVA0VB1C0++;
									   }
								   }
							   }
						   }
					   }
				   }
			   }
			   
			   for(int rowVA=1; rowVA<TrainingDataset.length; rowVA++){
				   if(TrainingDataset[rowVA][0].equals(VA)){
					   for(int rrr=0; rrr<arrayListForColumnIndexC1.size(); rrr++){
						   if(TrainingDataset[rowVA][Integer.parseInt(arrayListForColumnIndexC1.get(rrr))].equals("1")){
							   CountVA1C1++;
						   }else{
							   CountVA0C1++;
						   }
					   }
				   }
			   }
			   
			   for(int rowVB=1; rowVB<TrainingDataset.length; rowVB++){
				   if(TrainingDataset[rowVB][0].equals(VB)){
					   for(int rrr=0; rrr<arrayListForColumnIndexC1.size(); rrr++){
						   if(TrainingDataset[rowVB][Integer.parseInt(arrayListForColumnIndexC1.get(rrr))].equals("1")){
							   CountVB1C1++;
						   }else{
							   CountVB0C1++;
						   }
					   }
				   }
			   }
			
			   for(int rowVA=1; rowVA<TrainingDataset.length; rowVA++){
				   if(TrainingDataset[rowVA][0].equals(VA)){
					   for(int rrr=0; rrr<arrayListForColumnIndexC0.size(); rrr++){
						   if(TrainingDataset[rowVA][Integer.parseInt(arrayListForColumnIndexC0.get(rrr))].equals("1")){
							   CountVA1C0++;
						   }else{
							   CountVA0C0++;
						   }
					   }
				   }
			   }
			   
			   for(int rowVB=1; rowVB<TrainingDataset.length; rowVB++){
				   if(TrainingDataset[rowVB][0].equals(VB)){
					   for(int rrr=0; rrr<arrayListForColumnIndexC0.size(); rrr++){
						   if(TrainingDataset[rowVB][Integer.parseInt(arrayListForColumnIndexC0.get(rrr))].equals("1")){
							   CountVB1C0++;
						   }else{
							   CountVB0C0++;
						   }
					   }
				   }
			   }
			   
			   CondProbVA0VB0C1=(CountVA0VB0C1+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+4));
			   CondProbVA0VB1C1=(CountVA0VB1C1+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+4));
			   CondProbVA1VB0C1=(CountVA1VB0C1+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+4));
			   CondProbVA1VB1C1=(CountVA1VB1C1+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+4));
			   
			   CondProbVA0VB0C0=(CountVA0VB0C0+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()+4));
			   CondProbVA0VB1C0=(CountVA0VB1C0+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()+4));
			   CondProbVA1VB0C0=(CountVA1VB0C0+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()+4));
			   CondProbVA1VB1C0=(CountVA1VB1C0+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()+4));
			   
			   CondProbVA1C1=(CountVA1C1+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+2));
			   CondProbVA0C1=(CountVA0C1+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+2));
			   CondProbVB1C1=(CountVB1C1+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+2));
			   CondProbVB0C1=(CountVB0C1+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+2));
			   
			   CondProbVA1C0=(CountVA1C0+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()+2));
			   CondProbVA0C0=(CountVA0C0+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()+2));
			   CondProbVB1C0=(CountVB1C0+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()+2));
			   CondProbVB0C0=(CountVB0C0+1)/Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()+2));
			   
			   double PC1=Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()+1))/(Double.parseDouble(Integer.toString(arrayListForColumnIndexC1.size()))+Double.parseDouble(Integer.toString(arrayListForColumnIndexC0.size()))+2);
			   double PC0=1-PC1;
			   
			   JointProbVA0VB0C1=CondProbVA0VB0C1*PC1;
			   JointProbVA0VB1C1=CondProbVA0VB1C1*PC1;
			   JointProbVA1VB0C1=CondProbVA1VB0C1*PC1;
			   JointProbVA1VB1C1=CondProbVA1VB1C1*PC1;
			   
			   JointProbVA0VB0C0=CondProbVA0VB0C0*PC0;
			   JointProbVA0VB1C0=CondProbVA0VB1C0*PC0;
			   JointProbVA1VB0C0=CondProbVA1VB0C0*PC0;
			   JointProbVA1VB1C0=CondProbVA1VB1C0*PC0;
			   
			   double logVA0VB0C1=Math.log10(CondProbVA0VB0C1/(CondProbVA0C1*CondProbVB0C1))/Math.log10(2);
			   double logVA0VB1C1=Math.log10(CondProbVA0VB1C1/(CondProbVA0C1*CondProbVB1C1))/Math.log10(2);
			   double logVA1VB0C1=Math.log10(CondProbVA1VB0C1/(CondProbVA1C1*CondProbVB0C1))/Math.log10(2);
			   double logVA1VB1C1=Math.log10(CondProbVA1VB1C1/(CondProbVA1C1*CondProbVB1C1))/Math.log10(2);
			   
			   double logVA0VB0C0=Math.log10(CondProbVA0VB0C0/(CondProbVA0C0*CondProbVB0C0))/Math.log10(2);
			   double logVA0VB1C0=Math.log10(CondProbVA0VB1C0/(CondProbVA0C0*CondProbVB1C0))/Math.log10(2);
			   double logVA1VB0C0=Math.log10(CondProbVA1VB0C0/(CondProbVA1C0*CondProbVB0C0))/Math.log10(2);
			   double logVA1VB1C0=Math.log10(CondProbVA1VB1C0/(CondProbVA1C0*CondProbVB1C0))/Math.log10(2);
			   
			   
			   double CMIVA0VB0C1=JointProbVA0VB0C1*logVA0VB0C1;
			   double CMIVA0VB1C1=JointProbVA0VB1C1*logVA0VB1C1;
			   double CMIVA1VB0C1=JointProbVA1VB0C1*logVA1VB0C1;
			   double CMIVA1VB1C1=JointProbVA1VB1C1*logVA1VB1C1;
			   
			   double CMIVA0VB0C0=JointProbVA0VB0C0*logVA0VB0C0;
			   double CMIVA0VB1C0=JointProbVA0VB1C0*logVA0VB1C0;
			   double CMIVA1VB0C0=JointProbVA1VB0C0*logVA1VB0C0;
			   double CMIVA1VB1C0=JointProbVA1VB1C0*logVA1VB1C0;
			   
			   double CMIVAVBC=CMIVA0VB0C1+CMIVA0VB1C1+CMIVA1VB0C1+CMIVA1VB1C1+CMIVA0VB0C0+CMIVA0VB1C0+CMIVA1VB0C0+CMIVA1VB1C0;
			   
			   TableCondMI[tableRowIndex][0]=PairOfVertices.get(i);
			   TableCondMI[tableRowIndex][1]=Double.toString(CMIVAVBC);
			   tableRowIndex++;
			   
		}

		return TableCondMI;
	}


	public static String[][] HieTANLite(HashMap<String, String[]> allPathBPThreshold, String[][] CondMITableCTAN, String[][] trainingDataset8150, String[][] testDataset8150) throws IOException{

	    ArrayList<String> AveLazyCTAN = new ArrayList<String>(); 
	    ArrayList<String> SensLazyCTAN = new ArrayList<String>(); 
	    ArrayList<String> SpecLazyCTAN = new ArrayList<String>(); 
	    String [][] AveSensSpecConfusionM=new String[2][6];
		int truePositiveCTAN=0;
		int falseNagetiveCTAN=0;
		int falsePositiveCTAN=0;
		int trueNagetiveCTAN=0;
		int numberOfSelectedGOTerms=0;
		
		//--------replace GO:0008150 by GO:0003674 or GO:0005575 for MF or CC domains----------
		String[][] TestingDataset = new String[testDataset8150.length-1][testDataset8150[0].length];
		int rowIndex=0;
		for(int i=0; i<testDataset8150.length; i++){
			if(!testDataset8150[i][0].equals("GO:0008150")){
				for(int j=0; j<testDataset8150[0].length; j++){
					TestingDataset[rowIndex][j]=testDataset8150[i][j];
				}
				rowIndex++;
			}
		}
		
		//--------replace GO:0008150 by GO:0003674 or GO:0005575 for MF or CC domains----------
		String[][] TrainingDataset = new String[trainingDataset8150.length-1][trainingDataset8150[0].length];
 		int rowIndex2=0;
 		for(int i=0; i<trainingDataset8150.length; i++){
 			if(!trainingDataset8150[i][0].equals("GO:0008150")){
 				for(int j=0; j<trainingDataset8150[0].length; j++){
 					TrainingDataset[rowIndex2][j]=trainingDataset8150[i][j];
 				}
 				rowIndex2++;
 			}
 		}
 		
        HashMap<String, String[]> hmAncestors = new HashMap<String, String[]>();
        HashMap<String, String[]> hmDescendants = new HashMap<String, String[]>();
        ArrayList<String> arrayListAncestors= new ArrayList<String>();
        ArrayList<String> arrayListDescendants= new ArrayList<String>();
        
        for(int kkk=0; kkk<TrainingDataset.length-1; kkk++){
        	Set<Entry<String,String[]>> setpathForAllBPT5Selecting=allPathBPThreshold.entrySet();
	        Iterator<Entry<String, String[]>> itersetpathForAllBPT5Selecting = setpathForAllBPT5Selecting.iterator();
	        while(itersetpathForAllBPT5Selecting.hasNext()){
	        	Entry<String, String[]> entryitersetpathForAllBPT5Selecting = itersetpathForAllBPT5Selecting.next();
	            for(int jjj=0; jjj<entryitersetpathForAllBPT5Selecting.getValue().length; jjj++){
	            	if(TrainingDataset[kkk][0].equals(entryitersetpathForAllBPT5Selecting.getValue()[jjj])){
	            		for(int ppp=0; ppp<jjj; ppp++){
	            			arrayListAncestors.add(entryitersetpathForAllBPT5Selecting.getValue()[ppp]);
	            		}
	            		for(int ooo=entryitersetpathForAllBPT5Selecting.getValue().length-1; ooo>jjj; ooo--){
	            			arrayListDescendants.add(entryitersetpathForAllBPT5Selecting.getValue()[ooo]);
	            		}
	            	}
	            }
	        }
        	
	        String[]  arrayAncestorsTemp = new String[arrayListAncestors.size()];
	        arrayAncestorsTemp = arrayListAncestors.toArray(arrayAncestorsTemp);
	        for(int rrr=0; rrr<arrayAncestorsTemp.length; rrr++){
	        	if(!arrayAncestorsTemp[rrr].equals("D")){
	        	   for(int kjk=0; kjk<arrayAncestorsTemp.length; kjk++){
	        		   if(rrr!=kjk){
	        			  if(arrayAncestorsTemp[rrr].equals(arrayAncestorsTemp[kjk])){
	        				 arrayAncestorsTemp[kjk]="D";
	        			  }
	        		  }
	        	   }
	        	}
	        }
	        ArrayList<String> arrayListAncestorsNoDuplicated= new ArrayList<String>();
	        for(int sss=0; sss<arrayAncestorsTemp.length; sss++){
	        	if(!arrayAncestorsTemp[sss].equals("D")){
	        		arrayListAncestorsNoDuplicated.add(arrayAncestorsTemp[sss]);
	        	}
	        }
	        String[]  arrayAncestors = new String[arrayListAncestorsNoDuplicated.size()];
	        arrayAncestors = arrayListAncestorsNoDuplicated.toArray(arrayAncestors);
	        
	        hmAncestors.put(TrainingDataset[kkk][0], arrayAncestors);
	        arrayListAncestorsNoDuplicated.clear();
	        arrayListAncestors.clear();
	        //-------
	        
	        String[]  arrayDescendantsTemp = new String[arrayListDescendants.size()];
	        arrayDescendantsTemp = arrayListDescendants.toArray(arrayDescendantsTemp);
	        for(int rrr=0; rrr<arrayDescendantsTemp.length; rrr++){
	        	if(!arrayDescendantsTemp[rrr].equals("D")){
	        	   for(int kjk=0; kjk<arrayDescendantsTemp.length; kjk++){
	        		   if(rrr!=kjk){
	        			  if(arrayDescendantsTemp[rrr].equals(arrayDescendantsTemp[kjk])){
	        				  arrayDescendantsTemp[kjk]="D";
	        			  }
	        		  }
	        	   }
	        	}
	        }
	        ArrayList<String> arrayListDescendantsNoDuplicated= new ArrayList<String>();
	        for(int sss=0; sss<arrayDescendantsTemp.length; sss++){
	        	if(!arrayDescendantsTemp[sss].equals("D")){
	        		arrayListDescendantsNoDuplicated.add(arrayDescendantsTemp[sss]);
	        	}
	        }
	        String[]  arrayDescendants = new String[arrayListDescendantsNoDuplicated.size()];
	        arrayDescendants = arrayListDescendantsNoDuplicated.toArray(arrayDescendants);
	        
	        hmDescendants.put(TrainingDataset[kkk][0], arrayDescendants);
	        arrayListDescendantsNoDuplicated.clear();
	        arrayListDescendants.clear();
        	
        }
 		
        
        for(int columnIndex=1; columnIndex<TestingDataset[0].length; columnIndex++){
        	
        	String[][] testing_instance = new String[TestingDataset.length-1][2];
        	
        	for(int index_row=1; index_row<TestingDataset.length; index_row++){
        		testing_instance[index_row-1][0]=TestingDataset[index_row][0];
        	}
        	
        	for(int index_row=1; index_row<TestingDataset.length; index_row++){
        		testing_instance[index_row-1][1]=TestingDataset[index_row][columnIndex];
        	}
 		
			HashMap<String,String> hmCTANChildToSingleParent = LearningTAN(hmAncestors, hmDescendants, CondMITableCTAN, TrainingDataset, testing_instance);
			
			ArrayList<String> arrayListAllGOs = new ArrayList<String>();
	        HashMap<String,String[][]> hmCTANCPT = new HashMap<String, String[][]>();
			
	        Set<Entry<String,String>> sethmCTANChildToSingleParent=hmCTANChildToSingleParent.entrySet();
	        Iterator<Entry<String,String>> itersethmCTANChildToSingleParent = sethmCTANChildToSingleParent.iterator();  
	        while(itersethmCTANChildToSingleParent.hasNext()){
	        	Entry<String,String> entryitersethmCTANChildToSingleParent = itersethmCTANChildToSingleParent.next();
	        	String [] arrayChildSingleParent = new String[2]; 
	        	arrayChildSingleParent[0]=entryitersethmCTANChildToSingleParent.getKey();
	        	arrayChildSingleParent[1]=entryitersethmCTANChildToSingleParent.getValue();
	        	hmCTANCPT.put(arrayChildSingleParent[0], CTANcreateCPT(arrayChildSingleParent,TrainingDataset));
	        	arrayListAllGOs.add(arrayChildSingleParent[0]);
	        }
				
		 double proClassYes=0;
	   	 double proClassNo=0;
	   	 int countForLazyCTANClassYes=0;
	   	 double proForClass1=1;
	   	 double proForClass0=1;
	   	 
	   	 for(int columnTrainingDatasetForCalProC1=1; columnTrainingDatasetForCalProC1<TrainingDataset[0].length; columnTrainingDatasetForCalProC1++){
	   		if(TrainingDataset[TrainingDataset.length-1][columnTrainingDatasetForCalProC1].equals("1")){
	   			countForLazyCTANClassYes++;
	   		}
	   	 }
	   	 
	   	 proClassYes=(double)(countForLazyCTANClassYes+1)/(double)(TrainingDataset[0].length+1);
	   	 proClassNo=1-proClassYes;
	   	 
	        	String prediction;
	            ArrayList<String> arrayListParentForEachChildForTestingMethod = new ArrayList<String>(); 
	            for(int i=0; i<arrayListAllGOs.size(); i++){
	        	    int lengthOfCPTColumn = 0;
	        	    lengthOfCPTColumn =(hmCTANCPT.get(arrayListAllGOs.get(i)))[0].length-3;   
	                for(int addTimeOfGOsForEachCPT=0; addTimeOfGOsForEachCPT<lengthOfCPTColumn; addTimeOfGOsForEachCPT++){
	            	    arrayListParentForEachChildForTestingMethod.add(hmCTANCPT.get(arrayListAllGOs.get(i))[0][addTimeOfGOsForEachCPT]);
	                }
	            
	                ArrayList<String> arrayListValueParentForEachChildForTestingMethod = new ArrayList<String>(); 
	                for(int numGOsInCPT=0; numGOsInCPT<arrayListParentForEachChildForTestingMethod.size(); numGOsInCPT++){
	            	    for(int rowForMatrix=1; rowForMatrix<TestingDataset.length; rowForMatrix++){
	            		    if(arrayListParentForEachChildForTestingMethod.get(numGOsInCPT).equals(TestingDataset[rowForMatrix][0])){
	            		    	arrayListValueParentForEachChildForTestingMethod.add(TestingDataset[rowForMatrix][columnIndex]);
	            		    	break;
	            		    }
	            	    }
	                }
	               
	                ArrayList<String> arrayListParentForEachChildForTestingMethodForClass1 = new ArrayList<String>(); 
	                for(int indexOfOriginalArrayList11=0; indexOfOriginalArrayList11<arrayListParentForEachChildForTestingMethod.size(); indexOfOriginalArrayList11++){
	                	arrayListParentForEachChildForTestingMethodForClass1.add(arrayListParentForEachChildForTestingMethod.get(indexOfOriginalArrayList11));
	                }
	                arrayListParentForEachChildForTestingMethodForClass1.add("class");
	                
	                ArrayList<String> arrayListValueParentForEachChildForTestingMethodForClass1 = new ArrayList<String>(); 
	                for(int indexOfOriginalArrayList12=0; indexOfOriginalArrayList12<arrayListValueParentForEachChildForTestingMethod.size(); indexOfOriginalArrayList12++){
	                	arrayListValueParentForEachChildForTestingMethodForClass1.add(arrayListValueParentForEachChildForTestingMethod.get(indexOfOriginalArrayList12));
	                }
	                arrayListValueParentForEachChildForTestingMethodForClass1.add("1");
	                boolean markForCheckTheMisMatch = true;
	                for(int rowIndexForCPT=1; rowIndexForCPT<hmCTANCPT.get(arrayListAllGOs.get(i)).length; rowIndexForCPT++){
	                	markForCheckTheMisMatch = true;
	                	for(int columnIndexForCPT=0; columnIndexForCPT<hmCTANCPT.get(arrayListAllGOs.get(i))[0].length-2; columnIndexForCPT++){                
	                			if(!hmCTANCPT.get(arrayListAllGOs.get(i))[rowIndexForCPT][columnIndexForCPT].equals(arrayListValueParentForEachChildForTestingMethodForClass1.get(columnIndexForCPT))){
	                				markForCheckTheMisMatch=false;
	                				break;
	                			}
	                	}
	                	if(markForCheckTheMisMatch){
	                	   proForClass1=proForClass1*Double.parseDouble(hmCTANCPT.get(arrayListAllGOs.get(i))[rowIndexForCPT][lengthOfCPTColumn+2]);
	                	   break;
	                	}
	                }
	                
	                ArrayList<String> arrayListParentForEachChildForTestingMethodForClass0 = new ArrayList<String>(); 
	                for(int indexOfOriginalArrayList01=0; indexOfOriginalArrayList01<arrayListParentForEachChildForTestingMethod.size(); indexOfOriginalArrayList01++){
	                	arrayListParentForEachChildForTestingMethodForClass0.add(arrayListParentForEachChildForTestingMethod.get(indexOfOriginalArrayList01));
	                }
	                arrayListParentForEachChildForTestingMethodForClass0.add("class");
	                
	                ArrayList<String> arrayListValueParentForEachChildForTestingMethodForClass0 = new ArrayList<String>(); 
	                for(int indexOfOriginalArrayList02=0; indexOfOriginalArrayList02<arrayListValueParentForEachChildForTestingMethod.size(); indexOfOriginalArrayList02++){
	                	arrayListValueParentForEachChildForTestingMethodForClass0.add(arrayListValueParentForEachChildForTestingMethod.get(indexOfOriginalArrayList02));
	                }
	                arrayListValueParentForEachChildForTestingMethodForClass0.add("0");
	                boolean markForCheckTheMisMatchClass0 = true;
	                for(int rowIndexForCPT=1; rowIndexForCPT<hmCTANCPT.get(arrayListAllGOs.get(i)).length; rowIndexForCPT++){
	                	markForCheckTheMisMatchClass0 = true;
	                	for(int columnIndexForCPT=0; columnIndexForCPT<hmCTANCPT.get(arrayListAllGOs.get(i))[0].length-2; columnIndexForCPT++){
	                			if(!hmCTANCPT.get(arrayListAllGOs.get(i))[rowIndexForCPT][columnIndexForCPT].equals(arrayListValueParentForEachChildForTestingMethodForClass0.get(columnIndexForCPT))){
	                				markForCheckTheMisMatchClass0=false;
	                				break;
	                			}
	                	}
	                	if(markForCheckTheMisMatchClass0){
	                	   proForClass0=proForClass0*Double.parseDouble(hmCTANCPT.get(arrayListAllGOs.get(i))[rowIndexForCPT][lengthOfCPTColumn+2]);  
	                	   break;
	                	}
	                }
	                arrayListParentForEachChildForTestingMethod.clear();
	                arrayListValueParentForEachChildForTestingMethod.clear();
	                arrayListParentForEachChildForTestingMethodForClass1.clear();
	                arrayListValueParentForEachChildForTestingMethodForClass1.clear();
	                arrayListParentForEachChildForTestingMethodForClass0.clear();
	                arrayListValueParentForEachChildForTestingMethodForClass0.clear();
	                
	            }
	            
	            double proRootClass1=0;
	            int Root1Class1=0;
	            int Root0Class1=0;
	            double proRootClass0=0;
	            int Root1Class0=0;
	            int Root0Class0=0;
	            ArrayList<String> arrayListColumnIndexForClass1 = new ArrayList<String>(); 
	            ArrayList<String> arrayListColumnIndexForClass0 = new ArrayList<String>(); 
	            
	            
	            for(int q=1; q<TrainingDataset[0].length; q++){
	            	if(TrainingDataset[TrainingDataset.length-1][q].equals("1")){
	            		arrayListColumnIndexForClass1.add(Integer.toString(q));
	            	}else{
	            		arrayListColumnIndexForClass0.add(Integer.toString(q));
	            	}
	            }
	            
	            for(int x=1; x<TrainingDataset.length; x++){
	            		for(int fff=0; fff<arrayListColumnIndexForClass1.size(); fff++){
	            			if(TrainingDataset[x][Integer.parseInt(arrayListColumnIndexForClass1.get(fff))].equals("1")){
	            			   Root1Class1++;	
	            			}else{
	            			   Root0Class1++;
	            			}
	            		}
	            		for(int ooo=0; ooo<arrayListColumnIndexForClass0.size(); ooo++){
	            			if(TrainingDataset[x][Integer.parseInt(arrayListColumnIndexForClass0.get(ooo))].equals("1")){
	            			   Root1Class0++;	
	            			}else{
	            			   Root0Class0++;	
	            			}
	            		}
	            }
	            
	            double proRoot1Class1 = (double)(Root1Class1+1)/(double)(arrayListColumnIndexForClass1.size()+2);
	            double proRoot0Class1 = (double)(Root0Class1+1)/(double)(arrayListColumnIndexForClass1.size()+2);
	            double proRoot1Class0 = (double)(Root1Class0+1)/(double)(arrayListColumnIndexForClass0.size()+2);
	            double proRoot0Class0 = (double)(Root0Class0+1)/(double)(arrayListColumnIndexForClass0.size()+2);
	            
	            arrayListColumnIndexForClass1.clear();
	            arrayListColumnIndexForClass0.clear();
	            
	            String ValueOfRoot=null;
	           
	            
	            for(int hhh=0; hhh<TestingDataset.length; hhh++){
	            		ValueOfRoot = TestingDataset[hhh][columnIndex];
	            }
	            
	            if(ValueOfRoot.equals("1")){
	            	proRootClass1=proRoot1Class1;
	            	proRootClass0=proRoot1Class0;
	            }else{
	            	proRootClass1=proRoot0Class1;
	            	proRootClass0=proRoot0Class0;
	            }
	            
	            proForClass1=proForClass1*proClassYes*proRootClass1;
	            proForClass0=proForClass0*proClassNo*proRootClass0;
	            
                double PropClass1ForPRCurveNB=proForClass1/(proForClass1+proForClass0);
	        
	            if(proForClass1>proForClass0){
	               prediction="1";
	            }else{
	               prediction="0";
	            }
	            
	           
	            if(prediction.equals(TestingDataset[TestingDataset.length-1][columnIndex])){
	            	if(prediction.equals("1")){
	            		truePositiveCTAN++;
	            	}else{
	            		trueNagetiveCTAN++;	
	            	}
	            }else{
	            	if(prediction.equals("0")){ 	   
	            	   falseNagetiveCTAN++;	      	   
	            	}else{
	            	   falsePositiveCTAN++;   	
	            	}
	            }
	            
	            proForClass1 = 1;
	            proForClass0 = 1;
		}

	        
	        AveSensSpecConfusionM[0][0]="Average";
	        AveSensSpecConfusionM[0][1]="Sens";
	        AveSensSpecConfusionM[0][2]="Spec";
	        
	        AveSensSpecConfusionM[1][0]=(Double.toString(((double)truePositiveCTAN+(double)trueNagetiveCTAN)/((double)truePositiveCTAN+(double)trueNagetiveCTAN+(double)falsePositiveCTAN+(double)falseNagetiveCTAN)));
	      	 
	        if((truePositiveCTAN+falseNagetiveCTAN)!=0){
	       	 AveSensSpecConfusionM[1][1]=(Double.toString((double)truePositiveCTAN/(double)(truePositiveCTAN+falseNagetiveCTAN)));
	        }else{
	       	 AveSensSpecConfusionM[1][1]=("0");
	        }
	        
	        if(trueNagetiveCTAN+falsePositiveCTAN!=0){
	       	 AveSensSpecConfusionM[1][2]=(Double.toString((double)trueNagetiveCTAN/(double)(trueNagetiveCTAN+falsePositiveCTAN)));
	        }else{
	       	 AveSensSpecConfusionM[1][2]=("0");
	        }
	        
	        
	        AveSensSpecConfusionM[0][3]=Integer.toString(truePositiveCTAN);
	        AveSensSpecConfusionM[0][4]=Integer.toString(falseNagetiveCTAN);		 
	        AveSensSpecConfusionM[1][3]=Integer.toString(falsePositiveCTAN);
	        AveSensSpecConfusionM[1][4]=Integer.toString(trueNagetiveCTAN);
	        AveSensSpecConfusionM[0][5]=Integer.toString(numberOfSelectedGOTerms);
	        
	        return AveSensSpecConfusionM;
	       
	}
	
	
	
	public static HashMap<String,String> LearningTAN(HashMap<String, String[]> hmAncestors,HashMap<String, String[]> hmDescendants,String [][] CondMITable, String[][] TrainingDataset, String[][] testingInstance) throws IOException{

        ArrayList<String> arrayListForOrderedVertices = new ArrayList<String>(); 
		for(int jkl=1; jkl<CondMITable.length; jkl++){
			arrayListForOrderedVertices.add(CondMITable[jkl][0]);
		}
		
		
		HashMap<String,String> hmSelectionStatus = new HashMap<String,String>();
		HashMap<String,String> hmTestingValue = new HashMap<String,String>();
		
		for(int rowIndex=0; rowIndex<testingInstance.length-1; rowIndex++){
			hmSelectionStatus.put(testingInstance[rowIndex][0], "Avaliable");
			hmTestingValue.put(testingInstance[rowIndex][0], testingInstance[rowIndex][1]);
		}
		

		HashMap<String,String> hmTree = BuildTree(hmAncestors,hmDescendants,arrayListForOrderedVertices,CondMITable,hmSelectionStatus,hmTestingValue);
		
		return hmTree;
	}
	
	
	
		public static HashMap<String,String> BuildTree(HashMap<String, String[]> hmAncestors, HashMap<String, String[]> hmDescendants, ArrayList<String> arrayListForOrderedVertices, String[][] CondMITable, HashMap<String,String> hmSelectionStatus, HashMap<String,String> hmTestingValue) throws IOException{
		HashMap<String,ArrayList<String>> hmSetsOfVertices = new HashMap<String, ArrayList<String>>();
		HashMap<String,String[]> hmSetsOfDirectedVertices = new HashMap<String, String[]>();
		HashMap<String,String[]> hmSetsOfUndirectedVertices = new HashMap<String, String[]>();
		
		int SetIndex=1;
		
		for(int r=0; r<arrayListForOrderedVertices.size(); r++){
			
			boolean booleanCheckCycle=false;
			
			String VAEdge=arrayListForOrderedVertices.get(r).substring(0,arrayListForOrderedVertices.get(0).indexOf("&"));
			String VBEdge=arrayListForOrderedVertices.get(r).substring(arrayListForOrderedVertices.get(0).indexOf("&")+1);
			
	        boolean VAParIsVB2=false;
	        for(int i=0; i<hmAncestors.get(VAEdge).length; i++) {
	        	if(VBEdge.equals(hmAncestors.get(VAEdge)[i])) {
	        		VAParIsVB2=true;      		
	        		break;
	        	}
	        }
			
	        boolean VBParIsVA2=false;
	        for(int i=0; i<hmAncestors.get(VBEdge).length; i++) {
	        	if(VAEdge.equals(hmAncestors.get(VBEdge)[i])) {
	        		VBParIsVA2=true;
	        		break;
	        	}
	        }
			
	        boolean notHieRedundant=true;
	        if(VAParIsVB2 || VBParIsVA2){
	        	String valueVACheck=hmTestingValue.get(VAEdge);
	        	String valueVBCheck=hmTestingValue.get(VBEdge);
	        	if(valueVACheck.equals(valueVBCheck)){
	        		notHieRedundant=false;
	        	}
	        }
			
			if(hmSelectionStatus.get(VAEdge).equals("Avaliable")&&hmSelectionStatus.get(VBEdge).equals("Avaliable")&&notHieRedundant==true){
			
				if(hmSetsOfDirectedVertices.containsKey(VAEdge)||hmSetsOfUndirectedVertices.containsKey(VAEdge)) {
					booleanCheckCycle=CheckCycle(VAEdge, VBEdge, hmSetsOfDirectedVertices, hmSetsOfUndirectedVertices);
				}else {
					booleanCheckCycle=true;
				}
				
				if(booleanCheckCycle) {
				
				HashMap<String,String> hmParentVA = new HashMap<String, String>();
				HashMap<String,String> hmParentVB = new HashMap<String, String>();
				
		        boolean VAParIsVB=false;
		        for(int i=0; i<hmAncestors.get(VAEdge).length; i++) {
		        	if(VBEdge.equals(hmAncestors.get(VAEdge)[i])) {
		        		VAParIsVB=true;      		
		        		break;
		        	}
		        }
		        
		        boolean VBParIsVA=false;
		        for(int i=0; i<hmAncestors.get(VBEdge).length; i++) {
		        	if(VAEdge.equals(hmAncestors.get(VBEdge)[i])) {
		        		VBParIsVA=true;
		        		break;
		        	}
		        }
				
		        if(VAParIsVB||VBParIsVA) {
		        	if(VAParIsVB) {
		        		hmParentVA.put(VAEdge, VBEdge);
		        		hmParentVB.put(VBEdge, "No");
		        		
		        		boolean Check=CheckObey(VAEdge, VBEdge, hmParentVA, hmParentVB, hmSetsOfDirectedVertices, hmSetsOfUndirectedVertices);
		        		if(Check) {
		        				ArrayList<String> arrayListTempParent = new ArrayList<String>();
		        				arrayListTempParent.add(VBEdge);
		        				
		        		        String[]  arrayParents = new String[arrayListTempParent.size()];
		        		        arrayParents = arrayListTempParent.toArray(arrayParents);
		        		        arrayListTempParent.clear();
		        		        
		        				hmSetsOfDirectedVertices.put(VAEdge, arrayParents);
		        				
		        				if(hmTestingValue.get(VAEdge).equals("1")){
		        					for(int ancIndex=0; ancIndex<hmAncestors.get(VAEdge).length; ancIndex++){
		        						hmSelectionStatus.put(hmAncestors.get(VAEdge)[ancIndex], "No");
		        					}
		        				}else{
		        					for(int desIndex=0; desIndex<hmDescendants.get(VAEdge).length; desIndex++){
		        						hmSelectionStatus.put(hmDescendants.get(VAEdge)[desIndex], "No");
		        					}
		        				}
		        				
		        				if(hmTestingValue.get(VBEdge).equals("1")){
		        					for(int ancIndex=0; ancIndex<hmAncestors.get(VBEdge).length; ancIndex++){
		        						hmSelectionStatus.put(hmAncestors.get(VBEdge)[ancIndex], "No");
		        					}
		        				}else{
		        					for(int desIndex=0; desIndex<hmDescendants.get(VBEdge).length; desIndex++){
		        						hmSelectionStatus.put(hmDescendants.get(VBEdge)[desIndex], "No");
		        					}
		        				}
		        		}

		        		HashMap<String,HashMap<String,String[]>> hmWrap2Hashmap = new HashMap<String, HashMap<String,String[]>>();
		        		hmWrap2Hashmap.put("Directed", hmSetsOfDirectedVertices);
		        		hmWrap2Hashmap.put("Undirected", hmSetsOfUndirectedVertices);
		        		
		        		HashMap<String,HashMap<String,String[]>> hmWrap2Hashmap2=BPDependancy(hmWrap2Hashmap);
	                    
		        	}else {
		        		hmParentVB.put(VBEdge, VAEdge);
		        		hmParentVA.put(VAEdge, "No");
		        		
		        		boolean Check=CheckObey(VAEdge, VBEdge, hmParentVA, hmParentVB, hmSetsOfDirectedVertices, hmSetsOfUndirectedVertices);
		        		if(Check) {
		        				ArrayList<String> arrayListTempParent = new ArrayList<String>();
		        				arrayListTempParent.add(VAEdge);
		        				
		        		        String[]  arrayParents = new String[arrayListTempParent.size()];
		        		        arrayParents = arrayListTempParent.toArray(arrayParents);
		        		        arrayListTempParent.clear();
		        		        
		        				hmSetsOfDirectedVertices.put(VBEdge, arrayParents);
		        				
		        				if(hmTestingValue.get(VAEdge).equals("1")){
		        					for(int ancIndex=0; ancIndex<hmAncestors.get(VAEdge).length; ancIndex++){
		        						hmSelectionStatus.put(hmAncestors.get(VAEdge)[ancIndex], "No");
		        					}
		        				}else{
		        					for(int desIndex=0; desIndex<hmDescendants.get(VAEdge).length; desIndex++){
		        						hmSelectionStatus.put(hmDescendants.get(VAEdge)[desIndex], "No");
		        					}
		        				}
		        				
		        				if(hmTestingValue.get(VBEdge).equals("1")){
		        					for(int ancIndex=0; ancIndex<hmAncestors.get(VBEdge).length; ancIndex++){
		        						hmSelectionStatus.put(hmAncestors.get(VBEdge)[ancIndex], "No");
		        					}
		        				}else{
		        					for(int desIndex=0; desIndex<hmDescendants.get(VBEdge).length; desIndex++){
		        						hmSelectionStatus.put(hmDescendants.get(VBEdge)[desIndex], "No");
		        					}
		        				}
		        		}

		        		HashMap<String,HashMap<String,String[]>> hmWrap2Hashmap = new HashMap<String, HashMap<String,String[]>>();
		        		hmWrap2Hashmap.put("Directed", hmSetsOfDirectedVertices);
		        		hmWrap2Hashmap.put("Undirected", hmSetsOfUndirectedVertices);
		        		
		        		HashMap<String,HashMap<String,String[]>> hmWrap2Hashmap2=BPDependancy(hmWrap2Hashmap);
		        		
		        		
		        	}
		        }else {
		        	hmParentVA.put(VAEdge, "No");
		        	hmParentVB.put(VBEdge, "No");
		        	
		        	boolean Check=CheckObey(VAEdge, VBEdge, hmParentVA, hmParentVB, hmSetsOfDirectedVertices, hmSetsOfUndirectedVertices);
	        		if(Check) {
	        			if(hmSetsOfUndirectedVertices.get(VAEdge)!=null) {
	        				String[] debug=hmSetsOfUndirectedVertices.get(VAEdge);
	        				ArrayList<String> arrayListTempParent = new ArrayList<String>();
	        				for(int t=0; t<debug.length; t++) {
	        					arrayListTempParent.add(debug[t]);
	        				}
	        				arrayListTempParent.add(VBEdge);
	        				
	        		        String[]  arrayParents = new String[arrayListTempParent.size()];
	        		        arrayParents = arrayListTempParent.toArray(arrayParents);
	        		        arrayListTempParent.clear();
	        		        hmSetsOfUndirectedVertices.put(VAEdge, arrayParents);
	        		        
	        				if(hmTestingValue.get(VAEdge).equals("1")){
	        					for(int ancIndex=0; ancIndex<hmAncestors.get(VAEdge).length; ancIndex++){
	        						hmSelectionStatus.put(hmAncestors.get(VAEdge)[ancIndex], "No");
	        					}
	        				}else{
	        					for(int desIndex=0; desIndex<hmDescendants.get(VAEdge).length; desIndex++){
	        						hmSelectionStatus.put(hmDescendants.get(VAEdge)[desIndex], "No");
	        					}
	        				}
	        				
	        				if(hmTestingValue.get(VBEdge).equals("1")){
	        					for(int ancIndex=0; ancIndex<hmAncestors.get(VBEdge).length; ancIndex++){
	        						hmSelectionStatus.put(hmAncestors.get(VBEdge)[ancIndex], "No");
	        					}
	        				}else{
	        					for(int desIndex=0; desIndex<hmDescendants.get(VBEdge).length; desIndex++){
	        						hmSelectionStatus.put(hmDescendants.get(VBEdge)[desIndex], "No");
	        					}
	        				}
	        		        
	        			}else {
	        				ArrayList<String> arrayListTempParent = new ArrayList<String>();
	        				arrayListTempParent.add(VBEdge);
	        				
	        		        String[]  arrayParents = new String[arrayListTempParent.size()];
	        		        arrayParents = arrayListTempParent.toArray(arrayParents);
	        		        arrayListTempParent.clear();
	        		        
	        		        hmSetsOfUndirectedVertices.put(VAEdge, arrayParents);
	        		        
	        				if(hmTestingValue.get(VAEdge).equals("1")){
	        					for(int ancIndex=0; ancIndex<hmAncestors.get(VAEdge).length; ancIndex++){
	        						hmSelectionStatus.put(hmAncestors.get(VAEdge)[ancIndex], "No");
	        					}
	        				}else{
	        					for(int desIndex=0; desIndex<hmDescendants.get(VAEdge).length; desIndex++){
	        						hmSelectionStatus.put(hmDescendants.get(VAEdge)[desIndex], "No");
	        					}
	        				}
	        				
	        				if(hmTestingValue.get(VBEdge).equals("1")){
	        					for(int ancIndex=0; ancIndex<hmAncestors.get(VBEdge).length; ancIndex++){
	        						hmSelectionStatus.put(hmAncestors.get(VBEdge)[ancIndex], "No");
	        					}
	        				}else{
	        					for(int desIndex=0; desIndex<hmDescendants.get(VBEdge).length; desIndex++){
	        						hmSelectionStatus.put(hmDescendants.get(VBEdge)[desIndex], "No");
	        					}
	        				}
	        				
	        			}
	        			
	        			if(hmSetsOfUndirectedVertices.get(VBEdge)!=null) {
	        				String[] debug=hmSetsOfUndirectedVertices.get(VBEdge);
	        				ArrayList<String> arrayListTempParent = new ArrayList<String>();
	        				for(int t=0; t<debug.length; t++) {
	        					arrayListTempParent.add(debug[t]);
	        				}
	        				
	        				arrayListTempParent.add(VAEdge);
	        				
	        		        String[]  arrayParents = new String[arrayListTempParent.size()];
	        		        arrayParents = arrayListTempParent.toArray(arrayParents);
	        		        arrayListTempParent.clear();
	        		        hmSetsOfUndirectedVertices.put(VBEdge, arrayParents);
	        		        
	        				if(hmTestingValue.get(VAEdge).equals("1")){
	        					for(int ancIndex=0; ancIndex<hmAncestors.get(VAEdge).length; ancIndex++){
	        						hmSelectionStatus.put(hmAncestors.get(VAEdge)[ancIndex], "No");
	        					}
	        				}else{
	        					for(int desIndex=0; desIndex<hmDescendants.get(VAEdge).length; desIndex++){
	        						hmSelectionStatus.put(hmDescendants.get(VAEdge)[desIndex], "No");
	        					}
	        				}
	        				
	        				if(hmTestingValue.get(VBEdge).equals("1")){
	        					for(int ancIndex=0; ancIndex<hmAncestors.get(VBEdge).length; ancIndex++){
	        						hmSelectionStatus.put(hmAncestors.get(VBEdge)[ancIndex], "No");
	        					}
	        				}else{
	        					for(int desIndex=0; desIndex<hmDescendants.get(VBEdge).length; desIndex++){
	        						hmSelectionStatus.put(hmDescendants.get(VBEdge)[desIndex], "No");
	        					}
	        				}
	        			}else {
	        				ArrayList<String> arrayListTempParent = new ArrayList<String>();
	        				arrayListTempParent.add(VAEdge);
	        				
	        		        String[]  arrayParents = new String[arrayListTempParent.size()];
	        		        arrayParents = arrayListTempParent.toArray(arrayParents);
	        		        arrayListTempParent.clear();
	        		        
	        		        hmSetsOfUndirectedVertices.put(VBEdge, arrayParents);
	        		        
	        				if(hmTestingValue.get(VAEdge).equals("1")){
	        					for(int ancIndex=0; ancIndex<hmAncestors.get(VAEdge).length; ancIndex++){
	        						hmSelectionStatus.put(hmAncestors.get(VAEdge)[ancIndex], "No");
	        					}
	        				}else{
	        					for(int desIndex=0; desIndex<hmDescendants.get(VAEdge).length; desIndex++){
	        						hmSelectionStatus.put(hmDescendants.get(VAEdge)[desIndex], "No");
	        					}
	        				}
	        				
	        				if(hmTestingValue.get(VBEdge).equals("1")){
	        					for(int ancIndex=0; ancIndex<hmAncestors.get(VBEdge).length; ancIndex++){
	        						hmSelectionStatus.put(hmAncestors.get(VBEdge)[ancIndex], "No");
	        					}
	        				}else{
	        					for(int desIndex=0; desIndex<hmDescendants.get(VBEdge).length; desIndex++){
	        						hmSelectionStatus.put(hmDescendants.get(VBEdge)[desIndex], "No");
	        					}
	        				}
	        			}
		        		HashMap<String,HashMap<String,String[]>> hmWrap2Hashmap = new HashMap<String, HashMap<String,String[]>>();
		        		hmWrap2Hashmap.put("Directed", hmSetsOfDirectedVertices);
		        		hmWrap2Hashmap.put("Undirected", hmSetsOfUndirectedVertices);
		        		
		        		HashMap<String,HashMap<String,String[]>> hmWrap2Hashmap2=BPDependancy(hmWrap2Hashmap);
	        					
	        		}
		        }	 
			  }   
			}	
	   }
		
		
		
		//---------
		
		HashMap<String,HashMap<String,String[]>> hmWrap2HashmapLastStep = new HashMap<String, HashMap<String,String[]>>();
		hmWrap2HashmapLastStep.put("Directed", hmSetsOfDirectedVertices);
		hmWrap2HashmapLastStep.put("Undirected", hmSetsOfUndirectedVertices);
		
		HashMap<String,HashMap<String,String[]>> hmWrap2HashmapFinal=FinalDirection(hmWrap2HashmapLastStep);
		HashMap<String,String[]> hmSetsOfDirectedVerticesFinal=hmWrap2HashmapFinal.get("Directed");
        
        HashMap<String,String> hmTree = new HashMap<String, String>();
		Set<Entry<String,String[]>> sethmSetsOfDirectedVerticesFinal=hmSetsOfDirectedVerticesFinal.entrySet();
        Iterator<Entry<String,String[]>> itersethmSetsOfDirectedVerticesFinal = sethmSetsOfDirectedVerticesFinal.iterator();
        while(itersethmSetsOfDirectedVerticesFinal.hasNext()){
        	Entry<String,String[]> entryitersethmSetsOfDirectedVerticesFinal = itersethmSetsOfDirectedVerticesFinal.next();
        	hmTree.put(entryitersethmSetsOfDirectedVerticesFinal.getKey(), entryitersethmSetsOfDirectedVerticesFinal.getValue()[0]);
        }
        
		return hmTree;
	}
	
	
		public static boolean CheckObey(String VAEdge, String VBEdge, HashMap<String,String> hmParentVA, HashMap<String,String> hmParentVB, HashMap<String,String[]> hmSetsOfDirectedVertices, HashMap<String,String[]> hmSetsOfUndirectedVertices) {
		boolean Check=true;
		
		if(!hmParentVA.get(VAEdge).equals("No")||!hmParentVB.get(VBEdge).equals("No")) {
			if(hmParentVA.get(VAEdge).equals(VBEdge)) {
				if(hmSetsOfDirectedVertices.get(VAEdge)!=null) {
					Check=false;
					return Check;
				}
			}else {
				if(hmSetsOfDirectedVertices.get(VBEdge)!=null) {
					Check=false;
					return Check;
				}
			}
		}else {
			if(hmSetsOfDirectedVertices.get(VAEdge)!=null && hmSetsOfDirectedVertices.get(VBEdge)!=null) {
				Check=false;
				return Check;
			}else {
				Check=true;
				return Check;
			}
		}
		return Check;
	}
	
	
	
	public static HashMap<String,HashMap<String,String[]>> BPDependancy(HashMap<String,HashMap<String,String[]>> hmWraph2Hashmaps){
		HashMap<String,String[]> hmSetsOfDirectedVertices = hmWraph2Hashmaps.get("Directed");
		HashMap<String,String[]> hmSetsOfUndirectedVertices = hmWraph2Hashmaps.get("Undirected");
		
		boolean Iterative=false;
        Set<Entry<String,String[]>> sethmSetsOfDirectedVertices=hmSetsOfDirectedVertices.entrySet();
        Iterator<Entry<String, String[]>> itersethmSetsOfDirectedVertices = sethmSetsOfDirectedVertices.iterator();
        while(itersethmSetsOfDirectedVertices.hasNext()){
       	      Entry<String, String[]> entryitersethmSetsOfDirectedVertices = itersethmSetsOfDirectedVertices.next();
       	      if(entryitersethmSetsOfDirectedVertices.getValue().length!=0){
       	    	  ArrayList<String> arrayListundirectedPartnerVertex = new ArrayList<String>();
       	    	  String childVertex = entryitersethmSetsOfDirectedVertices.getKey();  
       	    	  if(hmSetsOfUndirectedVertices.containsKey(childVertex)){
       	    	     String[] undirectedPartnerVertex = hmSetsOfUndirectedVertices.get(childVertex);
       	    	     arrayListundirectedPartnerVertex = new ArrayList<String>(Arrays.asList(undirectedPartnerVertex));
       	    	  }
       	    	                    
                  for(int ppp=0; ppp<arrayListundirectedPartnerVertex.size(); ppp++){
                		  ArrayList<String> arrayListTemp100 = new ArrayList<String>();
                		  arrayListTemp100.add(childVertex);
	        		          String[]  arrayListTemp1001 = new String[arrayListTemp100.size()];
	        		          arrayListTemp1001 = arrayListTemp100.toArray(arrayListTemp1001);
	        		          arrayListTemp100.clear();
	        		          hmSetsOfDirectedVertices.put(arrayListundirectedPartnerVertex.get(ppp), arrayListTemp1001);
	        		          Iterative=true;
                  }
                  
                  if(Iterative){
              	      hmSetsOfUndirectedVertices.remove(childVertex);
                      for(int kkk=0; kkk<arrayListundirectedPartnerVertex.size(); kkk++){
                              String[] tempArray=hmSetsOfUndirectedVertices.get(arrayListundirectedPartnerVertex.get(kkk));
                              ArrayList<String> arrayListtemp = new ArrayList<String>(Arrays.asList(tempArray));
                              arrayListtemp.remove(childVertex);
              		          String[]  tempArray2 = new String[arrayListtemp.size()];
              		          tempArray2 = arrayListtemp.toArray(tempArray2);
              		          arrayListtemp.clear();
              		          if(tempArray2.length!=0) {
              		            hmSetsOfUndirectedVertices.put(arrayListundirectedPartnerVertex.get(kkk),tempArray2);
              		          }else {
              		        	hmSetsOfUndirectedVertices.remove(arrayListundirectedPartnerVertex.get(kkk));
              		          }
                      }
                 break;
                }
       	      }
        }
        
            if(Iterative) {
              	hmWraph2Hashmaps.put("Directed", hmSetsOfDirectedVertices);
              	hmWraph2Hashmaps.put("Undirected", hmSetsOfUndirectedVertices);
              	return BPDependancy(hmWraph2Hashmaps);
            }else {
        	    hmWraph2Hashmaps.put("Directed", hmSetsOfDirectedVertices);
        	    hmWraph2Hashmaps.put("Undirected", hmSetsOfUndirectedVertices);
        	    return hmWraph2Hashmaps;
            }
        
	}
	
	
	public static HashMap<String,HashMap<String,String[]>> FinalDirection(HashMap<String,HashMap<String,String[]>> hmWraph2Hashmaps){
		HashMap<String,String[]> hmSetsOfDirectedVertices = hmWraph2Hashmaps.get("Directed");
		HashMap<String,String[]> hmSetsOfUndirectedVertices = hmWraph2Hashmaps.get("Undirected");
		
		boolean Iterative=false;
		
		Set<Entry<String,String[]>> sethmSetsOfUndirectedVertices3=hmSetsOfUndirectedVertices.entrySet();
        Iterator<Entry<String,String[]>> itersethmSetsOfUndirectedVertices3 = sethmSetsOfUndirectedVertices3.iterator();
        while(itersethmSetsOfUndirectedVertices3.hasNext()){
        	Entry<String,String[]> entryitersethmSetsOfUndirectedVertices3 = itersethmSetsOfUndirectedVertices3.next();
    		String[] tempArray3=new String[1];
    	    tempArray3[0]=entryitersethmSetsOfUndirectedVertices3.getKey();
        	for(int t=0; t<entryitersethmSetsOfUndirectedVertices3.getValue().length; t++){
        	    hmSetsOfDirectedVertices.put(entryitersethmSetsOfUndirectedVertices3.getValue()[t], tempArray3);
        	    Iterative=true;
        	}
        	
            for(int kkk=0; kkk<entryitersethmSetsOfUndirectedVertices3.getValue().length; kkk++){
                  String[] tempArray=hmSetsOfUndirectedVertices.get(entryitersethmSetsOfUndirectedVertices3.getValue()[kkk]);
                  ArrayList<String> arrayListtemp = new ArrayList<String>(Arrays.asList(tempArray));
                  arrayListtemp.remove(tempArray3[0]);
		          String[]  tempArray2 = new String[arrayListtemp.size()];
		          tempArray2 = arrayListtemp.toArray(tempArray2);
		          arrayListtemp.clear();
		          if(tempArray2.length!=0) {
		            hmSetsOfUndirectedVertices.put(entryitersethmSetsOfUndirectedVertices3.getValue()[kkk],tempArray2);
		          }else {
		        	hmSetsOfUndirectedVertices.remove(entryitersethmSetsOfUndirectedVertices3.getValue()[kkk]);
		          }
            }
            hmSetsOfUndirectedVertices.remove(tempArray3[0]);
    	    break;
        }
        
        if(Iterative) {
          	hmWraph2Hashmaps.put("Directed", hmSetsOfDirectedVertices);
          	hmWraph2Hashmaps.put("Undirected", hmSetsOfUndirectedVertices);
        	return FinalDirection(hmWraph2Hashmaps);
        }else{
        	return hmWraph2Hashmaps;
        }
		
	}
	
	
  public static void main(String [] args) throws Exception{

	BufferedReader ReaderForData = null;
 	ReaderForData = new BufferedReader(new FileReader(".../CE-BP.txt"));
 	ArrayList<String> textForDataList = new ArrayList<String>();
 	String textForData = null;
 	
    for(int i=0; i<833; i++){
   	  textForDataList.add(textForData = ReaderForData.readLine());
    }
		
    String[] textForData2;
    textForData2 = new String[textForDataList.size()];
    textForData2 = textForDataList.toArray(textForData2);
	//-------------------------------------------------------------------------------------------------
	BufferedReader ReaderForFoldIndex = null;
	ReaderForFoldIndex = new BufferedReader(new FileReader(".../writerFoldsAllocation-CE-BP.txt"));
 	ArrayList<String> textForFoldIndexList = new ArrayList<String>();
 	String textForFoldIndex = null;
 	
    for(int i=0; i<528; i++){
   	  textForFoldIndexList.add(textForFoldIndex = ReaderForFoldIndex.readLine());
    }
		
    String[] textForFoldIndex2;
    textForFoldIndex2 = new String[textForFoldIndexList.size()];
    textForFoldIndex2 = textForFoldIndexList.toArray(textForFoldIndex2);
  //-------------------------------------------------------------------------------------------------
	BufferedReader ReaderForPaths = null;
 	ReaderForPaths = new BufferedReader(new FileReader(".../CE-Path-BP.txt"));
 	ArrayList<String> textForPathsList = new ArrayList<String>();
 	String textForPaths = null;
 	
    for(int i=0; i<436832; i++){
    	textForPathsList.add(textForPaths = ReaderForPaths.readLine());
    }
	
    String[] textForPaths2;
    textForPaths2 = new String[textForPathsList.size()];
    textForPaths2 = textForPathsList.toArray(textForPaths2);
    
    HashMap<String, String[]> hmAllPaths = new HashMap<String, String[]>();
    for(int pathIndex=0; pathIndex<textForPaths2.length; pathIndex++){
    	String[] tempStringArray=textForPaths2[pathIndex].split(",");
    	hmAllPaths.put(Integer.toString(pathIndex), tempStringArray);
    }
    
	String[][] ArrayDataFeatureValueOnly=new String[textForData2.length][textForData2[0].split("%").length];
	for(int i=0; i<textForData2.length; i++){
		String[] tempArrayRow=textForData2[i].split("%");
		for(int j=0; j<tempArrayRow.length; j++){
			ArrayDataFeatureValueOnly[i][j]=tempArrayRow[j];
		}
	}

	ArrayList<String> textForGeneList = new ArrayList<String>();
	HashMap<String,String> hmGene2FoldIndex = new HashMap<String, String>();
	for(int i=0; i<textForFoldIndex2.length; i++){
		hmGene2FoldIndex.put(textForFoldIndex2[i].split(",")[0], textForFoldIndex2[i].split(",")[1]);
		textForGeneList.add(textForFoldIndex2[i].split(",")[0]);
	}
    
     int counterForLoop = 1;
     
     for(int fold=0; fold<10; fold++){
    	 ArrayList<String> trainingGeneList = new ArrayList<String>();
    	 ArrayList<String> testingGeneList = new ArrayList<String>();
    	 for(int geneIndex=0; geneIndex<textForGeneList.size(); geneIndex++){
    		 if(hmGene2FoldIndex.get(textForGeneList.get(geneIndex)).equals(Integer.toString(fold))){
    			 testingGeneList.add(textForGeneList.get(geneIndex));
    		 }else{
    			 trainingGeneList.add(textForGeneList.get(geneIndex));
    		 }
    	 }

    	 System.out.println("hi");
    	 
      String[][] trainingDataset = new String[ArrayDataFeatureValueOnly.length][trainingGeneList.size()+1];
      String[][] testingDataset = new String[ArrayDataFeatureValueOnly.length][testingGeneList.size()+1];
      
      for(int rowIndex=0; rowIndex<ArrayDataFeatureValueOnly.length; rowIndex++){
    	  trainingDataset[rowIndex][0]=ArrayDataFeatureValueOnly[rowIndex][0];
    	  testingDataset[rowIndex][0]=ArrayDataFeatureValueOnly[rowIndex][0];
      }
      
      int debug=ArrayDataFeatureValueOnly[0].length;
      

      for(int rowIndex=0; rowIndex<ArrayDataFeatureValueOnly.length; rowIndex++){
          int trainingColumnIndex=1;
          int testingColumnIndex=1;
    	  for(int columnIndex=1; columnIndex<ArrayDataFeatureValueOnly[0].length; columnIndex++){
    		  boolean checkFoldStatus=false;
    		  for(int indexFoldGenes=0; indexFoldGenes<trainingGeneList.size(); indexFoldGenes++){
    			  if(ArrayDataFeatureValueOnly[0][columnIndex].equals(trainingGeneList.get(indexFoldGenes))){
    				  checkFoldStatus=true;
    				  break;
    			  }
    		  }
    		  if(checkFoldStatus==true){
    			  trainingDataset[rowIndex][trainingColumnIndex]=ArrayDataFeatureValueOnly[rowIndex][columnIndex];
    			  trainingColumnIndex++;
    		  }else{
    			  testingDataset[rowIndex][testingColumnIndex]=ArrayDataFeatureValueOnly[rowIndex][columnIndex];
    			  testingColumnIndex++;
    		  }
    	  }
      }

        //--------replace GO:0008150 by GO:0003674 or GO:0005575 for MF or CC domains----------
		ArrayList<String> arrayListForGONamesCTAN = new ArrayList<String>(); 
		for(int i1=1; i1<testingDataset.length-1; i1++){
			if(!testingDataset[i1][0].equals("GO:0008150")){
			   arrayListForGONamesCTAN.add(testingDataset[i1][0]);
			}
		}
	 
	    ArrayList<String> arrayListForPairOfVerticesCTAN = new ArrayList<String>(); 
		String PairOfVerticesCTAN=null;
		for(int i=0; i<arrayListForGONamesCTAN.size(); i++){
			for(int j=i+1; j<arrayListForGONamesCTAN.size(); j++){
			   PairOfVerticesCTAN=arrayListForGONamesCTAN.get(i)+"&"+arrayListForGONamesCTAN.get(j);
			   arrayListForPairOfVerticesCTAN.add(PairOfVerticesCTAN);
			}
		}
		
		String[][] CondMITableCTAN = ConditionalMI(trainingDataset, arrayListForPairOfVerticesCTAN);
		String[][] CondMITableCTAN2 = new String[CondMITableCTAN.length-1][2];
		
		for(int a=1; a<CondMITableCTAN.length; a++){
			CondMITableCTAN2[a-1][0]=CondMITableCTAN[a][0];
			CondMITableCTAN2[a-1][1]=CondMITableCTAN[a][1];
		}
		
        Arrays.sort(CondMITableCTAN2, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final double time1 = Double.parseDouble(entry1[1]);
                final double time2 = Double.parseDouble(entry2[1]);
                return Double.toString(time1).compareTo(Double.toString(time2));
            }
        });
		
        ArrayList<String> arrayListForScientificNotation = new ArrayList<String>();
        
        String[][] CondMITableCTAN3 = new String[CondMITableCTAN.length][2];
        CondMITableCTAN3[0][0]=CondMITableCTAN[0][0];
        CondMITableCTAN3[0][1]=CondMITableCTAN[0][1];
        int newIndex=1;
        for(int yyy=CondMITableCTAN2.length-1; yyy>-1; yyy--){
        	if(!CondMITableCTAN2[yyy][1].contains("E")){
        	    CondMITableCTAN3[newIndex][0]=CondMITableCTAN2[yyy][0];
        	    CondMITableCTAN3[newIndex][1]=CondMITableCTAN2[yyy][1];
        	    newIndex++;
        	}else{
        		arrayListForScientificNotation.add(CondMITableCTAN2[yyy][0]+"%"+CondMITableCTAN2[yyy][1]);
        	}
        }
        for(int fff=0; fff<arrayListForScientificNotation.size(); fff++){
        	String debug111=arrayListForScientificNotation.get(fff).split("%")[0];
        	String debug1111=arrayListForScientificNotation.get(fff).split("%")[1];
        	CondMITableCTAN3[newIndex][0]=arrayListForScientificNotation.get(fff).split("%")[0];
        	CondMITableCTAN3[newIndex][1]=arrayListForScientificNotation.get(fff).split("%")[1];
        	newIndex++;
        }


        String[][] HRMTANPlusResults=HieTANLite(hmAllPaths,CondMITableCTAN3,trainingDataset,testingDataset); 
        AveHRMTANPlus.add(HRMTANPlusResults[1][0]);
        SensHRMTANPlus.add(HRMTANPlusResults[1][1]);
        SpecHRMTANPlus.add(HRMTANPlusResults[1][2]);
        truePositiveHRMTANPlus=truePositiveHRMTANPlus+(Integer.parseInt(HRMTANPlusResults[0][3]));
        falseNegativeHRMTANPlus=falseNegativeHRMTANPlus+(Integer.parseInt(HRMTANPlusResults[0][4]));
        falsePositiveHRMTANPlus=falsePositiveHRMTANPlus+(Integer.parseInt(HRMTANPlusResults[1][3]));
        trueNegativeHRMTANPlus=trueNegativeHRMTANPlus+(Integer.parseInt(HRMTANPlusResults[1][4]));

        counterForLoop++;
        trainingGeneList.clear();
        testingGeneList.clear();
     
        writerEdgesHCTANPlus.write("Fold");
        writerEdgesHCTANPlus.newLine();
     
     }
        
     System.out.print("");
     double sumSens=0;
     for(int hhh=0; hhh<SensHRMTANPlus.size(); hhh++){
    	 sumSens=sumSens+Double.parseDouble(SensHRMTANPlus.get(hhh));
     }
     double aveSens=sumSens/10;
     double steSens=0;
     for(int hhh=0; hhh<SensHRMTANPlus.size(); hhh++) {
    	 steSens=steSens+(Double.parseDouble(SensHRMTANPlus.get(hhh))-aveSens)*(Double.parseDouble(SensHRMTANPlus.get(hhh))-aveSens);
     }
     steSens=Math.sqrt(steSens/9);
     steSens=steSens/Math.sqrt(10);
     
     double sumSpec=0;
     for(int hhh=0; hhh<SpecHRMTANPlus.size(); hhh++){
    	 sumSpec=sumSpec+Double.parseDouble(SpecHRMTANPlus.get(hhh));
     }
     double aveSpec=sumSpec/10;
     double steSpec=0;
     for(int hhh=0; hhh<SpecHRMTANPlus.size(); hhh++) {
    	 steSpec=steSpec+(Double.parseDouble(SpecHRMTANPlus.get(hhh))-aveSpec)*(Double.parseDouble(SpecHRMTANPlus.get(hhh))-aveSpec);
     }
     steSpec=Math.sqrt(steSpec/9);
     steSpec=steSpec/Math.sqrt(10);
     
     System.out.println("Sens: "+Double.toString(aveSens));
     System.out.println("err: "+Double.toString(steSens));
     System.out.println("Spec: "+Double.toString(aveSpec));
     System.out.println("err: "+Double.toString(steSpec));
     System.out.println("GMean: "+Double.toString(Math.sqrt(aveSens*aveSpec)));
     
     writerEdgesHCTANPlus.flush();
     writerEdgesHCTANPlus.close();
									    
									    
  }
  
  
  }
	
	
