import com.rath.diffcalc.DiffCalc;

public class DiffCalcTest {

  public static void main(String[] args) {
    System.out.println("Running...");
    DiffCalc dc = new DiffCalc(args[0]);
    System.out.println("Beatmap: " + dc);
    System.out.println("Precision: " + dc.getDiff());
    
  }
}
