public interface Function  {
  double Of ( double x );
}
abstract class aFunction implements Function {
  //public String toString ( String variable ) /
}
interface Differentiable extends Function {
  Differentiable derivative ();
}
interface Invertible extends Function {
  Invertible inverse();
}

class Constant extends aFunction implements Differentiable
{
  private double k;
  public Constant(double _k)
  {
    k = _k;
  }
  public double Of (double x)
  {
    return k;
  }
  public Differentiable derivative()
  {
    return new Constant(0);
  }
  public String stringForm(String variable)
  {
    return String.valueOf(k); //"f(x) = k"
  }
}
 


class Linear extends Polynomial implements Invertible {
  public Linear( double _m , double _b ) {
    super( new double[]{ _m , _b } );
  }
  public Invertible inverse() {
    double[] coeffs = getCoeffs();
    double m = coeffs[0] , b = coeffs[1];
    return new Linear ( 1.0 / m , - b / m );
  }
}
/*class Polynomial extends aFunction {
  private double[] coeffs;
  protected double[] getCoeffs() {
    return coeffs;
  }
  public Polynomial ( double[] _coeffs ) {
    coeffs = _coeffs;
  }
  public double Of ( double x ) {
    return 0.0;
  }
  public Differentiable derivative() {
    return null;
  }
}

class Sum extends aFunction implements Differentiable {
  private aFunction f;
  private aFunction g;
  Sum () {}
  public Sum ( Function _f , Function _g ) {
    f = (aFunction)_f;
    g = (aFunction)_g;
  }
  public double Of ( double x ) {
    return f.Of(x) + g.Of(x);
  }
  public Differentiable derivative ( ) {
    return new Sum ( ((Differentiable)f).derivative() ,
                    ((Differentiable)g).derivative() );
  }
}
class Difference extends Sum {
  public Difference ( Function _f , Function _g ) {
    super( _f , new Composition ( new Linear(-1.0 , 0 ) , _g ) );
  }
}
class Product extends aFunction implements Differentiable {
  private aFunction f;
  private aFunction g;
  Product () {}
  public Product ( Function _f , Function _g ) {
    f = (aFunction)_f;
    g = (aFunction)_g;
  }
  public double Of ( double x ) {
    return f.Of(x) * g.Of(x);
  }
  public Differentiable derivative ( ) {
    Function fprimeg = new Product( ((Differentiable)f).derivative() , g );
    Function fgprime = new Product( f , ((Differentiable)g).derivative() );
    return new Sum ( fprimeg , fgprime );
  }
}
class Rational extends Product {
  private aFunction f;
  private aFunction g;
  public Rational ( Function _f , Function _g ) {
    f = (aFunction)_f;
    g = (aFunction)_g;
  }
  public double Of ( double x ) {
    double denom = g.Of(x);
    if (denom == 0) {
      
      
      return Double.NaN;
    }
    else return f.Of(x) / g.Of(x);
  }
  public Differentiable derivative ( ) {
    Function fprimeg = new Product( ((Differentiable)f).derivative() , g );
    Function fgprime = new Product( f , ((Differentiable)g).derivative() );
    Function numer = new Difference( fprimeg , fgprime );
    Function denom = new Composition ( new Polynomial ( new double[]{2,0,0} ) , g );
    return new Rational ( numer , denom );
  }
}
class Composition extends aFunction implements Differentiable, Invertible {
  private aFunction f;
  private aFunction g;
  public Composition ( Function _f , Function _g ) {
    f = (aFunction)_f;
    g = (aFunction)_g;
  }
  public double Of ( double x ) {
    return f.Of(g.Of(x));
  }
  public Differentiable derivative() {
    return new Product( new Composition( ((Differentiable)f).derivative() , g ) ,
                       ((Differentiable)g).derivative() );
  }
  public Invertible inverse() {
    return new Composition(((Invertible)g).inverse() , ((Invertible)f).inverse());
  }
}
class Exponential extends aFunction implements Differentiable , Invertible {
  private double base;
  public Exponential ( ) {
    this( Math.E );
  }
  public Exponential ( double _base ) {
    base = _base;
  }
  public double Of (double x ) {
    return Math.pow( base , x );
  }
  public Differentiable derivative() {
    return new Composition ( new Linear(Math.log(base) , 0) , this );
  }
  public Invertible inverse() {
    return new Logarithmic ( base );
    
  }
}
class Logarithmic extends aFunction implements Differentiable , Invertible {
  private double base;
  public Logarithmic ( ) {
    this( Math.E );
  }
  public Logarithmic ( double _base ) {
    base = _base;
  }
  public double Of (double x ) {
    return Math.log( x )/Math.log(base);
  }
  public Differentiable derivative() {
    return new Rational ( new Constant(1) , new Linear ( Math.log(base) , 0 ) );
  }
  public Invertible inverse() {
    return new Exponential(base);
  }
}
class Sine extends aFunction implements Differentiable , Invertible {
  private double freq;
  private double shift;
  public Sine ( ) {
    this(1 , 0);
  }
  private Sine ( double _freq , double _shift ) {
    freq = _freq;
    shift = _shift;
  }
  public double Of ( double x ) {
    return Math.sin(freq*x + shift);
  }
  public Differentiable derivative() {
    // return new Cosine( freq , shift );
    return new Sine( freq , shift + Math.PI/2 );
  }
  public Invertible inverse() {
    return new Arcsine();
  }
}
class Arcsine extends Inverse {
  public Arcsine( ) {
    super( new Sine() );
    
  }
  public double Of ( double x ) {
    return Math.asin( x );
  }
}
abstract class Inverse extends aFunction implements Differentiable ,
  Invertible {
  private Invertible f;
  public Inverse ( Invertible _f ) {
    f = _f;
  }
  public Invertible inverse() {
    return f;
  }
  public Differentiable derivative() {
    if (!(f instanceof Differentiable))
    {
      throw UNDIFFERENTIABLE;
    }
  }
  protected static void ensureDifferentiable (Function f , Function g)
  {
    ensureDifferentiable(f);
    ensureDifferentiable(g);
  }
  private static final RuntimeException UNDIFFERENTIABLE = new RuntimeException("undifferentiable");
  
}*/
