package problema10;

public class Turismo extends DePasajeros {
   private boolean asientoCama;
   private boolean serviBar;

   public Turismo() {
   }

   public Turismo(String marca, String numMotor, String placas, double costoCamion, int totalPasaj, boolean asientoCama, boolean serviBar) {
       super(marca, numMotor, placas, costoCamion, totalPasaj);
       this.asientoCama = asientoCama;
       this.serviBar = serviBar;
   }

   @Override
   public String toString() {
       StringBuilder res = new StringBuilder();
       res.append(super.toString());
       if(asientoCama)
           res.append("\nCuenta con asiento cama");
       if(serviBar)
           res.append("\nCuenta con servicio de bar");
       return res.toString();
   }
   
   public double calculaCostoServicio(double km){
       double ans;
       ans = super.calculaCostoServicio(km);
       if(serviBar)
           ans *= 1.05;
       if(asientoCama)
           ans *= 1.05;
       return ans;
   }
} 
    

