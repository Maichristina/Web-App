package soft_eng_demo.sbparent;


public class CalculateFinalGrade {
	Student examgrade = new Student() ;
	Student finalgrade= new Student();
	Student projectgrade= new Student();
	int per ;
	
	public CalculateFinalGrade (double examgrade,double finalgrade,double projectgrade,int per) {
		if (projectgrade<5.0){
			finalgrade= 0.0;
			
			
		}
		else if (projectgrade>=5.0) {
			if (examgrade<5.0) {
				finalgrade=0.0;
				
			}
			else if (examgrade>=5.0) {
				if (per==10) {
					finalgrade= 0.1*projectgrade + 0.9*examgrade;
				}
				else if(per==0) {
					finalgrade=  1.0*examgrade;
				}
				else if (per==20) {
					finalgrade= 0.2*projectgrade + 0.8*examgrade;
				}
				else if(per==30) {
					finalgrade= 0.3*projectgrade + 0.7*examgrade;
				}
				else if(per==40) {
					finalgrade= 0.4*projectgrade + 0.6*examgrade;
				}
				else if(per==50) {
					finalgrade= 0.5*projectgrade + 0.5*examgrade;
				}
				else if(per==60) {
					finalgrade= 0.6*projectgrade + 0.4*examgrade;
				}
				else if(per==70) {
					finalgrade= 0.7*projectgrade + 0.3*examgrade;
				}
				else if(per==80) {
					finalgrade= 0.8*projectgrade + 0.2*examgrade;
				}
				else if(per==90) {
					finalgrade= 0.9*projectgrade + 0.1*examgrade;
				}
				else if(per==100) {
					finalgrade= 1.0*projectgrade ;
				}
				
				
			}
		}
		
	}

		
	
	
}
