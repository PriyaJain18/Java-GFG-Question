public class MedianOf2SortedArrays {
    
}


//naive approach  -> append both arrays-> sort the array formed  -> if(array.length == even) : return (mid+(mid+1)/2) ; else(//odd){ return mid } 
//Better Approach (O(Log N1)) -> divide all elements in 2 bags [left bag: lft from a1 and left from a2],similarly for right bag ; 
//note: left-bag-size = right-bag-size (in case total elements= even) 
//where n1<n2 size of 2 arrays respectively 