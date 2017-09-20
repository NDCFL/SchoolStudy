import java.util.Scanner;
public class zifu 
{
	public static void main(String[] args) 
	{
		/*
		字符数组：是以\0结尾
	*/
	char carray[3][80];
	char c[80];
	int i,j,len=0;
	int space=0,lettera=0,letterA=0,num=0,others=0;
	
	for(i=0;i<3;i++)
	{
		Scanner input = new Scanner(System.in);			
		System.out.println("请输入一串字符");
		import java.util.Scanner;
		carray=input.nextInt();
	}
	//printf("%s,%d",c,len);
	for(i=0;i<3;i++)
	{
		//拷贝,把第二个字符串拷贝到第一个字符串中
		strcpy(c,carray[i]);
		//计算字符串的长度
		len = strlen(c);
		for(j=0;j<len;j++)
		{
			if(carray[i][j]==32){ //空格
				space++;
			}else if(carray[i][j]>='a' && carray[i][j]<='z'){
				lettera++;
			}else if(carray[i][j]>='A' && carray[i][j]<='Z'){
				letterA++;
			}else if(carray[i][j]>='0' && carray[i][j]<='9'){
				num++;
			}else{
				others++;
			}
		}
	}
	System.out.println("空格有%d个,小写字母有%d个,大写字母有%d个,数字有%d个,其他字母有%d个\n",space,lettera,letterA,num,others);
	}
}
