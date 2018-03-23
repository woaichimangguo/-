package w;

public class d {

	
	private String str;
	private d rchild = null;
	private d lchild = null;
	
	public d(String str){
		this.str = str;
	}
	
	public d(String str, d lchild, d rchild){
		this.str = str;
		this.rchild = rchild;
		this.lchild = lchild;
	}
	
	public void setChild(d lchild, d rchild){
		this.lchild = lchild;
		this.rchild = rchild;
	}
	
	public d getRchild() {  
        return rchild;  
    }  
    public void setRchild(d rchild) {  
        this.rchild = rchild;  
    }  
    public d getLchild() {  
        return lchild;  
    }  
    public void setLchild(d lchild) {  
        this.lchild = lchild;  
    }
	
	public String getStr(){
		return str;
	}
	
	/**
	 * ��ȡÿ���ڵ�������������������
	 * 1)����Ϊ0
	 * 2)��������
	 * ����������������Ļ����������ת�����������������
	 * 
	 * @return result
	 */
	public String getResult(){
		if(hasChild()){
			switch(str){
				case "+":
					return String.valueOf(Integer.parseInt(getLchild().getResult()) + Integer.parseInt(getRchild().getResult()));
				case "-":
					return String.valueOf(Integer.parseInt(getLchild().getResult()) - Integer.parseInt(getRchild().getResult()));
				case "*":
					return String.valueOf(Integer.parseInt(getLchild().getResult()) * Integer.parseInt(getRchild().getResult()));
				case "/":
					if(getRchild().getResult().equals("0")){
						while(str.equals("/")){
							str = String.valueOf(s.getOperator());
						}
						return this.getResult();
					}
					else if(Integer.parseInt(getLchild().getResult()) % Integer.parseInt(getRchild().getResult()) != 0){
						while(str.equals("/")){
							str = String.valueOf(s.getOperator());
						}
						return this.getResult();
					}
					else
						return String.valueOf(Integer.parseInt(getLchild().getResult()) / Integer.parseInt(getRchild().getResult()));
			}
		}
		return str;
	}     
    
    /**
     * �ȶ�ÿ������ʽ������ţ�Ȼ�����ȥ���ŷ���ȥ���������ʽ������
     * 
     * @return string
     */
    public String toString(){
    	String Lstr = "", Rstr = "", Str = "";
    	if(hasChild()){
    		//����������к��ӣ�˵����������һ�����ʽ�����������ֽڵ㡣
    		if(getRchild().hasChild()){                         
    			//�ж��������ŵ�������Ƿ�Ϊ'/'
    			if(str.equals("/")){
    				//��ȡ�������ı��ʽ����������
    				Rstr = getRchild().toString();              
    			}
    			//�ж��������ŵ�������Ƿ�Ϊ'*'��'-'
    			else if(str.equals("*") || str.equals("-")){
    				//�ж�op�Ƿ�Ϊ'+'��'-'
    				if(getRchild().str.equals("+") || getRchild().str.equals("-")){	
    					Rstr = getRchild().toString();			
    				}
    				else{
    					//��ȡ�������ı��ʽ������ȥ���� 
    					Rstr = getRchild().toString().substring(1, getRchild().toString().length()-1);	
    				}
    			}
    			else{
    				//����������֮�ⶼ�ǿ���ȥ���ŵġ�
    				Rstr = getRchild().toString().substring(1, getRchild().toString().length()-1);		
    			}
    		}
    		else{
    			Rstr = getRchild().str;
    		}
    		//�����������ͬ����������
    		if(getLchild().hasChild()){												
    			if(str.equals("*") || str.equals("/")){
    				if(getLchild().str.equals("+") || getLchild().str.equals("-")){
    					Lstr = getLchild().toString();
    				}
    				else{
    					Lstr = getLchild().toString().substring(1, getLchild().toString().length()-1);
    				}
    			}
    			else{
    				Lstr = getLchild().toString().substring(1, getLchild().toString().length()-1);
    			}
    		}
    		else{
    			Lstr = getLchild().str;
    		}
    		//��ȡ��ǰ������ʽ������������
    		Str = "(" + Lstr + str + Rstr + ")"; 									
    	}
    	else{
    		//��û�к��ӣ�˵�������ֽڵ㣬ֱ�ӷ�������
    		Str = str;
    	}
    	return Str;
    }
    
    public boolean hasChild(){
    	if(lchild == null && rchild == null)
    		return false;
    	else
    		return true;
    }
}