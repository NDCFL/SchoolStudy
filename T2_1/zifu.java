import java.util.Scanner;
public class zifu 
{
	public static void main(String[] args) 
	{
		/*
		�ַ����飺����\0��β
	*/
	char carray[3][80];
	char c[80];
	int i,j,len=0;
	int space=0,lettera=0,letterA=0,num=0,others=0;
	
	for(i=0;i<3;i++)
	{
		Scanner input = new Scanner(System.in);			
		System.out.println("������һ���ַ�");
		import java.util.Scanner;
		carray=input.nextInt();
	}
	//printf("%s,%d",c,len);
	for(i=0;i<3;i++)
	{
		//����,�ѵڶ����ַ�����������һ���ַ�����
		strcpy(c,carray[i]);
		//�����ַ����ĳ���
		len = strlen(c);
		for(j=0;j<len;j++)
		{
			if(carray[i][j]==32){ //�ո�
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
	System.out.println("�ո���%d��,Сд��ĸ��%d��,��д��ĸ��%d��,������%d��,������ĸ��%d��\n",space,lettera,letterA,num,others);
	}
}
