//tego pliku nie wolno zmieniać!!!
public class lab02
{
 public static void main(String args[])
 {
  //Rnd(N,k) 
//   N  ilość liczb
  //k - każda (z tych 'N') jest sumą 'k' liczb losowych z przedziału <0;1.0)
  Rnd x=new Rnd(10,100);
  x.Print();
  System.out.println("minimum = "+x.Min());
  System.out.println("maksimum = "+x.Max());
  System.out.println("avg = "+x.Average());
  x.Draw();
 }
}