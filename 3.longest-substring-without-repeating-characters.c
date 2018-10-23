/*
** author:adminsun
*/

int lengthOfLongestSubstring(char* s) {    
    int i, j, k, isRepeat;    
	int temp, maxlen = -1;    
	int len = strlen(s);      
	for(i = 0; i < len; i++) //循环每个字符    
	{        
		j = i + 1;        
		temp = 1;        
		isRepeat = 0;//出现重复字符就置1        
		while(j < len && isRepeat == 0)
			//从i的下一个字符开始统计s[i]字符的最长不重复字串        
			{            
				k = i;            
				while(k < j)
				//j和i~j-1的每个字符做比较，不等才能字串长+1            
				{                
					if(s[j] != s[k])    
						k++;                
					else{                    
						isRepeat = 1;                    
						break;                
					}            
				}            
				if(k == j)
					{
						//当前j所对应字符第一次出现                
						j++;                
						temp++;            
					}                  
			}        
			maxlen = maxlen > temp?maxlen:temp;    
		}    
		return maxlen;    
}